package ilab.projeto.up.ilab.up.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Table(name = "colaborador_contrato")
@Entity
public class ColaboradorContrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_colaborador_contrato")
	@ApiModelProperty(value = " identificador único de contrato")
	private Long idColaboradorContrato;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "colaborador_id_colaborador")
	@ApiModelProperty(value = "chave estrangeira para identificar o contrato_colaborador relacionado ao colaborador")
	private Colaborador colaborador;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "contrato_id_contrato")
	@ApiModelProperty(value = "chave estrangeira para identificar o contrato_colaborador relacionado ao contrato")
	private Contrato contrato;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "papel_id_papel")
	@ApiModelProperty(value = "chave estrangeira para identificar o papel relacionado ao colaborador")
	private Papel papel;

	@NotNull(message = "Esforço total não pode ser nulo")
	@Column(name = "esforco_total")
	@ApiModelProperty(value = "Identificar os dados da hora trabalhada")
	private double esforcoTotal;

	@NotNull(message = "Esforço Extra total não pode ser nulo")
	@Column(name = "esforco_extra_total")
	@ApiModelProperty(value = "Identificar os dados da hora trabalhada total")
	private double esforcoExtraTotal;

	@NotNull(message = "Impostos total não pode ser nulo")
	@Column(name = "impostos")
	@ApiModelProperty(value = "Identificar os impostos devidos")
	private double impostos;

	@NotNull(message = "Faturamento total não pode ser nulo")
	@Column(name = "faturamento_total")
	@ApiModelProperty(value = "Identificar o faturamento total")
	private double faturamentoTotal;

	@Column(name = "data_batida")
	@ApiModelProperty(value = "Identificar o horario da batida")
	private LocalDateTime dataBatida;

	public ColaboradorContrato() {

	}

	public ColaboradorContrato(Long idColaboradorContrato, Colaborador colaborador, Contrato contrato, Papel papel,
			@NotNull(message = "Esforço total não pode ser nulo") double esforcoTotal,
			@NotNull(message = "Esforço total não pode ser nulo") double esforcoExtraTotal,
			@NotNull(message = "Esforço total não pode ser nulo") double impostos,
			@NotNull(message = "Esforço total não pode ser nulo") double faturamentoTotal, LocalDateTime dataBatida) {
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

	public Long getIdColaboradorContrato() {
		return idColaboradorContrato;
	}

	public void setIdColaboradorContrato(Long idColaboradorContrato) {
		this.idColaboradorContrato = idColaboradorContrato;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
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

	public Long getIdPapel() {
		return papel.getIdPapel();
	}

	public Long getIdContrato() {
		return contrato.getIdContrato();
	}

	public void setIdColaborador(Long id) {

		this.colaborador.setIdColaborador(id);

	}

	public void setIdContrato(Long id) {

		this.contrato.setIdContrato(id);

	}

	public void setIdPapel(Long id) {

		this.papel.setIdPapel(id);

	}

	public Long getIdColaborador() {
		return colaborador.getIdColaborador();
	}

	@Override
	public String toString() {
		return "ColaboradorContrato [idColaboradorContrato=" + idColaboradorContrato + ", colaborador=" + colaborador
				+ ", contrato=" + contrato + ", papel=" + papel + ", esforcoTotal=" + esforcoTotal
				+ ", esforcoExtraTotal=" + esforcoExtraTotal + ", impostos=" + impostos + ", faturamentoTotal="
				+ faturamentoTotal + ", dataBatida=" + dataBatida + "]";
	}

	
}
