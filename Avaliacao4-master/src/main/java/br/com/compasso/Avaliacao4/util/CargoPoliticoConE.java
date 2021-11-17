package br.com.compasso.Avaliacao4.util;

import org.springframework.core.convert.converter.Converter;

import br.com.compasso.Avaliacao4.model.option.CargoPoliticoOption;

public class CargoPoliticoConE implements Converter <String, CargoPoliticoOption> {
	
	@Override
	public CargoPoliticoOption convert(String cargoPolitico) {
		return CargoPoliticoOption.valueOf(cargoPolitico.toUpperCase());
	}
}
