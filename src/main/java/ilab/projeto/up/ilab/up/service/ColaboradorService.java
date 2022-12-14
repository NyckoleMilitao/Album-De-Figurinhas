package ilab.projeto.up.ilab.up.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ilab.projeto.up.ilab.up.dto.ColaboradorMatriculaDTO;
import ilab.projeto.up.ilab.up.dto.ColaboradorRequestDTO;
import ilab.projeto.up.ilab.up.dto.ColaboradorResponseDTO;
import ilab.projeto.up.ilab.up.model.Colaborador;

public interface ColaboradorService {

	public Page<ColaboradorResponseDTO> listar(Pageable pageable);

	public Colaborador buscar(Long id);
	
	public ColaboradorResponseDTO inserirDTO(ColaboradorRequestDTO ColaboradorResponseDTO);
	
	public ColaboradorResponseDTO atualizar(Long id, ColaboradorRequestDTO ColaboradorResponseDTO);
	
	public ColaboradorResponseDTO trocaStatus(Long idColaborador, boolean statusColaborador);

	public ColaboradorResponseDTO deletar(Long id);
	
	public List<ColaboradorMatriculaDTO> buscarColaboradorMatricula();

}
