package cl.tracktec.conductores.config;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@Data
@Slf4j
@ConfigurationProperties(value = "application.properties", ignoreUnknownFields = false)
public class DatabaseConfig {

    @Value("${datasource.usesecretsmanager}")
    private boolean useSecretsManager;

    /**
     * URL de la base de datos.
     */
    @Value("${datasource.url}")
    private String url;

    /**
     * Nombre de usuario para conexión a la base de datos.
     */
    @Value("${datasource.username}")
    private String username;

    /**
     * Contraseña para conexión a la base de datos.
     */
    @Value("${datasource.password}")
    private String password;

    /**
     * Nombre de secreto a acceder en AWS Secrets Manager.
     */
    @Value("${datasource.secretsmanager.key}")
    private String secretsManagerKey;

    /**
     * Región a usar para conexión con AWS Secrets Manager.
     */
    @Value("${datasource.secretsmanager.region}")
    private String secretsManagerRegion;

    @Bean
    public DataSource getDataSource() {
        setDataSourceConfig();

        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setUsername(getUsername());
        config.setPassword(getPassword());
        config.setJdbcUrl(getUrl());
        return new HikariDataSource(config);
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

    private void setDataSourceConfig() {
        if (useSecretsManager) {
            GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(secretsManagerKey);
            AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard().withRegion(secretsManagerRegion).build();
            GetSecretValueResult getSecretValueResult = null;

            try {
                getSecretValueResult = client.getSecretValue(getSecretValueRequest);
            } catch (DecryptionFailureException | InternalServiceErrorException |
                     InvalidParameterException | InvalidRequestException | ResourceNotFoundException e) {
                log.error("Error obteniendo credenciales de base de datos de entidades", e);
                throw e;
            }
            // Decrypts secret using the associated KMS CMK.
            if (getSecretValueResult.getSecretString() != null) {
                JSONObject secret = new JSONObject(getSecretValueResult.getSecretString());
                setPassword(secret.getString("password"));
                setUsername(secret.getString("username"));
                // the database uses a user conductor and the database is called conductor
                //setUrl("jdbc:postgresql://" + secret.getString("host") + "/" + secret.getString("username"));
                setUrl("jdbc:postgresql://" + secret.getString("host") + "/conductores");
                log.info("URL: {}", url);
                log.info("Username: {}", username);
            }
        }
    }
}
