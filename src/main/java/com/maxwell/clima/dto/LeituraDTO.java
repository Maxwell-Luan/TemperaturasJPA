package com.maxwell.clima.dto;

import java.time.Instant;

import com.maxwell.clima.entities.Leitura;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class LeituraDTO {

	private Long id;
	
	@NotNull(message = "Campo requerido")
	private Double valorCelsius;
	
	@PastOrPresent(message = "A data não pode ser futura")
	private Instant momento;
	private SensorDTO sensor;
	
	public LeituraDTO() {
	}

	public LeituraDTO(Long id, Double valorCelsius, Instant momento, SensorDTO sensor) {
		this.id = id;
		this.valorCelsius = valorCelsius;
		this.momento = momento;
		this.sensor = sensor;
	}

	public LeituraDTO(Leitura entity) {
		id = entity.getId();
		valorCelsius = entity.getValorCelsius();
		momento = entity.getMomento();
		this.sensor = new SensorDTO(entity.getSensor());
	}

	public Long getId() {
		return id;
	}

	public Double getValorCelsius() {
		return valorCelsius;
	}

	public Instant getMomento() {
		return momento;
	}

	public SensorDTO getSensor() {
		return sensor;
	}
	
}
