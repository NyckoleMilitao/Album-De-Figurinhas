package ilab.projeto.up.ilab.up.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ilab.projeto.up.ilab.up.dto.NotaFiscalRequestDTO;
import ilab.projeto.up.ilab.up.dto.NotaFiscalResponseDTO;
import ilab.projeto.up.ilab.up.model.NotaFiscal;

public interface NotaFiscalService {

	public Page<NotaFiscal> listar(Pageable pageable);

	public NotaFiscal buscar(Long idNotaFiscal);

	public NotaFiscalResponseDTO inserir(NotaFiscalRequestDTO notaFiscalRequestDTO);

	public NotaFiscalResponseDTO atualizar(Long idNotaFiscal, NotaFiscalRequestDTO notaFiscalResponseDTO);
	
	public NotaFiscalResponseDTO trocaStatus(Long id, NotaFiscalRequestDTO notaFiscalResponseDTO);

}
