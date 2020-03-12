package br.com.cielo.microservice.pergunta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cielo.microservice.pergunta.dto.PerguntaDTO;
import br.com.cielo.microservice.pergunta.service.PerguntaService;

@RestController
@RequestMapping("/pergunta")
public class PerguntaController {
	
	@Autowired
	private PerguntaService perguntaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public PerguntaDTO cadastrarPergunta(@RequestBody PerguntaDTO enqueteDTO) {
		PerguntaDTO perguntaTO = perguntaService.incluirPergunta(enqueteDTO);
		return enqueteDTO;
	}
}
