package br.com.cielo.microservice.pergunta.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pergunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	private String titulo;
	
	@OneToMany(mappedBy = "pergunta", cascade = CascadeType.ALL)
	private List<Opcao> opcao = new ArrayList<>();
	
	private LocalDate dataInicio;
	
	private LocalDate dataFim;
	
	private String email;

}
