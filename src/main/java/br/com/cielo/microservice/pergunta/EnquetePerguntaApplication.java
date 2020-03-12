package br.com.cielo.microservice.pergunta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EnableSpringDataWebSupport
public class EnquetePerguntaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnquetePerguntaApplication.class, args);
	}

}
