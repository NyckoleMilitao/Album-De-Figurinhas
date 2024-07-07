package com.prj.albumdefigurinhas.dto;

import com.prj.albumdefigurinhas.model.Album;
import com.prj.albumdefigurinhas.model.Figurinha;

public class FigurinhaResponseDTO {

    private Long id;

    private String nomeFigurinha;

    private Integer numeroAlbum;

    private String descricao;

    private Integer pagina;

    private String tag;

    private byte[] foto;

    private Album album;

    public FigurinhaResponseDTO() {
    }

    public FigurinhaResponseDTO(Long id, String nomeFigurinha, Integer numeroAlbum, String descricao, Integer pagina, String tag, Album album) {
        this.id = id;
        this.nomeFigurinha = nomeFigurinha;
        this.numeroAlbum = numeroAlbum;
        this.descricao = descricao;
        this.pagina = pagina;
        this.tag = tag;
        this.album = album;
    }

    public FigurinhaResponseDTO(Figurinha figurinha) {
        this.id = figurinha.getId();
        this.nomeFigurinha = figurinha.getNomeFigurinha();
       
        this.descricao = figurinha.getDescricao();
        
        this.tag = figurinha.getTag();
        this.foto = figurinha.getFoto();
        this.album = figurinha.getAlbum();
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFigurinha() {
        return nomeFigurinha;
    }

    public void setNomeFigurinha(String nomeFigurinha) {
        this.nomeFigurinha = nomeFigurinha;
    }

    public Integer getNumeroAlbum() {
        return numeroAlbum;
    }

    public void setNumeroAlbum(Integer numeroAlbum) {
        this.numeroAlbum = numeroAlbum;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    
}
