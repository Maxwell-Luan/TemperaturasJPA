package com.maxwell.clima.entities;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_leitura")
public class Leitura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double valorCelsius;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant momento;
	
	@ManyToOne
	@JoinColumn(name = "sensor_id")
	private Sensor sensor;
	
	public Leitura() {
	}

	public Leitura(Long id, Double valorCelsius, Instant momento) {
		this.id = id;
		this.valorCelsius = valorCelsius;
		this.momento = momento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorCelsius() {
		return valorCelsius;
	}

	public void setValorCelsius(Double valorCelsius) {
		this.valorCelsius = valorCelsius;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}
	
	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Leitura other = (Leitura) obj;
		return Objects.equals(id, other.id);
	}
	
}
