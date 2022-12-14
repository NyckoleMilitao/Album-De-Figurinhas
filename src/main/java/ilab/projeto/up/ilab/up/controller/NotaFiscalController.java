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
import ilab.projeto.up.ilab.up.dto.NotaFiscalRequestDTO;
import ilab.projeto.up.ilab.up.dto.NotaFiscalResponseDTO;
import ilab.projeto.up.ilab.up.model.NotaFiscal;
import ilab.projeto.up.ilab.up.service.impl.NotaFiscalServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/notasfiscais")
public class NotaFiscalController {

	@Autowired
	private NotaFiscalServiceImpl notaFiscalServiceImpl;

	@ApiOperation(value = "listar todas as notas fiscais")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Notas fiscais listadas com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@GetMapping
	public ResponseEntity<Page<NotaFiscalResponseDTO>> listar(@PageableDefault Pageable pageable) {
		Page<NotaFiscal> notasFiscais = notaFiscalServiceImpl.listar(pageable);
		Page<NotaFiscalResponseDTO> notaFiscalDTO = notasFiscais.map(NotaFiscalResponseDTO::new);
		return ResponseEntity.ok(notaFiscalDTO);
	}

	@ApiOperation(value = "buscar uma nota fiscal por id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nota fiscal encontrada com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@GetMapping("/{id}")
	public ResponseEntity<NotaFiscalResponseDTO> buscar(@PathVariable("id") Long idNotaFiscal) {
		if (notaFiscalServiceImpl.buscar(idNotaFiscal) != null) {
			return ResponseEntity.ok(new NotaFiscalResponseDTO(notaFiscalServiceImpl.buscar(idNotaFiscal)));
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "inserir uma nota fiscal")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nota fiscal inserido com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PostMapping
	public ResponseEntity<NotaFiscalResponseDTO> inserir(@RequestBody NotaFiscalRequestDTO notaFiscalRequestDTO) {
		NotaFiscalResponseDTO notaFiscal = new NotaFiscalResponseDTO();
		notaFiscal = notaFiscalServiceImpl.inserir(notaFiscalRequestDTO);
		return ResponseEntity.ok(notaFiscal);
	}

	@ApiOperation(value = "atualizar uma nota fiscal")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Nota fiscal atualizada com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PutMapping("/{id}")
	public ResponseEntity<NotaFiscalResponseDTO> atualizar(@PathVariable("id") Long idNotaFiscal,
			@Valid @RequestBody NotaFiscalRequestDTO notaFiscalRequestDTO) {
		if (notaFiscalServiceImpl.atualizar(idNotaFiscal, notaFiscalRequestDTO) != null) {
			return ResponseEntity.ok(notaFiscalServiceImpl.atualizar(idNotaFiscal, notaFiscalRequestDTO));
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "atualizar status da nota fiscal")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "status da nota fiscal atualizado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PutMapping("/{id}/trocastatus")
	public ResponseEntity<NotaFiscalResponseDTO> trocarStatusNota(Long idNotaFiscal,
			NotaFiscalRequestDTO notaFiscalRequestDTO) {
		if (notaFiscalServiceImpl.trocaStatus(idNotaFiscal, notaFiscalRequestDTO) != null) {
			return ResponseEntity.ok(notaFiscalServiceImpl.trocaStatus(idNotaFiscal, notaFiscalRequestDTO));
		}
		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value = "Deletar uma nota fiscal")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "nota fiscal deletada com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), 
			@ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> apagar(@PathVariable("id") Long id) {
		if (notaFiscalServiceImpl.deletar(id) != null) {
			notaFiscalServiceImpl.deletar(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
