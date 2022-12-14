package ilab.projeto.up.ilab.up.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ilab.projeto.up.ilab.up.dto.ContratoNomeDTO;
import ilab.projeto.up.ilab.up.dto.ContratoResponseDTO;
import ilab.projeto.up.ilab.up.model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

	public Optional<Contrato> findById(Long idContrato);

	public Contrato findByStatusContrato(boolean statusContrato);

	public Contrato findByModalidade(String modalidade);

	public Contrato findByDataInicio(LocalDate dataInicio);

	public Contrato findByDataFinal(LocalDate dataFinal);

	public Contrato findByCargaHorariaPrevista(int cargaHorariaPrevista);

	public Contrato saveAndFlush(ContratoResponseDTO contratoResponseDTO);

	@Query(value = "SELECT a.idContrato AS idContrato, a.nomeContrato AS nomeContrato FROM Contrato a")
	public List<ContratoNomeDTO> findContratos();
	
}
