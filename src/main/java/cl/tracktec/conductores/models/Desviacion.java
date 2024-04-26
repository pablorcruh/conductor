package cl.tracktec.conductores.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "desviacion")
@NoArgsConstructor
@Getter
@Setter
public class Desviacion extends Entidad {



  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;


  @OneToOne
  private Conductor conductor;

  @OneToOne
  private RecursoVehiculo RecursoVehiculo;


  @Column
  private LocalDateTime fechaInicio;

  @Column
  private LocalDateTime fechaTermino;

  @Column
  private String puntajeAvg;


  @OneToMany
  private List<EventoVehiculo> eventoVehiculoList;
}
