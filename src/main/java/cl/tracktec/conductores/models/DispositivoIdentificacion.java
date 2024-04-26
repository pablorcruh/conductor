package cl.tracktec.conductores.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "dispositivo_identificacion")
public class DispositivoIdentificacion extends BaseEntity{

    @ManyToMany
    @JoinTable(
            name="conductor_dispositivo_identificacion",
            joinColumns = @JoinColumn(name = "conductor_id"),
            inverseJoinColumns = @JoinColumn(name = "dispositivo_identificacion_id")
    )
    private Set<Conductor> conductores = new HashSet<>();
}
