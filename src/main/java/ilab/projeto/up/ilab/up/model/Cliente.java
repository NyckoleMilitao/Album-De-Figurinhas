package ilab.projeto.up.ilab.up.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Table(name = "cliente")
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente", nullable = true)
	@ApiModelProperty(value = "Identificador único do cliente")
	private Long idCliente;

	@NotBlank(message = "Nome do cliente nao pode ser vazio")
	@Column(name = "nome_cliente")
	@Size(max = 200)
	@ApiModelProperty(value = "Nome do cliente", required = true)
	private String nomeCliente;

	@NotBlank(message = "CNPJ do Cliente nao pode ser vazio")
	@Column(name = "cnpj", unique = true, nullable = false, length = 18)
	@ApiModelProperty(value = "CNPJ do cliente", required = true)
	private String cnpj;

	@NotNull(message = "Status do Cliente nao pode ser nulo")
	@Column(name = "status_cliente")
	@ApiModelProperty(value = "Status do cliente")
	private boolean statusCliente;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Contrato> clientesContratos;

	public Cliente() {

	}

	public Cliente(Long idCliente,
			@NotBlank(message = "Nome do cliente nao pode ser vazio") @Size(max = 200) String nomeCliente,
			@NotBlank(message = "CNPJ do Cliente nao pode ser vazio") String cnpj,
			@NotNull(message = "Status do Cliente nao pode ser nulo") boolean statusCliente,
			List<Contrato> clientesContratos) {
		super();
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.cnpj = cnpj;
		this.statusCliente = statusCliente;
		this.clientesContratos = clientesContratos;
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

	public List<Contrato> getClientesContratos() {
		return clientesContratos;
	}

	public void setClientesContratos(List<Contrato> clientesContratos) {
		this.clientesContratos = clientesContratos;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", cnpj=" + cnpj
				+ ", statusCliente=" + statusCliente + ", clientesContratos=" + clientesContratos + "]";
	}
	
	

}
