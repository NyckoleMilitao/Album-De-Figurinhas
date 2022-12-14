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

@Table(name = "papel")
@Entity
public class Papel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_papel")
	@ApiModelProperty(value = "Identificador unico do papel desempenhado")
	private Long idPapel;

	@NotBlank(message = "Nome do cargo nao pode ser vazio")
	@Size(message = "Nome do cargo nao pode ser maior que 100", max = 100)
	@Column(name = "nome_papel", length = 100)
	@ApiModelProperty(value = "Nome para identificar o papel desempenhado")
	private String nomePapel;

	@NotNull(message = "Valor nao pode estar vazio")
	@Column(name = "taxa_hora", nullable = false)
	@ApiModelProperty(value = "Identificar a taxa da hora trabalhada")
	private double taxaHora;

	@NotNull(message = "Valor nao pode estar vazio")
	@Column(name = "taxa_hora_extra", nullable = false)
	@ApiModelProperty(value = "Identificar a taxa da hora extra trabalhada")
	private double taxaHoraExtra;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "papel", fetch = FetchType.LAZY)
	private List<ColaboradorContrato> papeisColaboradoresContratos;

	public Papel() {

	}

	public Papel(Long idPapel, String nomePapel, double taxaHora, double taxaHoraExtra,
			List<ColaboradorContrato> papeisColaboradoresContratos) {
		super();
		this.idPapel = idPapel;
		this.nomePapel = nomePapel;
		this.taxaHora = taxaHora;
		this.taxaHoraExtra = taxaHoraExtra;
		this.papeisColaboradoresContratos = papeisColaboradoresContratos;
	}

	public Long getIdPapel() {
		return idPapel;
	}

	public void setIdPapel(Long idPapel) {
		this.idPapel = idPapel;
	}

	public String getNomePapel() {
		return nomePapel;
	}

	public void setNomePapel(String nomePapel) {
		this.nomePapel = nomePapel;
	}

	public double getTaxaHora() {
		return taxaHora;
	}

	public void setTaxaHora(double taxaHora) {
		this.taxaHora = taxaHora;
	}

	public double getTaxaHoraExtra() {
		return taxaHoraExtra;
	}

	public void setTaxaHoraExtra(double taxaHoraExtra) {
		this.taxaHoraExtra = taxaHoraExtra;
	}

	public List<ColaboradorContrato> getPapeisColaboradoresContratos() {
		return papeisColaboradoresContratos;
	}

	public void setPapeisColaboradoresContratos(List<ColaboradorContrato> papeisColaboradoresContratos) {
		this.papeisColaboradoresContratos = papeisColaboradoresContratos;
	}

	@Override
	public String toString() {
		return "Papel [idPapel=" + idPapel + ", nomePapel=" + nomePapel + ", taxaHora=" + taxaHora + ", taxaHoraExtra="
				+ taxaHoraExtra + ", papeisColaboradoresContratos=" + papeisColaboradoresContratos + "]";
	}

	
}
