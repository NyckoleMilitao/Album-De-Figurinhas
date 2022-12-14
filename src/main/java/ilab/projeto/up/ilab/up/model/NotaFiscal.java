package ilab.projeto.up.ilab.up.model;

import java.util.Date;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Table(name = "nota_fiscal")
@Entity
public class NotaFiscal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nota_fiscal")
	@ApiModelProperty(value = "Identificador unico de Nota Fiscal", required = true)
	private Long idNotaFiscal;

	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	@JoinColumn(name = "contrato_id_contrato")
	@ApiModelProperty(value = "Identificador unico de Contrato em Nota Fiscal")
	private Contrato contrato;

	@NotNull(message = "Nome não pode estar vazio")
	@Column(name = "num_controle_nota")
	@ApiModelProperty(value = "Numero de controle de Nota Fiscal")
	private int numControleNota;

	@Column(name = "data_emissao_nota")
	@ApiModelProperty(value = "Data de emissao da Nota Fiscal")
	private Date dataEmissaoNota;

	@NotNull(message = "Nome não pode estar vazio")
	@Column(name = "valor_total_nota")
	@ApiModelProperty(value = "Valor total da Nota Fiscal")
	private float valorTotalNota;

	@NotNull(message = "Nome não pode estar vazio")
	@Column(name = "status_nota")
	@ApiModelProperty(value = "Status da Nota Fiscal")
	private boolean statusNota;

	public NotaFiscal() {

	}

	public NotaFiscal(Long idNotaFiscal, Contrato contrato,
			@NotBlank(message = "Nome não pode estar vazio") int numControleNota,
			Date dataEmissaoNota,
			@NotNull(message = "Nome não pode estar vazio") float valorTotalNota,
			@NotBlank(message = "Nome não pode estar vazio") boolean statusNota) {
		super();
		this.idNotaFiscal = idNotaFiscal;
		this.contrato = contrato;
		this.numControleNota = numControleNota;
		this.dataEmissaoNota = dataEmissaoNota;
		this.valorTotalNota = valorTotalNota;
		this.statusNota = statusNota;
	}

	public Long getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public void setIdNotaFiscal(Long idNotaFiscal) {
		this.idNotaFiscal = idNotaFiscal;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public int getNumControleNota() {
		return numControleNota;
	}

	public void setNumControleNota(int numControleNota) {
		this.numControleNota = numControleNota;
	}

	public Date getDataEmissaoNota() {
		return dataEmissaoNota;
	}

	public void setDataEmissaoNota(Date dataEmissaoNota) {
		this.dataEmissaoNota = dataEmissaoNota;
	}

	public float getValorTotalNota() {
		return valorTotalNota;
	}

	public void setValorTotalNota(float valorTotalNota) {
		this.valorTotalNota = valorTotalNota;
	}

	public boolean isStatusNota() {
		return statusNota;
	}

	public void setStatusNota(boolean statusNota) {
		this.statusNota = statusNota;
	}

	@Override
	public String toString() {
		return "NotaFiscal [idNotaFiscal=" + idNotaFiscal + ", contrato=" + contrato + ", numControleNota="
				+ numControleNota + ", dataEmissaoNota=" + dataEmissaoNota + ", valorTotalNota=" + valorTotalNota
				+ ", statusNota=" + statusNota + "]";
	}

}
