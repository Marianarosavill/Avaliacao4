package br.com.compasso.Avaliacao4.config;

import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.compasso.Avaliacao4.util.SexoConE;

public class SexoCE implements WebMvcConfigurer {
	
	@Override
	public void addFormatters (FormatterRegistry formatterRegistry) {
		formatterRegistry.addConverter(new SexoConE());
	}

}
