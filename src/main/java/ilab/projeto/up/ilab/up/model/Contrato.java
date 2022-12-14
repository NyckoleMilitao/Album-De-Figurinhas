package ilab.projeto.up.ilab.up.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Table(name = "contrato")
@Entity
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contrato")
	@ApiModelProperty(value = "Identificador único de contrato")
	private Long idContrato;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id_cliente")
	@ApiModelProperty(value = "chave estrangeira para identificar o Cliente relacionado ao contrato")
	private Cliente cliente;

	@NotBlank(message = "Nome não pode estar vazio")
	@Column(name = "nome_contrato")
	@ApiModelProperty(value = "Identificar os dados do nome do contrato")
	private String nomeContrato;

	@NotNull(message = "Status não pode ser nulo")
	@Column(name = "status_contrato")
	@ApiModelProperty(value = "Identificar status do contrato")
	private boolean statusContrato;

	@Size(max = 250)
	@Column(name = "arquivo_contrato")
	@ApiModelProperty(value = "Identificar o nome do produto ")
	private String arquivoContrato;

	@NotBlank(message = "Modalidade não pode estar vazio")
	@Size(max = 50)
	@Column(name = "modalidade")
	@ApiModelProperty(value = "Identificar o nome do produto ")
	private String modalidade;

	@Column(name = "data_inicio")
	@ApiModelProperty(value = "Identificar os dados da data do inicio do contrato ")
	private LocalDate dataInicio;

	@Column(name = "data_final")
	@ApiModelProperty(value = "Identificar os dados da data final do contrato ")
	private LocalDate dataFinal;

	@NotNull(message = "Carga horaria prevista não pode estar vazio")
	@Column(name = "carga_horaria_prevista")
	@ApiModelProperty(value = "Identificar os dados da carga horaria prevista")
	private int cargaHorariaPrevista;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "contrato", fetch = FetchType.LAZY)
	private List<ColaboradorContrato> contratosColaboradoresContratos;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "contrato", fetch = FetchType.LAZY)
	private List<NotaFiscal> contratosNotasFiscais;

	public Contrato() {

	}

	public Contrato(Long idContrato, Cliente cliente,
			@NotBlank(message = "Nome não pode estar vazio") String nomeContrato,
			@NotNull(message = "Status não pode ser nulo") boolean statusContrato,
			@Size(max = 250) String arquivoContrato,
			@NotBlank(message = "Modalidade não pode estar vazio") @Size(max = 50) String modalidade,
			LocalDate dataInicio, LocalDate dataFinal,
			@NotNull(message = "Carga horaria prevista não pode estar vazio") int cargaHorariaPrevista,
			List<ColaboradorContrato> contratosColaboradoresContratos, List<NotaFiscal> contratosNotasFiscais) {
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
		this.contratosColaboradoresContratos = contratosColaboradoresContratos;
		this.contratosNotasFiscais = contratosNotasFiscais;
	}

	public Long getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(Long idContrato) {
		this.idContrato = idContrato;
	}

	public Cliente getCliente() {

		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setidCliente(Long idCliente) {
		this.cliente.setIdCliente(idCliente);
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

	public List<ColaboradorContrato> getContratosColaboradoresContratos() {
		return contratosColaboradoresContratos;
	}

	public void setContratosColaboradoresContratos(List<ColaboradorContrato> contratosColaboradoresContratos) {
		this.contratosColaboradoresContratos = contratosColaboradoresContratos;
	}

	public List<NotaFiscal> getContratosNotasFiscais() {
		return contratosNotasFiscais;
	}

	public void setContratosNotasFiscais(List<NotaFiscal> contratosNotasFiscais) {
		this.contratosNotasFiscais = contratosNotasFiscais;

	}

	@Override
	public String toString() {
		return "Contrato [idContrato=" + idContrato + ", cliente=" + cliente + ", nomeContrato=" + nomeContrato
				+ ", statusContrato=" + statusContrato + ", arquivoContrato=" + arquivoContrato + ", modalidade="
				+ modalidade + ", dataInicio=" + dataInicio + ", dataFinal=" + dataFinal + ", cargaHorariaPrevista="
				+ cargaHorariaPrevista + ", contratosColaboradoresContratos=" + contratosColaboradoresContratos
				+ ", contratosNotasFiscais=" + contratosNotasFiscais + "]";
	}

}