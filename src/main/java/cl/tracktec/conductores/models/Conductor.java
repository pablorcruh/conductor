package cl.tracktec.conductores.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "conductor")
@NoArgsConstructor
@Data
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    private String rut;
    @Column
    private String dni;
    @Column
    private String apellido;
    @Column
    private String nombre;
    @Column
    private String correoElectronico;
    @Column
    private String numeroTelefonico;
    @Column
    private Date fechaVencimientoAcreditacion;
    @Column
    private Date fechaVencimientoLicencia;
    @Column
    private String codigoIdentificacion;
    @Column
    private String idDispositivoIdentificador;

}
