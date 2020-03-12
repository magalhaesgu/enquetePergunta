package br.com.cielo.microservice.pergunta.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cielo.microservice.pergunta.dto.PerguntaDTO;
import br.com.cielo.microservice.pergunta.service.EnqueteEncerradasService;

@RestController
@RequestMapping("/enquetesEncerradas")
public class EnquetesEncerradasController {
	
	@Autowired
	private EnqueteEncerradasService enqueteEncerradasService;
	
	@RequestMapping(method = RequestMethod.POST)
	public List<PerguntaDTO> buscaEnquetesEncerradas(@RequestBody LocalDate dataFim) {
		List<PerguntaDTO> listaEnquetesEncerradas = enqueteEncerradasService.buscaEnquetesEncerradas(dataFim);
		return listaEnquetesEncerradas;
	}
}
