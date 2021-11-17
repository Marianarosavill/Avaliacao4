package br.com.compasso.Avaliacao4.util;

import org.springframework.core.convert.converter.Converter;

import br.com.compasso.Avaliacao4.model.option.IdeologiaOption;

public class IdeologiaConEn implements Converter <String, IdeologiaOption> {
	
	@Override
	public IdeologiaOption convert(String ideologia) {
		return IdeologiaOption.valueOf(ideologia.toUpperCase());
	}
}
