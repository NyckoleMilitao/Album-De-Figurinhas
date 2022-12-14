package ilab.projeto.up.ilab.up.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ilab.projeto.up.ilab.up.dto.ColaboradorContratoRequestDTO;
import ilab.projeto.up.ilab.up.dto.ColaboradorContratoResponseDTO;
import ilab.projeto.up.ilab.up.model.Colaborador;
import ilab.projeto.up.ilab.up.model.ColaboradorContrato;
import ilab.projeto.up.ilab.up.model.Contrato;
import ilab.projeto.up.ilab.up.model.Papel;

@Repository
public interface ColaboradorContratoRepository extends JpaRepository<ColaboradorContrato, Long> {

	public Optional<ColaboradorContratoResponseDTO> findByIdColaboradorContrato(Long idColaboradorContrato);

	public ColaboradorContrato findByColaborador(Colaborador colaborador);

	public ColaboradorContrato findByContrato(Contrato contrato);

	public ColaboradorContrato findByPapel(Papel papel);

	public ColaboradorContrato findByEsforcoTotal(int esforcoTotal);

	public ColaboradorContrato findByEsforcoExtraTotal(int esforcoExtraTotal);

	public ColaboradorContrato findByImpostos(double impostos);

	public ColaboradorContrato findByFaturamentoTotal(double faturamentoTotal);

	public ColaboradorContrato save(ColaboradorContratoRequestDTO colaboradorContratoRequestDTO);

}
