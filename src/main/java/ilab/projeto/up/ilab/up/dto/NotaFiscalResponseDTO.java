package ilab.projeto.up.ilab.up.dto;

import java.util.Date;
import ilab.projeto.up.ilab.up.model.NotaFiscal;

public class NotaFiscalResponseDTO {

	private Long idNotaFiscal;
	private ContratoResponseDTO contrato;
	private int numControleNota;
	private Date dataEmissaoNota;
	private float valorTotalNota;
	private boolean statusNota;

	public NotaFiscalResponseDTO() {
		super();
	}

	public NotaFiscalResponseDTO(Long idNotaFiscal, ContratoResponseDTO contratoResponseDTO, int numControleNota,
			Date dataEmissaoNota, float valorTotalNota, boolean statusNota) {
		this.idNotaFiscal = idNotaFiscal;
		this.contrato = contratoResponseDTO;
		this.numControleNota = numControleNota;
		this.dataEmissaoNota = dataEmissaoNota;
		this.valorTotalNota = valorTotalNota;
		this.statusNota = statusNota;
	}

	public NotaFiscalResponseDTO(NotaFiscal notaFiscal) {
		super();
		this.idNotaFiscal = notaFiscal.getIdNotaFiscal();
		this.contrato = new ContratoResponseDTO(notaFiscal.getContrato());
		this.numControleNota = notaFiscal.getNumControleNota();
		this.dataEmissaoNota = notaFiscal.getDataEmissaoNota();
		this.valorTotalNota = notaFiscal.getValorTotalNota();
		this.statusNota = notaFiscal.isStatusNota();
	}

	public Long getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public void setIdNotaFiscal(Long idNotaFiscal) {
		this.idNotaFiscal = idNotaFiscal;
	}

	public ContratoResponseDTO getContrato() {
		return contrato;
	}

	public void setContrato(ContratoResponseDTO contratoResponseDTO) {
		this.contrato = contratoResponseDTO;
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
