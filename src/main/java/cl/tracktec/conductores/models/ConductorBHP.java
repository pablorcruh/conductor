package cl.tracktec.conductores.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.LocalDateTime;

@Entity
@Table(name = "conductor_bhp")
@NoArgsConstructor
@Getter
@Setter
public class ConductorBHP extends Entidad {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column
  private String rut;

  @Column
  private String dni;

  @Column
  private String nombre;

  @Column
  private String apellido;
  
  @Column
  private LocalDateTime fechaNacimiento;

  @Column
  private String correoConductor;

  @Column
  private String tipoLicencia;

  @Column
  private LocalDateTime vencimientoAcreditacion;

  @Column
  private LocalDateTime fechaVencimientoLicencia;

  @Column
  private String identificadorDeConductor;
  @Column
  private String identificadorDeConductor2;

  @Column
  private String empresaMandante;

  @Column
  private String empresaContratista;

  @Column
  private String operacion;

  @Column
  private String faenOAsset;

  @Column
  private String admContrato;

  @Column
  private String telAdmContrato;

  @Column
  private String centroAdmContrato;

  @Column
  private String correoAdmContrato;

  @Column
  private String supervisor;

  @Column
  private String telSuperior;

  @Column
  private String correoSuperior;

  @Column
  private String gerencia;

  @Column
  private String superintendente;

  @Column
  private String estado;

  @Column
  private String accion;

}
