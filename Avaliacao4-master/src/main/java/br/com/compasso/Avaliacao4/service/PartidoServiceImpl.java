package br.com.compasso.Avaliacao4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.Avaliacao4.dto.PartidoDto;
import br.com.compasso.Avaliacao4.dto.PartidoFormDto;
import br.com.compasso.Avaliacao4.model.Partido;
import br.com.compasso.Avaliacao4.model.option.IdeologiaOption;
import br.com.compasso.Avaliacao4.repository.PartidoRepository;
import br.com.compasso.Avaliacao4.validation.Validation;

@Service
public class PartidoServiceImpl implements PartidoService {

	@Autowired
	private PartidoRepository partidoRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private Validation validation;

	@Override
	public PartidoDto guardar (PartidoFormDto body) {
		Partido partido = mapper.map(body, Partido.class);
		validation.validaPartido(partido);
		Partido partidoResponse = this.partidoRepository.save(partido);
		return mapper.map(partidoResponse, PartidoDto.class);
	}

	@Override
	public List<PartidoDto> listar(IdeologiaOption ideologia) {
		List<PartidoDto> partidos = new ArrayList<>();
		if (ideologia != null) {
			partidos = this.partidoRepository.findByIdeologia(ideologia).stream()
					.map(p -> mapper.map(p, PartidoDto.class)).collect(Collectors.toList());
		} else {
			partidos = this.partidoRepository.findAll().stream()
					.map(p -> mapper.map(p, PartidoDto.class)).collect(Collectors.toList());
		}
		return partidos;
	}

	@Override
	public PartidoDto buscar(Long id) {
		Optional<Partido> partido = this.partidoRepository.findById(id);
		if (partido.isPresent() == true) {
			return mapper.map(partido.get(), PartidoDto.class);
		}
		throw new RuntimeException("Estado não encontrado");
	}

	@Override
	public PartidoDto act(Long id, PartidoFormDto body) {
		Optional<Partido> partido = this.partidoRepository.findById(id);
		if (partido.isPresent() == true) {
			partido.get().setNome(body.getNome());
			partido.get().setSigla(body.getSigla());
			partido.get().setIdeologia(body.getIdeologia());
			partido.get().setDataFundacao(body.getDataFundacao());
			Partido p = this.partidoRepository.save(partido.get());
			return mapper.map(p, PartidoDto.class);
		}
		throw new RuntimeException("Estado não encontrado");
	}

	@Override
	public void remover(Long id) {
		Optional<Partido> partido = this.partidoRepository.findById(id);
		if (partido.isPresent() == true) {
			this.partidoRepository.deleteById(id);
		} else {
			throw new RuntimeException("Estado não encontrado");
		}
	}

	
}
