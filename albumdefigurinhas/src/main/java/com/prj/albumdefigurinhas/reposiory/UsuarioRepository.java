package com.prj.albumdefigurinhas.reposiory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prj.albumdefigurinhas.model.Usuario;




@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {



	Optional<Usuario> findById(Long id);

	Optional<Usuario> findByNome(String nome);

}
