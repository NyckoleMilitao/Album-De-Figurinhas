package ilab.projeto.up.ilab.up.dto;

import ilab.projeto.up.ilab.up.model.Colaborador;

public class ColaboradorResponseDTO {

	private Long idColaborador;
	private boolean statusColaborador;
	private String nomeColaborador;
	private String matricula;
	private double salarioBase;
	private double custo;

	public ColaboradorResponseDTO() {
		super();
	}

	public ColaboradorResponseDTO(Long idColaborador, boolean statusColaborador, String nomeColaborador,
			String matricula, double salarioBase, double custo) {
		super();
		this.idColaborador = idColaborador;
		this.statusColaborador = statusColaborador;
		this.nomeColaborador = nomeColaborador;
		this.matricula = matricula;
		this.salarioBase = salarioBase;
		this.custo = custo;
	}

	public ColaboradorResponseDTO(Colaborador colaborador) {
		super();
		this.idColaborador = colaborador.getIdColaborador();
		this.statusColaborador = colaborador.isStatusColaborador();
		this.nomeColaborador = colaborador.getNomeColaborador();
		this.matricula = colaborador.getMatricula();
		this.salarioBase = colaborador.getSalarioBase();
		this.custo = colaborador.getCusto();
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

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

}
