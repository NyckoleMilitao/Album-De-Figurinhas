package ilab.projeto.up.ilab.up.dto;

import ilab.projeto.up.ilab.up.model.Cliente;

public class ClienteRequestDTO {

	private String nomeCliente;
	private String cnpj;
	private boolean statusCliente;

	public ClienteRequestDTO() {
		super();
	}

	public ClienteRequestDTO(String nomeCliente, String cnpj, boolean statusCliente) {
		super();
		this.nomeCliente = nomeCliente;
		this.cnpj= cnpj;
		this.statusCliente = statusCliente;
	}

	public ClienteRequestDTO(Cliente cliente) {
		super();
		this.nomeCliente = cliente.getNomeCliente();
		this.cnpj = cliente.getCnpj();
		this.statusCliente = cliente.isStatusCliente();
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
