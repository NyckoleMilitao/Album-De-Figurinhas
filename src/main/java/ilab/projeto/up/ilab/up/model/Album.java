package ilab.projeto.up.ilab.up.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private int numeroAlbum;
    
    @NotBlank
    private int pagina;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Figurinha> figurinhas = new ArrayList<>();

    // Construtores, Getters e Setters

    public Album() {
    }

    

    public Album(Long id, @NotBlank int numeroAlbum, int pagina, List<Figurinha> figurinhas) {
        this.id = id;
        this.numeroAlbum = numeroAlbum;
        this.pagina = pagina;
        this.figurinhas = figurinhas;
    }



    public Album(int numeroAlbum) {
        this.numeroAlbum = numeroAlbum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Figurinha> getFigurinhas() {
        return figurinhas;
    }

    public void setFigurinhas(List<Figurinha> figurinhas) {
        this.figurinhas = figurinhas;
    }
}
