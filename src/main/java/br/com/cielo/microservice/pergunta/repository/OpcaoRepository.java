package br.com.cielo.microservice.pergunta.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cielo.microservice.pergunta.model.Opcao;

public interface OpcaoRepository extends CrudRepository<Opcao, Long>{

}
