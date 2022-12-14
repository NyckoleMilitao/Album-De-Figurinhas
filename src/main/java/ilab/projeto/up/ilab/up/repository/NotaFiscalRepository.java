package ilab.projeto.up.ilab.up.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ilab.projeto.up.ilab.up.model.Contrato;
import ilab.projeto.up.ilab.up.model.NotaFiscal;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {

	public Optional<NotaFiscal> findByIdNotaFiscal(Long idNotaFiscal);

	public List<NotaFiscal> findAll();

	public NotaFiscal findByContrato(Contrato contrato);

	public NotaFiscal findByNumControleNota(int numControleNota);

	public NotaFiscal findByDataEmissaoNota(Date dataEmissaoNota);

	public NotaFiscal findByValorTotalNota(float valorTotalNota);

	public NotaFiscal findByStatusNota(boolean statusNota);

}
