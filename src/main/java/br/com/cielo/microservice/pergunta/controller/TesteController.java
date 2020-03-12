package br.com.cielo.microservice.pergunta.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cielo.microservice.pergunta.dto.VoucherDto;

@RestController
@RequestMapping("/uhuuu")
public class TesteController {
	
	@RequestMapping(method = RequestMethod.POST)
	public VoucherDto apenasTeste(@RequestBody VoucherDto voucherDto) {
		return voucherDto;
	}
	

}
