package br.com.compasso.Avaliacao4.validation;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import br.com.compasso.Avaliacao4.model.Associado;
import br.com.compasso.Avaliacao4.model.Partido;
import br.com.compasso.Avaliacao4.model.option.CargoPoliticoOption;
import br.com.compasso.Avaliacao4.model.option.IdeologiaOption;
import br.com.compasso.Avaliacao4.model.option.SexoOption;

@Service
public class Validation {

	public void validaPartido (Partido partido) throws Exception {
		
		String nome = partido.getNome();
		String sigla = partido.getSigla();
		IdeologiaOption ideologia = partido.getIdeologia();
		LocalDate dataFundacao = partido.getDataFundacao();
		
		if (nome == null) {
			throw new Exception("no puede ser nulo");
		} else if (sigla == null) {
			throw new Exception("no puede ser nulo");
		} else if (ideologia == null) {
			throw new Exception("no puede ser nulo");
		} else if (dataFundacao == null) {
			throw new Exception("no puede ser nulo");
		}
	}
	
	public void validaAssociado (Associado associado) throws Exception {
		
		String nome = associado.getNome();
		CargoPoliticoOption cargoPolitico = associado.getCargoPolitico();
		LocalDate dataNascimento = associado.getDataNascimento();
		SexoOption sexo = associado.getSexo();
		
		if (nome == null) {
			throw new Exception("no puede ser nulo");
		} else if (cargoPolitico == null) {
			throw new Exception("no puede ser nulo");
		} else if (dataNascimento == null) {
			throw new Exception("no puede ser nulo");
		} else if (sexo == null) {
			throw new Exception("no puede ser nulo");
		}
	}
}
