package ilab.projeto.up.ilab.up.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ilab.projeto.up.ilab.up.dto.ColaboradorContratoRequestDTO;
import ilab.projeto.up.ilab.up.dto.ColaboradorContratoResponseDTO;
import ilab.projeto.up.ilab.up.model.Colaborador;
import ilab.projeto.up.ilab.up.model.ColaboradorContrato;
import ilab.projeto.up.ilab.up.model.Contrato;
import ilab.projeto.up.ilab.up.model.Papel;
import ilab.projeto.up.ilab.up.repository.ColaboradorContratoRepository;
import ilab.projeto.up.ilab.up.repository.ColaboradorRepository;
import ilab.projeto.up.ilab.up.repository.ContratoRepository;
import ilab.projeto.up.ilab.up.repository.PapelRepository;
import ilab.projeto.up.ilab.up.service.ColaboradorContratoService;

@Service
public class ColaboradorContratoServiceImpl implements ColaboradorContratoService {

	@Autowired
	private ColaboradorContratoRepository colaboradorContratoRepository;

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@Autowired
	private ContratoRepository contratoRepository;

	@Autowired
	private PapelRepository papelRepository;

	/**
	 * Metodo get para listar todas as tabelas de ColaboradorContrato
	 */
	public Page<ColaboradorContratoResponseDTO> listar(Pageable pageable) {
		Page<ColaboradorContrato> colaboradorContrato = colaboradorContratoRepository.findAll(pageable);
		Page<ColaboradorContratoResponseDTO> colaboradorContratoDTO = colaboradorContrato
				.map(ColaboradorContratoResponseDTO::new);

		return colaboradorContratoDTO;
	}

	public ColaboradorContratoResponseDTO buscar(Long idColaboradorContrato) {
		Optional<ColaboradorContratoResponseDTO> colaboradorContrato = colaboradorContratoRepository
				.findByIdColaboradorContrato(idColaboradorContrato);
		if (colaboradorContrato.isPresent()) {
			return colaboradorContrato.get();
		}
		return null;
	}

	public ColaboradorContratoResponseDTO inserir(ColaboradorContratoRequestDTO colaboradorContratoRequestDTO) {

		ColaboradorContrato colaboradorContrato = new ColaboradorContrato();

		Optional<Colaborador> colaborador = colaboradorRepository
				.findById(colaboradorContratoRequestDTO.getIdColaborador());

		colaboradorContrato.setColaborador(colaborador.get());

		Optional<Contrato> contrato = contratoRepository.findById(colaboradorContratoRequestDTO.getIdContrato());

		colaboradorContrato.setContrato(contrato.get());

		Optional<Papel> papel = papelRepository.findByIdPapel(colaboradorContratoRequestDTO.getIdPapel());

		colaboradorContrato.setPapel(papel.get());

		colaboradorContrato.setEsforcoTotal(colaboradorContratoRequestDTO.getEsforcoTotal());
		colaboradorContrato.setEsforcoExtraTotal(colaboradorContratoRequestDTO.getEsforcoExtraTotal());
		colaboradorContrato.setImpostos(colaboradorContratoRequestDTO.getImpostos());
		colaboradorContrato.setFaturamentoTotal(colaboradorContratoRequestDTO.getFaturamentoTotal());
		colaboradorContrato.setDataBatida(colaboradorContratoRequestDTO.getDataBatida());

		return new ColaboradorContratoResponseDTO(colaboradorContratoRepository.save(colaboradorContrato));

	}

	public ColaboradorContratoResponseDTO atualizar(Long id,
			ColaboradorContratoRequestDTO colaboradorContratoRequestDTO) {

		if (colaboradorContratoRepository.existsById(id)) {

			ColaboradorContrato colaboradorContrato = new ColaboradorContrato();
			colaboradorContrato.setIdColaboradorContrato(id);

			Optional<Colaborador> colaborador = colaboradorRepository
					.findById(colaboradorContratoRequestDTO.getIdColaborador());

			colaboradorContrato.setColaborador(colaborador.get());

			Optional<Contrato> contrato = contratoRepository.findById(colaboradorContratoRequestDTO.getIdContrato());

			colaboradorContrato.setContrato(contrato.get());

			Optional<Papel> papel = papelRepository.findByIdPapel(colaboradorContratoRequestDTO.getIdPapel());

			colaboradorContrato.setPapel(papel.get());

			colaboradorContrato.setEsforcoTotal(colaboradorContratoRequestDTO.getEsforcoTotal());
			colaboradorContrato.setEsforcoExtraTotal(colaboradorContratoRequestDTO.getEsforcoExtraTotal());
			colaboradorContrato.setImpostos(colaboradorContratoRequestDTO.getImpostos());
			colaboradorContrato.setFaturamentoTotal(colaboradorContratoRequestDTO.getFaturamentoTotal());
			colaboradorContrato.setDataBatida(colaboradorContratoRequestDTO.getDataBatida());

			return new ColaboradorContratoResponseDTO(colaboradorContratoRepository.save(colaboradorContrato));
		}
		return null;
	}

	public ColaboradorContratoResponseDTO deletar(Long idColaboradorContrato) {

		if (colaboradorContratoRepository.existsById(idColaboradorContrato)) {
			colaboradorContratoRepository.deleteById(idColaboradorContrato);
		}

		return null;
	}

	@Override
	public ColaboradorContratoRequestDTO buscar(ColaboradorContratoRequestDTO colaboradorContratoResponseDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
