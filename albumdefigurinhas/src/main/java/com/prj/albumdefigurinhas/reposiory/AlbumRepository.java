package com.prj.albumdefigurinhas.reposiory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prj.albumdefigurinhas.model.Album;




@Repository
public interface AlbumRepository  extends JpaRepository<Album, Long>{

    Optional<Album> findById(Long id);

    Optional<Album> findByNumeroAlbum(int numeroAlbum);

    Optional<Album> findByPagina(int pagina);
}
