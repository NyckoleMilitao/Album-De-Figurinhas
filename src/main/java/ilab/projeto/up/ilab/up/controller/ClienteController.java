package ilab.projeto.up.ilab.up.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ilab.projeto.up.ilab.up.dto.ClienteRequestDTO;
import ilab.projeto.up.ilab.up.dto.ClienteResponseDTO;
import ilab.projeto.up.ilab.up.model.Cliente;
import ilab.projeto.up.ilab.up.service.impl.ClienteServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteServiceImpl clienteServiceImpl;

	@ApiOperation(value = "listar todos os clientes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "clientes listados com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@GetMapping
	public ResponseEntity<Page<ClienteResponseDTO>> listar(@PageableDefault Pageable pageable) {
		Page<ClienteResponseDTO> clientes = clienteServiceImpl.listar(pageable);
		return ResponseEntity.ok(clientes);
	}

	@ApiOperation(value = "buscar um cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "cliente encontrado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@GetMapping("/{id}")
	public ResponseEntity<ClienteResponseDTO> buscar(@PathVariable("id") Long idCliente) {
		if (clienteServiceImpl.buscarDTO(idCliente) != null) {
			return ResponseEntity.ok(clienteServiceImpl.buscarDTO(idCliente));
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "inserir um cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "cliente inserido com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PostMapping
	public ResponseEntity<ClienteResponseDTO> inserir(@RequestBody ClienteRequestDTO clienteRequestDTO) {
		ClienteResponseDTO cliente = new ClienteResponseDTO();
		cliente = clienteServiceImpl.inserirDTO(clienteRequestDTO);
		return ResponseEntity.ok(cliente);
	}

	@ApiOperation(value = "atualizar um cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "cliente atualizado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PutMapping("/{id}")
	public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long id,
			@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
		if (clienteServiceImpl.atualizar(id, clienteRequestDTO) != null) {
			return ResponseEntity.ok(clienteServiceImpl.atualizar(id, clienteRequestDTO));
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Atualizar status de um cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "status do cliente atualizado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PutMapping("/{id}/trocarstatus")
	public ResponseEntity<Cliente> trocaStatus(@PathVariable("id") Long id,
			@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
		if (clienteServiceImpl.trocaStatus(id, clienteRequestDTO) != null) {
			return ResponseEntity.ok(clienteServiceImpl.trocaStatus(id, clienteRequestDTO));
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Deletar um cliente")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "cliente deletado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long idCliente) {

		if (clienteServiceImpl.deletar(idCliente) != null) {
			clienteServiceImpl.deletar(idCliente);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();

	}
}
