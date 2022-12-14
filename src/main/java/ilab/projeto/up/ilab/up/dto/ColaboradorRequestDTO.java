package ilab.projeto.up.ilab.up.dto;

import ilab.projeto.up.ilab.up.model.Colaborador;

public class ColaboradorRequestDTO {

	private boolean statusColaborador;
	private String nomeColaborador;
	private String matricula;
	private double salarioBase;
	private double custo;

	public ColaboradorRequestDTO() {
		super();
	}

	public ColaboradorRequestDTO(boolean statusColaborador, String nomeColaborador, String matricula,
			double salarioBase, double custo) {
		super();
		this.statusColaborador = statusColaborador;
		this.nomeColaborador = nomeColaborador;
		this.matricula = matricula;
		this.salarioBase = salarioBase;
		this.custo = custo;
	}

	public ColaboradorRequestDTO(Colaborador colaborador) {
		super();
		this.statusColaborador = colaborador.isStatusColaborador();
		this.nomeColaborador = colaborador.getNomeColaborador();
		this.matricula = colaborador.getMatricula();
		this.salarioBase = colaborador.getSalarioBase();
		this.custo = colaborador.getCusto();
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
