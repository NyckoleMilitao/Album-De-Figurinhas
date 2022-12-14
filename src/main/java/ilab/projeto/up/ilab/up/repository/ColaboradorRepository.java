package ilab.projeto.up.ilab.up.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ilab.projeto.up.ilab.up.dto.ColaboradorMatriculaDTO;
import ilab.projeto.up.ilab.up.dto.ColaboradorRequestDTO;
import ilab.projeto.up.ilab.up.model.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
	
	@Query(value = "SELECT * FROM colaborador a", nativeQuery = true)
	public Colaborador findByColaborador(Long id);
	
	public Optional<Colaborador> findById(Long idColaborador);

	public Colaborador findByStatusColaborador(boolean statusColaborador);

	public Colaborador findByNomeColaborador(String nomeColaborador);

	public Colaborador findByMatricula(String matricula);

	public Colaborador findBySalarioBase(double salarioBase);

	public Colaborador save (ColaboradorRequestDTO colaboradorRequestDTO);

	@Query(value = "SELECT c.id_colaborador AS idColaborador, c.matricula AS matricula FROM colaborador c", nativeQuery = true)
	public List<ColaboradorMatriculaDTO> findColaboradorMatricula();
}
