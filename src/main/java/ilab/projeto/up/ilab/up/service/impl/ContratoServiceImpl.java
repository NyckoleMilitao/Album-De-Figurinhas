package ilab.projeto.up.ilab.up.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ilab.projeto.up.ilab.up.dto.ContratoNomeDTO;
import ilab.projeto.up.ilab.up.dto.ContratoRequestDTO;
import ilab.projeto.up.ilab.up.dto.ContratoResponseDTO;
import ilab.projeto.up.ilab.up.model.Contrato;
import ilab.projeto.up.ilab.up.repository.ClienteRepository;
import ilab.projeto.up.ilab.up.repository.ContratoRepository;
import ilab.projeto.up.ilab.up.service.ContratoService;

@Service
public class ContratoServiceImpl implements ContratoService {

	@Autowired
	private ContratoRepository contratoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	/**
	 * 
	 * @param pageable
	 * @return Aqui está listando todos os registros
	 */
	public Page<ContratoResponseDTO> listar(Pageable pageable) {
		Page<Contrato> contrato = contratoRepository.findAll(pageable);
		System.out.println(contrato.toString());
		Page<ContratoResponseDTO> contratoDTO = contrato.map(ContratoResponseDTO::new);

		return contratoDTO;
	}

	/**
	 * 
	 * @param id
	 * @return Aqui está buscando um registro
	 */
	@Override
	public Contrato buscar(Long id) {
		if (contratoRepository.existsById(id)) {
			Optional<Contrato> contrato = contratoRepository.findById(id);
			if (contrato.isPresent()) {
				return contrato.get();
			}
		}
		return null;

	}

	/**
	 * 
	 * @param contratoRequestDTO
	 * @return Aqui está inserindo um registro
	 */
	public ContratoResponseDTO inserir(ContratoRequestDTO contratoRequestDTO) {

		Contrato contrato = new Contrato();

		contrato.setCliente(clienteRepository.findByIdCliente(contratoRequestDTO.getIdCliente()));
		contrato.setNomeContrato(contratoRequestDTO.getNomeContrato());
		contrato.setStatusContrato(contratoRequestDTO.isStatusContrato());
		contrato.setArquivoContrato(contratoRequestDTO.getArquivoContrato());
		contrato.setModalidade(contratoRequestDTO.getModalidade());
		contrato.setDataInicio(contratoRequestDTO.getDataInicio());
		contrato.setDataFinal(contratoRequestDTO.getDataFinal());
		contrato.setCargaHorariaPrevista(contratoRequestDTO.getCargaHorariaPrevista());
		contratoRepository.save(contrato);

		return new ContratoResponseDTO(contrato);
	}

	/**
	 * 
	 * @param idContrato
	 * @return Aqui está fazendo uma atualização
	 */
	@Override
	public ContratoResponseDTO atualizar(Long idContrato, ContratoRequestDTO contratoRequestDTO) {

		if (contratoRepository.existsById(idContrato)) {

			Contrato contrato = new Contrato();
			contrato.setCliente(clienteRepository.findByIdCliente(contratoRequestDTO.getIdCliente()));
			contrato.setIdContrato(idContrato);
			contrato.setNomeContrato(contratoRequestDTO.getNomeContrato());
			contrato.setStatusContrato(contratoRequestDTO.isStatusContrato());
			contrato.setArquivoContrato(contratoRequestDTO.getArquivoContrato());
			contrato.setModalidade(contratoRequestDTO.getModalidade());
			contrato.setDataInicio(contratoRequestDTO.getDataInicio());
			contrato.setDataFinal(contratoRequestDTO.getDataFinal());
			contrato.setCargaHorariaPrevista(contratoRequestDTO.getCargaHorariaPrevista());
			contratoRepository.save(contrato);
			return new ContratoResponseDTO(contrato);

		}
		return null;

	}

	/**
	 * 
	 * @param idContrato
	 * @return Aqui está fazendo um Delete
	 */
	public ContratoResponseDTO deletar(Long idContrato) {

		if (contratoRepository.existsById(idContrato)) {

			contratoRepository.deleteById(idContrato);

		}

		return null;
	}

	/**
	 * 
	 * @param ContratoNomeDTO
	 * @return Aqui está fazendo uma Query no banco de Contratos por nome
	 */
	@Override
	public List<ContratoNomeDTO> buscarContratoNomes() {
		List<ContratoNomeDTO> listContratoNomes = contratoRepository.findContratos();
		return listContratoNomes;
	}

}