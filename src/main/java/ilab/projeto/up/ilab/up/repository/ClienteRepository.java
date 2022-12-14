package ilab.projeto.up.ilab.up.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ilab.projeto.up.ilab.up.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public Cliente findByIdCliente(Long idCliente);

	public Cliente findByNomeCliente(String nomeCliente);

	public Cliente findByStatusCliente(boolean statusCliente);

}
