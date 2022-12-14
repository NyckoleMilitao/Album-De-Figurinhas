package ilab.projeto.up.ilab.up.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ilab.projeto.up.ilab.up.dto.ColaboradorMatriculaDTO;
import ilab.projeto.up.ilab.up.dto.ColaboradorRequestDTO;
import ilab.projeto.up.ilab.up.dto.ColaboradorResponseDTO;
import ilab.projeto.up.ilab.up.model.Colaborador;
import ilab.projeto.up.ilab.up.repository.ColaboradorRepository;
import ilab.projeto.up.ilab.up.service.ColaboradorService;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	/**
	 * Método para listar todos os Colaboradores
	 */
	public Page<ColaboradorResponseDTO> listar(Pageable pageable) {
		Page<Colaborador> colaborador = colaboradorRepository.findAll(pageable);
		Page<ColaboradorResponseDTO> colaboradorDTO = colaborador.map(ColaboradorResponseDTO::new);

		return colaboradorDTO;
	}

	/**
	 * 
	 * @param idColaborador
	 * @return Buscando colaborador por id
	 */
	@Override
	public Colaborador buscar(Long idColaborador) {
		Optional<Colaborador> colaborador = colaboradorRepository.findById(idColaborador);
		if (colaborador.isPresent()) {
			return colaborador.get();
		}
		return null;
	}

	/**
	 * 
	 * @param statusColaborador
	 * @param IdColaborador
	 * @param colaboradorRequestDTO
	 * @return o colaborador repositorio que está setando status, nome, matricula e
	 *         salario base.
	 */

	@Override
	public ColaboradorResponseDTO inserirDTO(ColaboradorRequestDTO colaboradorRequestDTO) {
		Colaborador colaborador = new Colaborador();
		colaborador.setNomeColaborador(colaboradorRequestDTO.getNomeColaborador());
		colaborador.setMatricula(colaboradorRequestDTO.getMatricula());
		colaborador.setSalarioBase(colaboradorRequestDTO.getSalarioBase());
		colaborador.setStatusColaborador(colaboradorRequestDTO.isStatusColaborador());
		colaborador.setCusto(colaboradorRequestDTO.getCusto());
		colaboradorRepository.save(colaborador);

		return new ColaboradorResponseDTO(colaborador);
	}

	/**
	 * 
	 * @param statusColaborador
	 * @param idColaborador
	 * @param colaboradorRequestDTO
	 * @return alterar o status do colaborador para true ou false.
	 */
	@Override
	public ColaboradorResponseDTO trocaStatus(Long idColaborador, boolean statusColaborador) {
		if (colaboradorRepository.existsById(idColaborador)) {
			Colaborador colaborador = new Colaborador();
			colaborador.setStatusColaborador(statusColaborador);
			colaborador.setIdColaborador(colaboradorRepository.findByColaborador(idColaborador).getIdColaborador());
			colaborador.setNomeColaborador(colaboradorRepository.findByColaborador(idColaborador).getNomeColaborador());
			colaborador.setMatricula(colaboradorRepository.findByColaborador(idColaborador).getMatricula());
			colaborador.setSalarioBase(colaboradorRepository.findByColaborador(idColaborador).getSalarioBase());
			colaboradorRepository.save(colaborador);
			return new ColaboradorResponseDTO(colaborador);

		}

		return null;
	}

	/**
	 * 
	 * @param statusColaborador
	 * @param idColaborador
	 * @param colaboradorRequestDTO
	 * @return o colaborador com os parametros atualizados, menos id.
	 */
	@Override
	public ColaboradorResponseDTO atualizar(Long id, ColaboradorRequestDTO colaboradorRequestDTO) {

		if (colaboradorRepository.existsById(id)) {
			Colaborador colaborador = new Colaborador();
			colaborador.setIdColaborador(id);
			colaborador.setStatusColaborador(colaboradorRequestDTO.isStatusColaborador());
			colaborador.setNomeColaborador(colaboradorRequestDTO.getNomeColaborador());
			colaborador.setMatricula(colaboradorRequestDTO.getMatricula());
			colaborador.setSalarioBase(colaboradorRequestDTO.getSalarioBase());
			colaboradorRepository.save(colaborador);

			return new ColaboradorResponseDTO(colaborador);
		}
		return null;
	}

	/**
	 * Deletar colaborador por idColaborador
	 * 
	 * @param idColaborador
	 * @return se não existir o id retorna null.
	 */
	@Override
	public ColaboradorResponseDTO deletar(Long idColaborador) {

		if (colaboradorRepository.existsById(idColaborador)) {
			colaboradorRepository.deleteById(idColaborador);
		}

		return null;
	}

	@Override
	public List<ColaboradorMatriculaDTO> buscarColaboradorMatricula() {
		List<ColaboradorMatriculaDTO> listMatriculas = colaboradorRepository.findColaboradorMatricula();
		return listMatriculas;
	}

}
