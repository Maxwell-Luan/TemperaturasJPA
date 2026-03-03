package com.maxwell.clima.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maxwell.clima.entities.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long>{

}
