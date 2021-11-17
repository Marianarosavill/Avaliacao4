package br.com.compasso.Avaliacao4.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.compasso.Avaliacao4.model.option.CargoPoliticoOption;
import br.com.compasso.Avaliacao4.model.option.SexoOption;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Associado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Enumerated(EnumType.STRING)
	private CargoPoliticoOption cargoPolitico;

	private LocalDate dataNascimento;

	@Enumerated(EnumType.STRING)
	private SexoOption sexo;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public CargoPoliticoOption getCargoPolitico() {
		return cargoPolitico;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public SexoOption getSexo() {
		return sexo;
	}

	
	

}
