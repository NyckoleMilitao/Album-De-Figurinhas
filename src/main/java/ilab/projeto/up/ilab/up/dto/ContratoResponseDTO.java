package ilab.projeto.up.ilab.up.dto;

import java.time.LocalDate;

import ilab.projeto.up.ilab.up.model.Contrato;

public class ContratoResponseDTO {

	private Long idContrato;
	private ClienteResponseDTO cliente;
	private String nomeContrato;
	private boolean statusContrato;
	private String arquivoContrato;
	private String modalidade;
	private LocalDate dataInicio;
	private LocalDate dataFinal;
	private int cargaHorariaPrevista;

	public ContratoResponseDTO() {

	}

	public ContratoResponseDTO(Long idContrato, ClienteResponseDTO cliente, String nomeContrato, boolean statusContrato,
			String arquivoContrato, String modalidade, LocalDate dataInicio, LocalDate dataFinal,
			int cargaHorariaPrevista) {
		super();
		this.idContrato = idContrato;
		this.cliente = cliente;
		this.nomeContrato = nomeContrato;
		this.statusContrato = statusContrato;
		this.arquivoContrato = arquivoContrato;
		this.modalidade = modalidade;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.cargaHorariaPrevista = cargaHorariaPrevista;
	}

	public ContratoResponseDTO(Contrato contrato) {
		super();
		this.idContrato = contrato.getIdContrato();
		this.cliente = new ClienteResponseDTO(contrato.getCliente());
		this.nomeContrato = contrato.getNomeContrato();
		this.statusContrato = contrato.isStatusContrato();
		this.arquivoContrato = contrato.getArquivoContrato();
		this.modalidade = contrato.getModalidade();
		this.dataInicio = contrato.getDataInicio();
		this.dataFinal = contrato.getDataFinal();
		this.cargaHorariaPrevista = contrato.getCargaHorariaPrevista();
	}

	public Long getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Long idContrato) {
		this.idContrato = idContrato;
	}

	public ClienteResponseDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteResponseDTO cliente) {
		this.cliente = cliente;
	}

	public String getNomeContrato() {
		return nomeContrato;
	}

	public void setNomeContrato(String nomeContrato) {
		this.nomeContrato = nomeContrato;
	}

	public boolean isStatusContrato() {
		return statusContrato;
	}

	public void setStatusContrato(boolean statusContrato) {
		this.statusContrato = statusContrato;
	}

	public String getArquivoContrato() {
		return arquivoContrato;
	}

	public void setArquivoContrato(String arquivoContrato) {
		this.arquivoContrato = arquivoContrato;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public int getCargaHorariaPrevista() {
		return cargaHorariaPrevista;
	}

	public void setCargaHorariaPrevista(int cargaHorariaPrevista) {
		this.cargaHorariaPrevista = cargaHorariaPrevista;
	}

}
