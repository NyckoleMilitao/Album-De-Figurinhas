package ilab.projeto.up.ilab.up.dto;

import ilab.projeto.up.ilab.up.model.Papel;

public class PapelRequestDTO {

	private String nomePapel;
	private double taxaHora;
	private double taxaHoraExtra;

	public PapelRequestDTO() {
		super();
	}

	public PapelRequestDTO(String nomePapel, double taxaHora, double taxaHoraExtra) {
		this.nomePapel = nomePapel;
		this.taxaHora = taxaHora;
		this.taxaHoraExtra = taxaHoraExtra;
	}

	public PapelRequestDTO(Papel papel) {
		super();
		this.nomePapel = papel.getNomePapel();
		this.taxaHora = papel.getTaxaHora();
		this.taxaHoraExtra = papel.getTaxaHoraExtra();
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

	public void setTaxaHora(double taxaHora) {
		this.taxaHora = taxaHora;
	}

	public double getTaxaHoraExtra() {
		return taxaHoraExtra;
	}

	public void setTaxaHoraExtra(double taxaHoraExtra) {
		this.taxaHoraExtra = taxaHoraExtra;
	}

}
