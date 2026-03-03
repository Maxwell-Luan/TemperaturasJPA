package com.maxwell.clima.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.maxwell.clima.dto.LeituraDTO;
import com.maxwell.clima.entities.Leitura;
import com.maxwell.clima.entities.Sensor;
import com.maxwell.clima.exceptions.DatabaseException;
import com.maxwell.clima.exceptions.ResourceNotFoundException;
import com.maxwell.clima.repositories.LeituraRepository;
import com.maxwell.clima.repositories.SensorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LeituraService {

	@Autowired
	private LeituraRepository repository;
	
	@Autowired
	private SensorRepository sensorRepository;
	
	@Transactional(readOnly = true)
	public Page<LeituraDTO> findAll(Pageable page) {
		Page<Leitura> leitura = repository.findAll(page);
		Page<LeituraDTO> result = leitura.map(x -> new LeituraDTO(x));
		return result;
	}
	
	@Transactional(readOnly = true)
	public LeituraDTO findById(Long id) {
		Leitura leitura = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado!"));
		LeituraDTO dto = new LeituraDTO(leitura);
		return dto;
	}
	
	@Transactional
	public LeituraDTO insert(LeituraDTO dto) {
		Leitura entity = new Leitura();
		
		copyDtoToEntity(dto, entity);
		
		entity = repository.save(entity);
		LeituraDTO result = new LeituraDTO(entity);
		return result;
	}
	
	@Transactional
	public LeituraDTO update(Long id, LeituraDTO dto) {
		Leitura entity = repository.getReferenceById(id);
		try {
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			LeituraDTO result = new LeituraDTO(entity);
			return result;
		}
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
		
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("Leitura informada não existe");
		}
		try {
			repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");
		}
	}
	
	//Métodos auxiliares
	
	private void copyDtoToEntity(LeituraDTO dto, Leitura entity) {
		Sensor sensor = sensorRepository.getReferenceById(dto.getSensor().getId());
		entity.setValorCelsius(dto.getValorCelsius());
		entity.setMomento(dto.getMomento());
		entity.setSensor(sensor);
	}
}
