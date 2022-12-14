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

import ilab.projeto.up.ilab.up.dto.ColaboradorContratoRequestDTO;
import ilab.projeto.up.ilab.up.dto.ColaboradorContratoResponseDTO;
import ilab.projeto.up.ilab.up.service.impl.ColaboradorContratoServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/colaboradorescontratos")
public class ColaboradorContratoController {

	@Autowired
	private ColaboradorContratoServiceImpl colaboradorContratoServiceImpl;

	@ApiOperation(value = "listar todos os ColaboradorContrato")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ColaboradorContrato listados com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@GetMapping
	public ResponseEntity<Page<ColaboradorContratoResponseDTO>> listar(@PageableDefault Pageable pageable) {
		Page<ColaboradorContratoResponseDTO> colaboradorContrato = colaboradorContratoServiceImpl.listar(pageable);
		return ResponseEntity.ok(colaboradorContrato);
	}

	@ApiOperation(value = "buscar um ColaboradorContrato")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "colaborador encontrado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@GetMapping("/{id}")
	public ResponseEntity<ColaboradorContratoResponseDTO> buscar(@PathVariable Long id) {
		if (colaboradorContratoServiceImpl.buscar(id) != null) {
			return ResponseEntity.ok(colaboradorContratoServiceImpl.buscar(id));
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "inserir um ColaboradorContrato")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ColaboradorContrato inserido com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PostMapping
	public ResponseEntity<ColaboradorContratoResponseDTO> inserir(
			@RequestBody ColaboradorContratoRequestDTO colaboradorContratoRequestDTO) {
		ColaboradorContratoResponseDTO colaboradorContrato = new ColaboradorContratoResponseDTO();
		colaboradorContrato = colaboradorContratoServiceImpl.inserir(colaboradorContratoRequestDTO);
		return ResponseEntity.ok(colaboradorContrato);
	}

	@ApiOperation(value = "atualizar uma colaborador contrato")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Colaborador Contrato atualizado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PutMapping("/{id}")
	public ResponseEntity<ColaboradorContratoResponseDTO> atualizar(@PathVariable("id") Long id,
			@Valid @RequestBody ColaboradorContratoRequestDTO colaboradorContratoRequestDTO) {
		if (colaboradorContratoServiceImpl.atualizar(id, colaboradorContratoRequestDTO) != null) {
			return ResponseEntity
					.ok(colaboradorContratoServiceImpl.atualizar(id, colaboradorContratoRequestDTO));
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
	public ResponseEntity<Void> deletar(@PathVariable("id") Long idColaboradorContrato) {
		if (colaboradorContratoServiceImpl.deletar(idColaboradorContrato) != null) {
			colaboradorContratoServiceImpl.deletar(idColaboradorContrato);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}