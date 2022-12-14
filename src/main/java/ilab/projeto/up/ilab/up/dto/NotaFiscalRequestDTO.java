package ilab.projeto.up.ilab.up.dto;

import java.util.Date;
import ilab.projeto.up.ilab.up.model.NotaFiscal;

public class NotaFiscalRequestDTO {

	private Long idContrato;
	private int numControleNota;
	private Date dataEmissaoNota;
	private float valorTotalNota;
	private boolean statusNota;

	public NotaFiscalRequestDTO() {
		super();
	}

	public NotaFiscalRequestDTO(Long idContrato, int numControleNota, Date dataEmissaoNota, float valorTotalNota,
			boolean statusNota) {
		this.idContrato = idContrato;
		this.numControleNota = numControleNota;
		this.dataEmissaoNota = dataEmissaoNota;
		this.valorTotalNota = valorTotalNota;
		this.statusNota = statusNota;
	}

	public NotaFiscalRequestDTO(NotaFiscal notaFiscal) {
		super();
		this.idContrato = notaFiscal.getContrato().getIdContrato();
		this.numControleNota = notaFiscal.getNumControleNota();
		this.dataEmissaoNota = notaFiscal.getDataEmissaoNota();
		this.valorTotalNota = notaFiscal.getValorTotalNota();
		this.statusNota = notaFiscal.isStatusNota();
	}

	public Long getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Long idContrato) {
		this.idContrato = idContrato;
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

}
