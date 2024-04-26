package cl.tracktec.conductores.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "conductor")
@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Conductor extends BaseEntity{

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

    @OneToMany(mappedBy = "conductor")
    private Set<Conduccion> conducciones = new HashSet<>();

    @ManyToMany(mappedBy = "conductores")
    private Set<DispositivoIdentificacion> dispositivosIdentificacion = new HashSet<>();
}
