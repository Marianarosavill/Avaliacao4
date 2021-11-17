package br.com.compasso.Avaliacao4.dto;

import java.time.LocalDate;

import br.com.compasso.Avaliacao4.model.option.IdeologiaOption;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PartidoFormDto {

	private String nome;
	
	private String sigla;

	private IdeologiaOption ideologia;

	private LocalDate dataFundacao;

}
