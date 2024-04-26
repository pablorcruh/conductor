package cl.tracktec.conductores.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Conduccion extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;
}
