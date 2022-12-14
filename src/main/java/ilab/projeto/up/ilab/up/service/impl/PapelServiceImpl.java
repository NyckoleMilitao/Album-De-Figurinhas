package ilab.projeto.up.ilab.up.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ilab.projeto.up.ilab.up.dto.PapelRequestDTO;
import ilab.projeto.up.ilab.up.dto.PapelResponseDTO;
import ilab.projeto.up.ilab.up.model.Papel;
import ilab.projeto.up.ilab.up.repository.PapelRepository;
import ilab.projeto.up.ilab.up.service.PapelService;

@Service
public class PapelServiceImpl implements PapelService {

	@Autowired
	private PapelRepository papelRepository;

	@Override
	public Page<PapelResponseDTO> listar(Pageable pageable) {
		Page<Papel> papel = papelRepository.findAll(pageable);
		Page<PapelResponseDTO> papelDTO = papel.map(PapelResponseDTO::new);

		return papelDTO;
	}
	
	@Override
	public Papel buscar(Long idPapel) {
		Optional<Papel> papel = papelRepository.findById(idPapel);
		if (papel.isPresent()) {
			return papel.get();
		}
		return null;
	}
	
	@Override
	public PapelResponseDTO inserirDTO(PapelRequestDTO papelRequestDTO) {

		Papel papel = new Papel();
		papel.setNomePapel(papelRequestDTO.getNomePapel());
		papel.setTaxaHora(papelRequestDTO.getTaxaHora());
		papel.setTaxaHoraExtra(papelRequestDTO.getTaxaHoraExtra());
		papelRepository.saveAndFlush(papel);
		return new PapelResponseDTO(papel);

	}
	
	@Override
	public PapelResponseDTO atualizar(Long idPapel, PapelRequestDTO papelRequestDTO) {

		if (papelRepository.existsById(idPapel)) {

			Papel papel = new Papel();
			papel.setIdPapel(idPapel);
			papel.setNomePapel(papelRequestDTO.getNomePapel());
			papel.setTaxaHora(papelRequestDTO.getTaxaHora());
			papel.setTaxaHoraExtra(papelRequestDTO.getTaxaHoraExtra());

			return new PapelResponseDTO(papelRepository.save(papel));

		}
		return null;
	}
	
	
	public PapelRepository deletar(Long idPapel) {

		if (papelRepository.existsById(idPapel)) {
			papelRepository.deleteById(idPapel);
		}

		return null;
	}

}
