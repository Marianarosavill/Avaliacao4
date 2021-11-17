package br.com.compasso.Avaliacao4.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.Avaliacao4.dto.AssociadoDto;
import br.com.compasso.Avaliacao4.dto.AssociadoFormDto;
import br.com.compasso.Avaliacao4.model.option.CargoPoliticoOption;
import br.com.compasso.Avaliacao4.service.AssociadoService;

@RestController
@RequestMapping("/associados")
public class AssociadoController {

	@Autowired
	private AssociadoService associadoService;
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<AssociadoDto> guardar (@RequestBody AssociadoFormDto body) {
		return ResponseEntity.ok(this.associadoService.guardar(body));
	}
	
	
	@GetMapping
	public ResponseEntity<List<AssociadoDto>> listar(@RequestParam(value = "cargoPolitico", required = false) CargoPoliticoOption cargoPolitico) {
		return ResponseEntity.ok(this.associadoService.listar(cargoPolitico));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<AssociadoDto> buscar (@PathVariable Long id) {
		return ResponseEntity.ok(this.associadoService.buscar(id));
	}
	

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AssociadoDto> act(@PathVariable Long id, @RequestBody @Valid AssociadoFormDto body) {
		return ResponseEntity.ok(this.associadoService.act(id, body));
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		this.associadoService.remover(id);
		return ResponseEntity.ok().build();
	}
	
	

}
