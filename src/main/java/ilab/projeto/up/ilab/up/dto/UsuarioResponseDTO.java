package ilab.projeto.up.ilab.up.dto;

import ilab.projeto.up.ilab.up.model.Perfil;
import ilab.projeto.up.ilab.up.model.Usuario;


public class UsuarioResponseDTO {

	private Long id;
	private String nome;
	private String senha;
	private Perfil perfil;

	public UsuarioResponseDTO() {

	}

	public UsuarioResponseDTO(Long id, String nome, String senha, Perfil perfil) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha= senha;
		this.perfil = perfil;
	}

	public UsuarioResponseDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.senha= usuario.getSenha();
		this.perfil = usuario.getPerfil();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
