package br.com.compasso.Avaliacao4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.compasso.Avaliacao4.model.Associado;
import br.com.compasso.Avaliacao4.model.option.CargoPoliticoOption;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long>{

	
	@Query("SELECT a FROM Associado a WHERE a.cargoPolitico LIKE :cargoPolitico")
	List<Associado> findByCargoPolitico(CargoPoliticoOption cargoPolitico);
}
