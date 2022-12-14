package ilab.projeto.up.ilab.up.dto;

import java.time.LocalDateTime;

import ilab.projeto.up.ilab.up.model.ColaboradorContrato;

public class ColaboradorContratoRequestDTO {

	private Long idColaborador;
	private Long idContrato;
	private Long idPapel;
	private double esforcoTotal;
	private double esforcoExtraTotal;
	private double impostos;
	private double faturamentoTotal;
	private LocalDateTime dataBatida;

	public ColaboradorContratoRequestDTO() {
		super();
	}

	public ColaboradorContratoRequestDTO(Long idColaborador, Long idContrato, Long idPapel, double esforcoTotal,
			double esforcoExtraTotal, double impostos, double faturamentoTotal, LocalDateTime dataBatida) {
		super();
		this.idColaborador = idColaborador;
		this.idContrato = idContrato;
		this.idPapel = idPapel;
		this.esforcoTotal = esforcoTotal;
		this.esforcoExtraTotal = esforcoExtraTotal;
		this.impostos = impostos;
		this.faturamentoTotal = faturamentoTotal;
		this.dataBatida = dataBatida;
	}

	public ColaboradorContratoRequestDTO (ColaboradorContrato colaboradorContrato) {
		super();

		this.idColaborador = colaboradorContrato.getColaborador().getIdColaborador();
		this.idContrato = colaboradorContrato.getContrato().getIdContrato();
		this.idPapel = colaboradorContrato.getPapel().getIdPapel();
		this.esforcoTotal = colaboradorContrato.getEsforcoTotal();
		this.esforcoExtraTotal = colaboradorContrato.getEsforcoExtraTotal();
		this.impostos = colaboradorContrato.getImpostos();
		this.faturamentoTotal = colaboradorContrato.getFaturamentoTotal();
		this.dataBatida = colaboradorContrato.getDataBatida();
	}
	
	
	public Long getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Long idColaborador) {
		this.idColaborador = idColaborador;
	}

	public LocalDateTime getDataBatida() {
		return dataBatida;
	}

	public void setDataBatida(LocalDateTime dataBatida) {
		this.dataBatida = dataBatida;
	}

	public Long getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Long idContrato) {
		this.idContrato = idContrato;
	}

	public Long getIdPapel() {
		return idPapel;
	}

	public void setIdPapel(Long idPapel) {
		this.idPapel = idPapel;
	}

	public double getEsforcoTotal() {
		return esforcoTotal;
	}

	public void setEsforcoTotal(double esforcoTotal) {
		this.esforcoTotal = esforcoTotal;
	}

	public double getEsforcoExtraTotal() {
		return esforcoExtraTotal;
	}

	public void setEsforcoExtraTotal(double esforcoExtraTotal) {
		this.esforcoExtraTotal = esforcoExtraTotal;
	}

	public double getImpostos() {
		return impostos;
	}

	public void setImpostos(double impostos) {
		this.impostos = impostos;
	}

	public double getFaturamentoTotal() {
		return faturamentoTotal;
	}

	public void setFaturamentoTotal(double faturamentoTotal) {
		this.faturamentoTotal = faturamentoTotal;
	}
	

}
