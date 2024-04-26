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

@Entity
@Table(name = "evento_vehiculo")
@NoArgsConstructor
@Getter
@Setter
public class EventoVehiculo extends Entidad {



  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;


//  @ManyToOne
//  private Desviacion desviacion;

  @Column
  private String alerta;

  @Column
  private String tipo_alerta;

  @Column
  private String kms_ini;

  @Column
  private String kms_comportamiento;

  @Column
  private String evento_puntaje;


}
