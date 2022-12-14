package ilab.projeto.up.ilab.up.dto;

import java.time.LocalDate;


import ilab.projeto.up.ilab.up.model.Contrato;

public class ContratoRequestDTO {

	private Long idCliente;
	private String nomeContrato;
	private boolean statusContrato;
	private String arquivoContrato;
	private String modalidade;
	private LocalDate dataInicio;
	private LocalDate dataFinal;
	private int cargaHorariaPrevista;

	public ContratoRequestDTO() {
		
	}

	public ContratoRequestDTO(Long idCliente, String nomeContrato, boolean statusContrato, String arquivoContrato,
	String modalidade, LocalDate dataInicio, LocalDate dataFinal, int cargaHorariaPrevista) {
		super();
		this.idCliente = idCliente;
		this.nomeContrato = nomeContrato;
		this.statusContrato = statusContrato;
		this.arquivoContrato = arquivoContrato;
		this.modalidade = modalidade;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.cargaHorariaPrevista = cargaHorariaPrevista;
	}

	public ContratoRequestDTO(Contrato contrato) {
		super();
		this.idCliente = contrato.getCliente().getIdCliente();
		this.nomeContrato = contrato.getNomeContrato();
		this.statusContrato = contrato.isStatusContrato();
		this.arquivoContrato = contrato.getArquivoContrato();
		this.modalidade = contrato.getModalidade();
		this.dataInicio = contrato.getDataInicio();
		this.dataFinal = contrato.getDataFinal();
		this.cargaHorariaPrevista = contrato.getCargaHorariaPrevista();
	}

	public Long getIdCliente(){
		return idCliente;
	}

	public void setCliente(Long idCliente) {
		this.idCliente = idCliente;
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
