package ilab.projeto.up.ilab.up.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ilab.projeto.up.ilab.up.model.Album;
import ilab.projeto.up.ilab.up.model.Figurinha;

@Repository
public interface FigurinhaRepository extends JpaRepository<Figurinha, Long> {

    Optional<Figurinha> findById(Long id);



}
