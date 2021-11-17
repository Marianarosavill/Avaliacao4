package br.com.compasso.Avaliacao4.util;

import org.springframework.core.convert.converter.Converter;

import br.com.compasso.Avaliacao4.model.option.SexoOption;

public class SexoConE implements Converter <String, SexoOption> {
	
	@Override
	public SexoOption convert(String sexo) {
		return SexoOption.valueOf(sexo.toUpperCase());
	}
}
