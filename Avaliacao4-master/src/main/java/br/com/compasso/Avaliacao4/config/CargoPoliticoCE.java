package br.com.compasso.Avaliacao4.config;

import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.compasso.Avaliacao4.util.CargoPoliticoConE;


public class CargoPoliticoCE implements WebMvcConfigurer {
	
	@Override
	public void addFormatters (FormatterRegistry formatterRegistry) {
		formatterRegistry.addConverter(new CargoPoliticoConE());
	}

}
