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

import ilab.projeto.up.ilab.up.dto.ColaboradorRequestDTO;
import ilab.projeto.up.ilab.up.dto.ColaboradorResponseDTO;
import ilab.projeto.up.ilab.up.model.Colaborador;
import ilab.projeto.up.ilab.up.service.impl.ColaboradorServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

	@Autowired
	private ColaboradorServiceImpl colaboradorServiceImpl;

	@ApiOperation(value = "listar todos os colaboradores")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "colaboradore listados com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@GetMapping
	public ResponseEntity<Page<ColaboradorResponseDTO>> listar(@PageableDefault Pageable pageable) {
		Page<ColaboradorResponseDTO> colaboradores = colaboradorServiceImpl.listar(pageable);
		return ResponseEntity.ok(colaboradores);
	}

	@ApiOperation(value = "buscar um colaborador")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "colaborador encontrado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@GetMapping("/{id}")
	public ResponseEntity<Colaborador> buscar(@PathVariable("id") Long idCliente) {
		if (colaboradorServiceImpl.buscar(idCliente) != null) {
			return ResponseEntity.ok(colaboradorServiceImpl.buscar(idCliente));
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "inserir um colaborador")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "colaborador inserido com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PostMapping
	public ResponseEntity<ColaboradorResponseDTO> inserir(@RequestBody ColaboradorRequestDTO colaboradorRequestDTO) {
		ColaboradorResponseDTO colaborador = new ColaboradorResponseDTO();
		colaborador = colaboradorServiceImpl.inserirDTO(colaboradorRequestDTO);
		return ResponseEntity.ok(colaborador);
	}

	@ApiOperation(value = "atualizar um colaborador")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "colaborador atualizado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PutMapping("/{id}")
	public ResponseEntity<ColaboradorResponseDTO> atualizar(@PathVariable Long id,
			@Valid @RequestBody ColaboradorRequestDTO colaboradorRequestDTO) {
		if (colaboradorServiceImpl.atualizar(id, colaboradorRequestDTO) != null) {
			return ResponseEntity.ok(colaboradorServiceImpl.atualizar(id, colaboradorRequestDTO));
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "atualizar status de um colaborador")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "status do colaborador atualizado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PutMapping("/{id}/trocastatus")
	public ResponseEntity<ColaboradorResponseDTO> trocaStatus(@PathVariable("id") Long id,
			@RequestBody boolean statusColaborador) {
		if (colaboradorServiceImpl.buscar(id) != null) {
			return ResponseEntity.ok(colaboradorServiceImpl.trocaStatus(id, statusColaborador));
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Deletar um colaborador")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "colaborador deletado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Long idColaborador) {
		if (colaboradorServiceImpl.deletar(idColaborador) != null) {
			colaboradorServiceImpl.deletar(idColaborador);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
