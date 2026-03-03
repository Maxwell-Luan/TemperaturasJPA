package com.maxwell.clima.dto;

import com.maxwell.clima.entities.Sensor;

public class SensorDTO {

	private Long id;
	private String nome;
	
	public SensorDTO() {
	}

	public SensorDTO(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public SensorDTO(Sensor entity) {
		id = entity.getId();
		nome = entity.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}
