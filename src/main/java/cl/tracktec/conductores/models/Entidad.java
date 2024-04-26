package cl.tracktec.conductores.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.Data;


@Data
public class Entidad implements Serializable {



  /**
   * String con UUID vacío para entidades.
   */
  public static final String VOID_ID_STR = "00000000-0000-0000-0000-000000000000";

  /**
   * UUID vacío para entidades.
   */
  public static final UUID VOID_ID = UUID.fromString(VOID_ID_STR);

  /**
   * UID de (de)serialización.
   */
  private static final long serialVersionUID = -8722904278741187718L;

  /**
   * Identificador lógico de entidad.
   */
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private UUID id = null;

  /**
   * Fecha y hora de creación de esta entidad <i>en la base de datos</i>.
   */
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private OffsetDateTime creacion = null;

  /**
   * Fecha y hora de registro de última modificación de esta entidad <i> en
   * la base de datos</i>.
   */
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private OffsetDateTime actualizacion = null;

  /**
   * Indica si la entidad está disponible para operaciones actuales y
   * futuras.
   *
   * <p>Una entidad inactiva solo existe en la base de datos con el fin de
   * mantener la consistencia de datos históricos.</p>
   */
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Boolean activo = null;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String nombre = null;


}
