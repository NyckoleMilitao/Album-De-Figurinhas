package ilab.projeto.up.ilab.up.model;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Table(name = "Usuario")
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String nome;

	private String senha;

	
	private Perfil perfil;
  
    public Usuario() {
    }

    public Usuario(Long id, String nome, String senha, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.perfil = perfil;
    }
      

    
    public Usuario(String nome, String senha, Perfil perfil) {
        this.nome = nome;
        this.senha = senha;
        this.perfil = perfil;
       
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
