package ilab.projeto.up.ilab.up.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ilab.projeto.up.ilab.up.model.Papel;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Long> {

	public Optional<Papel> findByIdPapel(Long id);

	public Papel findByNomePapel(String nomePapel);

	public Papel findByTaxaHora(double taxaHora);

	public Papel findBytaxaHoraExtra(double taxaHoraExtra);

}