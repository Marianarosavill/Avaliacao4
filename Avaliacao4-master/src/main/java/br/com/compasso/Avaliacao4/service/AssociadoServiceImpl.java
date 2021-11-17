package br.com.compasso.Avaliacao4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.Avaliacao4.dto.AssociadoDto;
import br.com.compasso.Avaliacao4.dto.AssociadoFormDto;
import br.com.compasso.Avaliacao4.model.Associado;
import br.com.compasso.Avaliacao4.model.option.CargoPoliticoOption;
import br.com.compasso.Avaliacao4.repository.AssociadoRepository;
import br.com.compasso.Avaliacao4.validation.Validation;

@Service
public class AssociadoServiceImpl implements AssociadoService {

	@Autowired
	private AssociadoRepository associadoRepository;
	


	@Autowired
	private ModelMapper mapper;

	@Autowired
	private Validation validation;



	@Override
	public AssociadoDto guardar (AssociadoFormDto body) {
		Associado associado = mapper.map(body, Associado.class);
		try {
			validation.validaAssociado(associado);
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		Associado associadoResponse = this.associadoRepository.save(associado);
		return mapper.map(associadoResponse, AssociadoDto.class);
	}
	



	@Override
	public List<AssociadoDto> listar(CargoPoliticoOption cargoPolitico) {
		List<AssociadoDto> associados = new ArrayList<>();
		if (cargoPolitico != null) {
			associados = this.associadoRepository.findByCargoPolitico(cargoPolitico).stream()
					.map(a -> mapper.map(a, AssociadoDto.class)).collect(Collectors.toList());
		} else {
			associados = this.associadoRepository.findAll().stream().map(a -> mapper.map(a, AssociadoDto.class))
					.collect(Collectors.toList());
		}
		return associados;
	}

	@Override
	public AssociadoDto buscar (Long id) {
		Optional<Associado> associado = this.associadoRepository.findById(id);
		if (associado.isPresent() == true) {
			return mapper.map(associado.get(), AssociadoDto.class);
		}
		throw new RuntimeException("Estado no encontrado");
	}

	@Override
	public AssociadoDto act (Long id, AssociadoFormDto body) {
		Optional<Associado> associado = this.associadoRepository.findById(id);
		if (associado.isPresent() == true) {
			associado.get().setNome(body.getNome());
			associado.get().setCargoPolitico(body.getCargoPolitico());
			associado.get().setDataNascimento(body.getDataNascimento());
			associado.get().setSexo(body.getSexo());
			Associado a = this.associadoRepository.save(associado.get());
			return mapper.map(a, AssociadoDto.class);
		}
		throw new RuntimeException("Estado no encontrado");
	}

	@Override
	public void remover(Long id) {
		Optional<Associado> associado = this.associadoRepository.findById(id);
		if (associado.isPresent() == true) {
			this.associadoRepository.deleteById(id);
		} else {
			throw new RuntimeException("Estado no encontrado");
		}
	}

}
