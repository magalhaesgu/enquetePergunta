package br.com.cielo.microservice.pergunta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cielo.microservice.pergunta.dto.OpcaoDTO;
import br.com.cielo.microservice.pergunta.dto.PerguntaDTO;
import br.com.cielo.microservice.pergunta.model.Opcao;
import br.com.cielo.microservice.pergunta.model.Pergunta;
import br.com.cielo.microservice.pergunta.repository.PerguntaRepository;

@Service
public class PerguntaService {
	
	@Autowired
	private PerguntaRepository perguntaRepository; 
	
	public PerguntaDTO incluirPergunta(PerguntaDTO enqueteDTO) {
		if (enqueteDTO == null) {
			return null;
		}
		Pergunta pergunta = toPerguntaEntity(enqueteDTO);
		List<Opcao> listaOpcoes = toListOpcoes(enqueteDTO.getOpcao(), pergunta);
		pergunta.setOpcao(listaOpcoes);
		Pergunta perguntaSalva = perguntaRepository.save(pergunta);
		return convertToDto(perguntaSalva);
	}

	private Pergunta toPerguntaEntity(PerguntaDTO perguntaDTO) {
		Pergunta pergunta = new Pergunta();
		pergunta.setTitulo(perguntaDTO.getTitulo());
		pergunta.setDataInicio(perguntaDTO.getDataInicio());
		pergunta.setDataFim(perguntaDTO.getDataFim());
		pergunta.setEmail(perguntaDTO.getEmail());
		return pergunta;
	}

	private List<Opcao> toListOpcoes(List<OpcaoDTO> listaOpcoesDTO, Pergunta pergunta) {
		List<Opcao> listaOpcoes = new ArrayList<>();
		for (OpcaoDTO opcaoDTO : listaOpcoesDTO) {
			Opcao opcao = new Opcao();
			opcao.setDescricao(opcaoDTO.getDescricao());
			opcao.setPergunta(pergunta);
			listaOpcoes.add(opcao);
		}
 		return listaOpcoes;
	}
	
	private PerguntaDTO convertToDto(Pergunta pergunta) {
		PerguntaDTO perguntaDTO = new PerguntaDTO();
		//BeanUtils.copyProperties(pergunta, perguntaDTO);
		perguntaDTO.setId(pergunta.getId());
		perguntaDTO.setDataFim(pergunta.getDataFim());
		perguntaDTO.setDataInicio(pergunta.getDataInicio());
		perguntaDTO.setEmail(pergunta.getEmail());
		perguntaDTO.setTitulo(pergunta.getTitulo());
		perguntaDTO.setOpcao(convertOpcaoDTO(pergunta.getOpcao()));
		return perguntaDTO;
	}	
	
	private List<OpcaoDTO> convertOpcaoDTO(List<Opcao> listaOpcao) {
		List<OpcaoDTO> listOpcaoDTO = new ArrayList<>();
		for (Opcao opcao : listaOpcao) {
			OpcaoDTO opcaoDTO = new OpcaoDTO();
			opcaoDTO.setId(opcao.getId());
			opcaoDTO.setDescricao(opcao.getDescricao());
		}
		return listOpcaoDTO;
	}
	

}
