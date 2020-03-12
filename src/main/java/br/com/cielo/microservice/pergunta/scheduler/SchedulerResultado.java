package br.com.cielo.microservice.pergunta.scheduler;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.cielo.microservice.pergunta.model.Pergunta;
import br.com.cielo.microservice.pergunta.repository.PerguntaRepository;
import lombok.extern.slf4j.Slf4j;

//@Component
//@Slf4j
public class SchedulerResultado {

	/*
	@Autowired
	private PerguntaRepository perguntaRepository;
	
	   @Scheduled(fixedRate = 5000)
	   public void buscaEnqueteEncerradas() {
		   LocalDate dataFimEnquete = LocalDate.now();
		   List<Pergunta> listaEnquetesEncerradas = perguntaRepository.findAllWithDataFimBefore(dataFimEnquete);

		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		   Date now = new Date();
		   String strDate = sdf.format(now);
		   log.info("Fixed Rate scheduler:: " + strDate);
	   }	
	*/
}
