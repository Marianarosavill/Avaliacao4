package br.com.compasso.Avaliacao4.dto;

import java.time.LocalDate;

import br.com.compasso.Avaliacao4.model.option.CargoPoliticoOption;
import br.com.compasso.Avaliacao4.model.option.SexoOption;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssociadoFormDto {

	private String nome;

	private CargoPoliticoOption cargoPolitico;

	private LocalDate dataNascimento;

	private SexoOption sexo;

}




	

