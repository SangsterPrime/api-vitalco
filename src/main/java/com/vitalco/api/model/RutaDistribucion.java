package com.vitalco.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rutas_distribucion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RutaDistribucion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private String zonaCobertura;

	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "vehiculo_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Vehiculo vehiculoAsignado;
}
