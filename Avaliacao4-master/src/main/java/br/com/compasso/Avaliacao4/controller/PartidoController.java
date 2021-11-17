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

import br.com.compasso.Avaliacao4.dto.PartidoDto;
import br.com.compasso.Avaliacao4.dto.PartidoFormDto;
import br.com.compasso.Avaliacao4.model.option.IdeologiaOption;
import br.com.compasso.Avaliacao4.service.PartidoService;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

	@Autowired
	private PartidoService partidoService;
	
	//1
	@PostMapping
	@Transactional
	public ResponseEntity<PartidoDto> guardar (@RequestBody PartidoFormDto body) {
		return ResponseEntity.ok(this.partidoService.guardar(body));
	}
	

	@GetMapping
	public ResponseEntity<List<PartidoDto>> listar(@RequestParam(value = "ideologia", required = false) IdeologiaOption idelogia) {
		return ResponseEntity.ok(this.partidoService.listar(idelogia));
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<PartidoDto> buscar(@PathVariable Long id) {
		return ResponseEntity.ok(this.partidoService.buscar(id));
	}
	

	

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PartidoDto> act(@PathVariable Long id, @RequestBody @Valid PartidoFormDto body) {
		return ResponseEntity.ok(this.partidoService.act(id, body));
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		this.partidoService.remover(id);
		return ResponseEntity.ok().build();
	}

}
