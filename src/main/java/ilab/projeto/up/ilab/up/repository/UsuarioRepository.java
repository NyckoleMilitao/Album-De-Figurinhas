package ilab.projeto.up.ilab.up.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import ilab.projeto.up.ilab.up.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {



	Optional<Usuario> findById(Long id);

	Optional<Usuario> findByNome(String nome);

}
