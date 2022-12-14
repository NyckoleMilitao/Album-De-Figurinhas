package ilab.projeto.up.ilab.up.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ilab.projeto.up.ilab.up.dto.ContratoNomeDTO;
import ilab.projeto.up.ilab.up.dto.ContratoRequestDTO;
import ilab.projeto.up.ilab.up.dto.ContratoResponseDTO;
import ilab.projeto.up.ilab.up.model.Contrato;

public interface ContratoService {

	Page<ContratoResponseDTO> listar(Pageable pageable);

	Contrato buscar(Long id);

	ContratoResponseDTO inserir(ContratoRequestDTO ContratoRequestDTO);

	ContratoResponseDTO atualizar(Long id, ContratoRequestDTO ContratoResponseDTO);

	ContratoResponseDTO deletar(Long id);

	List<ContratoNomeDTO> buscarContratoNomes();

}
