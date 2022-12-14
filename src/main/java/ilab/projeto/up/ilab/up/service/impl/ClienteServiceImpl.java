package ilab.projeto.up.ilab.up.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ilab.projeto.up.ilab.up.dto.ClienteRequestDTO;
import ilab.projeto.up.ilab.up.dto.ClienteResponseDTO;
import ilab.projeto.up.ilab.up.model.Cliente;
import ilab.projeto.up.ilab.up.repository.ClienteRepository;
import ilab.projeto.up.ilab.up.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	public ClienteRepository clienteRepository;

	/**
	 * Aqui está fazendo um get buscando todos os Clientes
	 */
	public Page<ClienteResponseDTO> listar(Pageable pageable) {
		Page<Cliente> cliente = clienteRepository.findAll(pageable);
		Page<ClienteResponseDTO> clienteDTO = cliente.map(ClienteResponseDTO::new);

		return clienteDTO;
	}

	/**
	 * 
	 * @param idCliente
	 * @return retorna o cliente por idCliente
	 */
	@Override
	public Cliente buscar(Long idCliente) {
		return clienteRepository.findByIdCliente(idCliente);

	}

	public ClienteResponseDTO buscarDTO(Long idCliente) {
		return new ClienteResponseDTO(clienteRepository.findByIdCliente(idCliente));
	}
	
	/**
	 * Este metodo está trocando um status do cliente
	 */
	@Override
	public Cliente trocaStatus(Long idCliente, ClienteRequestDTO clienteResponseDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Aqui está fazendo put
	 */
	@Override
	public ClienteResponseDTO inserirDTO(ClienteRequestDTO clienteRequestDTO) {
		Cliente cliente = new Cliente();
		cliente.setNomeCliente(clienteRequestDTO.getNomeCliente());
		cliente.setCnpj(clienteRequestDTO.getCnpj());
		cliente.setStatusCliente(clienteRequestDTO.isStatusCliente());
		clienteRepository.save(cliente);
		return new ClienteResponseDTO(cliente);
	}

	/**
	 * Este é o metodo put para atualizar o cliente
	 */
	public ClienteResponseDTO atualizar(Long id, ClienteRequestDTO clienteRequestDTO) {

		if (clienteRepository.existsById(id)) {

			Cliente cliente = new Cliente();
			cliente.setIdCliente(id);
			cliente.setNomeCliente(clienteRequestDTO.getNomeCliente());
			cliente.setCnpj(clienteRequestDTO.getCnpj());
			cliente.setStatusCliente(clienteRequestDTO.isStatusCliente());
			clienteRepository.save(cliente);

			return new ClienteResponseDTO(cliente);

		}

		return null;
	}

	/**
	 * 
	 * @param idCliente
	 * @return Aqui está fazendo um Delete
	 */

	@Override
	public ClienteResponseDTO deletar(Long idCliente) {
		if (clienteRepository.existsById(idCliente)) {
			clienteRepository.deleteById(idCliente);
		}

		return null;
	}

}
