package ilab.projeto.up.ilab.up.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import ilab.projeto.up.ilab.up.model.Album;
import ilab.projeto.up.ilab.up.model.Figurinha;

public class FigurinhaRequestDTO {

      @NotBlank
    private String nomeFigurinha;

   

    @NotBlank
    private String descricao;



    @NotBlank
    private String tag;

    @NotBlank
    private byte[] foto;

    private Album album;

    public FigurinhaRequestDTO() {
    }

    public FigurinhaRequestDTO(String nomeFigurinha, String descricao, String tag, byte[] foto, Album album) {
        this.nomeFigurinha = nomeFigurinha;
        
        this.descricao = descricao;
        
        this.tag = tag;
        this.foto = foto;
        this.album = album;
    }

     public FigurinhaRequestDTO(Figurinha figurinha) {

        this.nomeFigurinha = figurinha.getNomeFigurinha();
        
        this.descricao = figurinha.getDescricao();
        
        this.tag = figurinha.getTag();
        this.foto = figurinha.getFoto();
        this.album = figurinha.getAlbum();
    }
    // Getters e Setters

    public String getNomeFigurinha() {
        return nomeFigurinha;
    }

    public void setNomeFigurinha(String nomeFigurinha) {
        this.nomeFigurinha = nomeFigurinha;
    }

   

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    
}
