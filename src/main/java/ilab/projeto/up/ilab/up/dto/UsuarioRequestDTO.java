package ilab.projeto.up.ilab.up.dto;

import ilab.projeto.up.ilab.up.model.Perfil;
import ilab.projeto.up.ilab.up.model.Usuario;

public class UsuarioRequestDTO {

	private String nome;
	private String senha;
	private Perfil perfil;

	public UsuarioRequestDTO() {
		super();
	}

	public UsuarioRequestDTO(String nome, String senha, Perfil perfil) {
		super();
		this.nome = nome;
		this.senha= senha;
		this.perfil = perfil;
	}

	public UsuarioRequestDTO(Usuario usuario) {
		super();
		this.nome = usuario.getNome();
		this.senha = usuario.getSenha();
		this.perfil = usuario.getPerfil();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	

	

}
