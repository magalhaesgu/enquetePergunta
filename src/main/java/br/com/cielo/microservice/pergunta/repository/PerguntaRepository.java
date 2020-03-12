package br.com.cielo.microservice.pergunta.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.cielo.microservice.pergunta.model.Pergunta;

public interface PerguntaRepository extends CrudRepository<Pergunta, Long>{
	
	List<Pergunta> findAllByDataFim(LocalDate dataFim);	
	
	@Query("select p from Pergunta p where p.dataFim <= :parametroDataFim")
    List<Pergunta> findAllWithDataFimBefore(@Param("parametroDataFim") LocalDate parametroDataFim);	

}
