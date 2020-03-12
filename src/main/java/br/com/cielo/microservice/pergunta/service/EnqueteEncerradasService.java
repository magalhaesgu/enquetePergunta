package br.com.cielo.microservice.pergunta.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cielo.microservice.pergunta.dto.OpcaoDTO;
import br.com.cielo.microservice.pergunta.dto.PerguntaDTO;
import br.com.cielo.microservice.pergunta.model.Opcao;
import br.com.cielo.microservice.pergunta.model.Pergunta;
import br.com.cielo.microservice.pergunta.repository.PerguntaRepository;

@Service
public class EnqueteEncerradasService {
	
	@Autowired
	PerguntaRepository perguntaRepository;
	
	public List<PerguntaDTO> buscaEnquetesEncerradas(LocalDate dataFimEnquete) {
		List<Pergunta> listaEnquetesEncerradas = perguntaRepository.findAllWithDataFimBefore(dataFimEnquete);
		return convertDto(listaEnquetesEncerradas);
	}

	private List<PerguntaDTO> convertDto(List<Pergunta> listaEnquetesEncerradas) {
		if (listaEnquetesEncerradas != null) {
			List<PerguntaDTO> listaPerguntaDTO = new ArrayList<>();
			for (Pergunta pergunta : listaEnquetesEncerradas) {
				PerguntaDTO perguntaDTO = new PerguntaDTO();
				//BeanUtils.copyProperties(pergunta, perguntaDTO);
				perguntaDTO.setId(pergunta.getId());
				perguntaDTO.setDataInicio(pergunta.getDataInicio());
				perguntaDTO.setDataFim(pergunta.getDataFim());
				perguntaDTO.setOpcao(convertOpcao(pergunta.getOpcao()));
				perguntaDTO.setTitulo(pergunta.getTitulo());
				perguntaDTO.setEmail(pergunta.getEmail());
				
				listaPerguntaDTO.add(perguntaDTO);
			}
			return listaPerguntaDTO;
		}
		return null;
	}
	
	private List<OpcaoDTO> convertOpcao(List<Opcao> listaOpcao) {
		List<OpcaoDTO> listaConvertida = new ArrayList<>();
		OpcaoDTO opcaoDTO = new OpcaoDTO();
		for (Opcao opcao : listaOpcao) {
			opcaoDTO.setId(opcao.getId());
			opcaoDTO.setDescricao(opcao.getDescricao());
			listaConvertida.add(opcaoDTO);
		}
		return listaConvertida;
	}
}
