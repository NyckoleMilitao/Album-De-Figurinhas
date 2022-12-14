package ilab.projeto.up.ilab.up.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ilab.projeto.up.ilab.up.dto.ClienteRequestDTO;
import ilab.projeto.up.ilab.up.dto.ClienteResponseDTO;
import ilab.projeto.up.ilab.up.model.Cliente;

public interface ClienteService {

	public Page<ClienteResponseDTO> listar(Pageable pageable);

	public Cliente buscar(Long idCliente);
	
	public ClienteResponseDTO buscarDTO(Long idCliente);

	public ClienteResponseDTO inserirDTO(ClienteRequestDTO clienteResponseDTO);

	public ClienteResponseDTO atualizar(Long idCliente, ClienteRequestDTO clienteResponseDTO);

	public Cliente trocaStatus(Long idCliente, ClienteRequestDTO clienteResponseDTO);

	public ClienteResponseDTO deletar(Long idCliente);

}
