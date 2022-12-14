package ilab.projeto.up.ilab.up.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ilab.projeto.up.ilab.up.dto.NotaFiscalRequestDTO;
import ilab.projeto.up.ilab.up.dto.NotaFiscalResponseDTO;
import ilab.projeto.up.ilab.up.model.NotaFiscal;
import ilab.projeto.up.ilab.up.repository.NotaFiscalRepository;
import ilab.projeto.up.ilab.up.service.NotaFiscalService;

@Service
public class NotaFiscalServiceImpl implements NotaFiscalService {

	@Autowired
	private NotaFiscalRepository notaFiscalRepository;

	@Autowired
	private ContratoServiceImpl contratoServiceImpl;

	public Page<NotaFiscal> listar(Pageable pageable) {
		Page<NotaFiscal> notaFiscal = notaFiscalRepository.findAll(pageable);
		return notaFiscal;
	}

	public NotaFiscal buscar(Long idNotaFiscal) {
		Optional<NotaFiscal> notaFiscal = notaFiscalRepository.findById(idNotaFiscal);
		if (notaFiscal.isPresent()) {
			return notaFiscal.get();
		}
		return null;
	}

	@Override
	public NotaFiscalResponseDTO inserir(NotaFiscalRequestDTO notaFiscalRequestDTO) {
		NotaFiscal notaFiscal = new NotaFiscal();
		notaFiscal.setContrato(contratoServiceImpl.buscar(notaFiscalRequestDTO.getIdContrato()));
		notaFiscal.setNumControleNota(notaFiscalRequestDTO.getNumControleNota());
		notaFiscal.setValorTotalNota(notaFiscalRequestDTO.getValorTotalNota());
		notaFiscal.setStatusNota(notaFiscalRequestDTO.isStatusNota());
		notaFiscalRepository.save(notaFiscal);
		return new NotaFiscalResponseDTO(notaFiscal);
	}

	@Override
	public NotaFiscalResponseDTO atualizar(Long idNotaFiscal, NotaFiscalRequestDTO notaFiscalRequestDTO) {
		if (notaFiscalRepository.existsById(idNotaFiscal)) {
			NotaFiscal notaFiscal = new NotaFiscal();
			notaFiscal.setIdNotaFiscal(idNotaFiscal);
			notaFiscal.setContrato(contratoServiceImpl.buscar(notaFiscalRequestDTO.getIdContrato()));
			notaFiscal.setNumControleNota(notaFiscalRequestDTO.getNumControleNota());
			notaFiscal.setValorTotalNota(notaFiscalRequestDTO.getValorTotalNota());
			notaFiscal.setStatusNota(notaFiscalRequestDTO.isStatusNota());
			notaFiscalRepository.save(notaFiscal);
			return new NotaFiscalResponseDTO(notaFiscal);
		}
		return null;
	}

	public NotaFiscalResponseDTO trocaStatusNota(Long idNotaFiscal, NotaFiscalRequestDTO notaFiscalRequestDTO) {
		if (notaFiscalRepository.existsById(idNotaFiscal)) {
			NotaFiscal notaFiscal = new NotaFiscal();
			notaFiscal.setIdNotaFiscal(idNotaFiscal);
			notaFiscal.setStatusNota(notaFiscalRequestDTO.isStatusNota());
			notaFiscalRepository.save(notaFiscal);
			return new NotaFiscalResponseDTO(notaFiscal);
		}
		return null;
	}

	public NotaFiscal deletar(Long idNotaFiscal) {

		if (notaFiscalRepository.existsById(idNotaFiscal)) {

			notaFiscalRepository.deleteById(idNotaFiscal);

		}

		return null;
	}

	@Override
	public NotaFiscalResponseDTO trocaStatus(Long id, NotaFiscalRequestDTO notaFiscalResponseDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
