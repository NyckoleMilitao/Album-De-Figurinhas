package ilab.projeto.up.ilab.up.dto;

import ilab.projeto.up.ilab.up.model.Cliente;


public class ClienteResponseDTO {

	private Long idCliente;
	private String nomeCliente;
	private String cnpj;
	private boolean statusCliente;

	public ClienteResponseDTO() {

	}

	public ClienteResponseDTO(Long idCliente, String nomeCliente, String cnpj, boolean statusCliente) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.cnpj = cnpj;
		this.statusCliente = statusCliente;
	}

	public ClienteResponseDTO(Cliente cliente) {
		super();
		this.idCliente = cliente.getIdCliente();
		this.nomeCliente = cliente.getNomeCliente();
		this.cnpj = cliente.getCnpj();
		this.statusCliente = cliente.isStatusCliente();
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public boolean isStatusCliente() {
		return statusCliente;
	}

	public void setStatusCliente(boolean statusCliente) {
		this.statusCliente = statusCliente;
	}

}
