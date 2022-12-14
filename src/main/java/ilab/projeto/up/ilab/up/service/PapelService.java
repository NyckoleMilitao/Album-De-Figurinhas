package ilab.projeto.up.ilab.up.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ilab.projeto.up.ilab.up.dto.PapelRequestDTO;
import ilab.projeto.up.ilab.up.dto.PapelResponseDTO;
import ilab.projeto.up.ilab.up.model.Papel;

public interface PapelService {

	public Page<PapelResponseDTO> listar(Pageable pageable);

	public Papel buscar(Long id);

	PapelResponseDTO inserirDTO(PapelRequestDTO papelRequestDTO);

	public PapelResponseDTO atualizar(Long idPapel, PapelRequestDTO papelRequestDTO);

}
