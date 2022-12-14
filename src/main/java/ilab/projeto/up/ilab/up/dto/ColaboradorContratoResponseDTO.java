package ilab.projeto.up.ilab.up.dto;

import java.time.LocalDateTime;

import ilab.projeto.up.ilab.up.model.ColaboradorContrato;

public class ColaboradorContratoResponseDTO {

	private Long idColaboradorContrato;
	private ColaboradorResponseDTO colaborador;
	private ContratoResponseDTO contrato;
	private PapelResponseDTO papel;
	private double esforcoTotal;
	private double esforcoExtraTotal;
	private double impostos;
	private double faturamentoTotal;
	private LocalDateTime dataBatida;

	public ColaboradorContratoResponseDTO() {
		super();
	}

	public ColaboradorContratoResponseDTO(Long idColaboradorContrato, ColaboradorResponseDTO colaborador,
			ContratoResponseDTO contrato, PapelResponseDTO papel, double esforcoTotal, double esforcoExtraTotal,
			double impostos, double faturamentoTotal, LocalDateTime dataBatida) {
		super();
		this.idColaboradorContrato = idColaboradorContrato;
		this.colaborador = colaborador;
		this.contrato = contrato;
		this.papel = papel;
		this.esforcoTotal = esforcoTotal;
		this.esforcoExtraTotal = esforcoExtraTotal;
		this.impostos = impostos;
		this.faturamentoTotal = faturamentoTotal;
		this.dataBatida = dataBatida;
	}

	public ColaboradorContratoResponseDTO(ColaboradorContrato colaboradorContrato) {
		super();
		this.idColaboradorContrato = colaboradorContrato.getIdColaboradorContrato();
		this.colaborador = new ColaboradorResponseDTO(colaboradorContrato.getColaborador());
		this.contrato = new ContratoResponseDTO(colaboradorContrato.getContrato());
		this.papel = new PapelResponseDTO(colaboradorContrato.getPapel());
		this.esforcoTotal = colaboradorContrato.getEsforcoTotal();
		this.esforcoExtraTotal = colaboradorContrato.getEsforcoExtraTotal();
		this.impostos = colaboradorContrato.getImpostos();
		this.faturamentoTotal = colaboradorContrato.getFaturamentoTotal();
		this.dataBatida = colaboradorContrato.getDataBatida();

	}

	public Long getIdColaboradorContrato() {
		return idColaboradorContrato;
	}

	public void setIdColaboradorContrato(Long idColaboradorContrato) {
		this.idColaboradorContrato = idColaboradorContrato;
	}

	public ColaboradorResponseDTO getColaborador() {
		return colaborador;
	}

	public void setColaborador(ColaboradorResponseDTO colaborador) {
		this.colaborador = colaborador;
	}

	public ContratoResponseDTO getContrato() {
		return contrato;
	}

	public void setContrato(ContratoResponseDTO contrato) {
		this.contrato = contrato;
	}

	public PapelResponseDTO getPapel() {
		return papel;
	}

	public void setPapel(PapelResponseDTO papel) {
		this.papel = papel;
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

	public LocalDateTime getDataBatida() {
		return dataBatida;
	}

	public void setDataBatida(LocalDateTime dataBatida) {
		this.dataBatida = dataBatida;
	}

}