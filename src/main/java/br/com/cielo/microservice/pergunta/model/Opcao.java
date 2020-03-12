package br.com.cielo.microservice.pergunta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Opcao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)		
	private Long id;
	
	private String descricao;
	
	@ManyToOne
	private Pergunta pergunta;

}
