package com.prj.albumdefigurinhas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
