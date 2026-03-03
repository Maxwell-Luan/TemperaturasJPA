package com.maxwell.clima.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maxwell.clima.dto.LeituraDTO;
import com.maxwell.clima.services.LeituraService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/leituras")
public class LeituraController {

	@Autowired
	private LeituraService service;
	
	@GetMapping
	public ResponseEntity<Page<LeituraDTO>> findAll(Pageable page){
		Page<LeituraDTO> dto = service.findAll(page);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LeituraDTO> findById(@PathVariable Long id){
		LeituraDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<LeituraDTO> insert(@Valid @RequestBody LeituraDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
