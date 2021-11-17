package br.com.compasso.Avaliacao4.service;

import java.util.List;

import br.com.compasso.Avaliacao4.dto.AssociadoDto;
import br.com.compasso.Avaliacao4.dto.AssociadoFormDto;
import br.com.compasso.Avaliacao4.model.option.CargoPoliticoOption;

public interface AssociadoService {

	AssociadoDto guardar (AssociadoFormDto body);
	

	
	List<AssociadoDto> listar(CargoPoliticoOption cargoPolitico);
	
	AssociadoDto buscar (Long id);
	
	AssociadoDto act(Long id, AssociadoFormDto body);
	
	void remover(Long id);
}
