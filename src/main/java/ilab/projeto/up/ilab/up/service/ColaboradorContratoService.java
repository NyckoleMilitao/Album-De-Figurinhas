package ilab.projeto.up.ilab.up.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ilab.projeto.up.ilab.up.dto.ColaboradorContratoRequestDTO;
import ilab.projeto.up.ilab.up.dto.ColaboradorContratoResponseDTO;


public interface ColaboradorContratoService {

	public Page<ColaboradorContratoResponseDTO> listar(Pageable pageable);

	public ColaboradorContratoRequestDTO buscar(ColaboradorContratoRequestDTO colaboradorContratoRequestDTO);
	
	public ColaboradorContratoResponseDTO buscar(Long idColaboradorContrato);

	public ColaboradorContratoResponseDTO inserir(ColaboradorContratoRequestDTO colaboradorContratoRequestDTO);

	public ColaboradorContratoResponseDTO atualizar(Long idColaboradorContrato,
			ColaboradorContratoRequestDTO colaboradorContratoResponseDTO);

	public ColaboradorContratoResponseDTO deletar(Long idColaboradorContrato);

}
