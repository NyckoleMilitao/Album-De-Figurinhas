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
import ilab.projeto.up.ilab.up.dto.ContratoRequestDTO;
import ilab.projeto.up.ilab.up.dto.ContratoResponseDTO;
import ilab.projeto.up.ilab.up.service.impl.ContratoServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

	@Autowired
	private ContratoServiceImpl contratoServiceImpl;

	@ApiOperation(value = "listar todos os contratos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "contratos listados com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@GetMapping
	public ResponseEntity<Page<ContratoResponseDTO>> listar(@PageableDefault Pageable pageable) {
		Page<ContratoResponseDTO> contratos = contratoServiceImpl.listar(pageable);
		System.out.println(contratos.toString());
		return ResponseEntity.ok(contratos);
	}

	@ApiOperation(value = "buscar um Contrato")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Contrato encontrado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@GetMapping("/{id}")
	public ResponseEntity<ContratoResponseDTO> buscar(@PathVariable("id") Long idContrato) {
		if (contratoServiceImpl.buscar(idContrato) != null) {
			return ResponseEntity.ok(new ContratoResponseDTO(contratoServiceImpl.buscar(idContrato)));
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "inserir um Contrato")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ColaboradorContrato inserido com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PostMapping
	public ResponseEntity<ContratoResponseDTO> inserir(@Valid @RequestBody ContratoRequestDTO contratoRequestDTO) {
		ContratoResponseDTO contrato = new ContratoResponseDTO();
		contrato = contratoServiceImpl.inserir(contratoRequestDTO);
		return ResponseEntity.ok(contrato);
	}

	@ApiOperation(value = "atualizar um Contrato")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "ColaboradorContrato atualizado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PutMapping("/{id}")
	public ResponseEntity<ContratoResponseDTO> atualizar(@PathVariable("id") Long idContrato,
			@Valid @RequestBody ContratoRequestDTO contratoRequestDTO) {
		if (contratoServiceImpl.atualizar(idContrato, contratoRequestDTO) != null) {
			return ResponseEntity.ok(contratoServiceImpl.atualizar(idContrato, contratoRequestDTO));
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Deletar um Contrato")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "contrato deletado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (contratoServiceImpl.deletar(id) != null) {
			contratoServiceImpl.deletar(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
