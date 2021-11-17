package br.com.compasso.Avaliacao4.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.compasso.Avaliacao4.model.option.IdeologiaOption;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PartidoDto {
	
	private Long id;

	private String nome;
	
	private String sigla;

	private IdeologiaOption ideologia;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-03")
	private LocalDate dataFundacao;
	
}
