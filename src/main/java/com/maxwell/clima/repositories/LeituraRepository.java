package com.maxwell.clima.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maxwell.clima.dto.LeituraDTO;
import com.maxwell.clima.entities.Leitura;

@Repository
public interface LeituraRepository extends JpaRepository<Leitura, Long>{

	@Query(value = "")
	Page<LeituraDTO> searchByDate();
}
