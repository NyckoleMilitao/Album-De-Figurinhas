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

@Table(name = "colaborador")
@Entity
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_colaborador", nullable = false)
	@ApiModelProperty(value = "Identificador único do colaborador")
	private Long idColaborador;

	@NotNull(message = "Status do colaborador nao pode ser nulo")
	@Column(name = "status_colaborador")
	@ApiModelProperty(value = "Status do colaborador")
	private boolean statusColaborador;

	@NotBlank(message = "Nome do colaborador nao pode ser vazio")
	@Column(name = "nome_colaborador")
	@Size(max = 200)
	@ApiModelProperty(value = "Nome do colaborador", required = true)
	private String nomeColaborador;

	@NotBlank(message = "Matricula nao pode ser vazio")
	@Column(name = "matricula", unique = true, nullable = false, length = 6)
	@ApiModelProperty(value = "Matricula do colaborador", required = true)
	private String matricula;

	@NotNull(message = "Status do colaborador nao pode ser nulo")
	@Column(name = "salario_base", nullable = false)
	@ApiModelProperty(value = "Salario base do colaborador", required = true)
	private double salarioBase;

	@NotNull(message = "Custo do colaborador nao pode ser nulo")
	@Column(name = "custo", nullable = false)
	@ApiModelProperty(value = "Custo base do colaborador", required = true)
	private double custo;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "colaborador", fetch = FetchType.LAZY)
	private List<ColaboradorContrato> colaboradoresContratos;

	public Colaborador() {

	}

	public Colaborador(Long idColaborador,
			@NotNull(message = "Status do colaborador nao pode ser nulo") boolean statusColaborador,
			@NotBlank(message = "Nome do colaborador nao pode ser vazio") @Size(max = 200) String nomeColaborador,
			@NotBlank(message = "Matricula nao pode ser vazio") String matricula,
			@NotNull(message = "Status do colaborador nao pode ser nulo") double salarioBase, double custo,
			List<ColaboradorContrato> colaboradoresContratos) {
		super();
		this.idColaborador = idColaborador;
		this.statusColaborador = statusColaborador;
		this.nomeColaborador = nomeColaborador;
		this.matricula = matricula;
		this.salarioBase = salarioBase;
		this.custo = custo;
		this.colaboradoresContratos = colaboradoresContratos;
	}

	public Long getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Long idColaborador) {
		this.idColaborador = idColaborador;
	}

	public boolean isStatusColaborador() {
		return statusColaborador;
	}

	public void setStatusColaborador(boolean statusColaborador) {
		this.statusColaborador = statusColaborador;
	}

	public String getNomeColaborador() {
		return nomeColaborador;
	}

	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public List<ColaboradorContrato> getColaboradoresContratos() {
		return colaboradoresContratos;
	}

	public void setColaboradoresContratos(List<ColaboradorContrato> colaboradoresContratos) {
		this.colaboradoresContratos = colaboradoresContratos;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	@Override
	public String toString() {
		return "Colaborador [idColaborador=" + idColaborador + ", statusColaborador=" + statusColaborador
				+ ", nomeColaborador=" + nomeColaborador + ", matricula=" + matricula + ", salarioBase=" + salarioBase
				+ ", custo=" + custo + ", colaboradoresContratos=" + colaboradoresContratos + "]";
	}

	
}
