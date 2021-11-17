package br.com.compasso.Avaliacao4.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.compasso.Avaliacao4.model.option.CargoPoliticoOption;
import br.com.compasso.Avaliacao4.model.option.SexoOption;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssociadoDto {

	private Long id;

	private String nome;

	private CargoPoliticoOption cargoPolitico;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "GMT-03")
	private LocalDate dataNascimento;

	private SexoOption sexo;

}
