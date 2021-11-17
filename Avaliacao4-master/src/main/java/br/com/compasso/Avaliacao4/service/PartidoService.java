package br.com.compasso.Avaliacao4.service;

import java.util.List;

import br.com.compasso.Avaliacao4.dto.PartidoDto;
import br.com.compasso.Avaliacao4.dto.PartidoFormDto;
import br.com.compasso.Avaliacao4.model.option.IdeologiaOption;

public interface PartidoService {

	PartidoDto guardar(PartidoFormDto body);
	
	List<PartidoDto> listar(IdeologiaOption ideologia);
	
	PartidoDto buscar (Long id);
	
	PartidoDto act(Long id, PartidoFormDto body);
	
	void remover(Long id);
}
