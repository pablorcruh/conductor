package cl.tracktec.conductores.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "recurso_vehiculo")
@NoArgsConstructor
@Getter
@Setter
public class RecursoVehiculo extends Entidad{
}
