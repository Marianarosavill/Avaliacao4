package br.com.compasso.Avaliacao4.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.compasso.Avaliacao4.model.option.IdeologiaOption;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	
	private String sigla;

	@Enumerated(EnumType.STRING)
	private IdeologiaOption ideologia;

	private LocalDate dataFundacao;
	
	@OneToMany
	private List<Associado> associados;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}

	public IdeologiaOption getIdeologia() {
		return ideologia;
	}

	public LocalDate getDataFundacao() {
		return dataFundacao;
	}

	public List<Associado> getAssociados() {
		return associados;
	}


	

}
