package ilab.projeto.up.ilab.up.dto;

import ilab.projeto.up.ilab.up.model.Papel;

public class PapelResponseDTO {

	private Long idPapel;
	private String nomePapel;
	private Double taxaHora;
	private Double taxaHoraExtra;

	public PapelResponseDTO() {
		super();
	}

	
	public PapelResponseDTO(Long idPapel, String nomePapel, Double taxaHora, Double taxaHoraExtra) {
		this.idPapel = idPapel;
		this.nomePapel = nomePapel;
		this.taxaHora = taxaHora;
		this.taxaHoraExtra = taxaHoraExtra;
	}

	public PapelResponseDTO(Papel papel) {
		super();
		this.idPapel = papel.getIdPapel();
		this.nomePapel = papel.getNomePapel();
		this.taxaHora = papel.getTaxaHora();
		this.taxaHoraExtra = papel.getTaxaHoraExtra();
	}

	public Long getIdPapel() {
		return idPapel;
	}

	public void setIdPapel(Long idPapel) {
		this.idPapel = idPapel;
	}

	public String getNomePapel() {
		return nomePapel;
	}

	public void setNomePapel(String nomePapel) {
		this.nomePapel = nomePapel;
	}

	public double getTaxaHora() {
		return taxaHora;
	}

	public void setTaxaHora(Double taxaHora) {
		this.taxaHora = taxaHora;
	}

	public double getTaxaHoraExtra() {
		return taxaHoraExtra;
	}

	public void setTaxaHoraExtra(Double taxaHoraExtra) {
		this.taxaHoraExtra = taxaHoraExtra;
	}

}
