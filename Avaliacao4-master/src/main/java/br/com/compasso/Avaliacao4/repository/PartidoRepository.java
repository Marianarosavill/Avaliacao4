package br.com.compasso.Avaliacao4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.compasso.Avaliacao4.model.Partido;
import br.com.compasso.Avaliacao4.model.option.IdeologiaOption;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long>{

	@Query("SELECT p FROM Partido p WHERE p.ideologia LIKE :ideologia")
	List<Partido> findByIdeologia(IdeologiaOption ideologia);
}
