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
import ilab.projeto.up.ilab.up.dto.PapelRequestDTO;
import ilab.projeto.up.ilab.up.dto.PapelResponseDTO;
import ilab.projeto.up.ilab.up.model.Papel;
import ilab.projeto.up.ilab.up.service.impl.PapelServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/papel")
public class PapelController {

	@Autowired
	private PapelServiceImpl papelServiceImpl;
	
	@ApiOperation(value = "listar todos os Papéis")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Papel listados com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), 
			@ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
    @GetMapping
	public ResponseEntity<Page<PapelResponseDTO>> listar(@PageableDefault Pageable pageable) {
		Page<PapelResponseDTO> papeis = papelServiceImpl.listar(pageable);
		return ResponseEntity.ok(papeis);
	}

		
	@ApiOperation(value = "buscar um PAPEL")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Papel encontrado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@GetMapping("/{id}")
	public ResponseEntity<Papel> buscar(@PathVariable("id") Long idPapel) {
		if (papelServiceImpl.buscar(idPapel) != null) {
			return ResponseEntity.ok(papelServiceImpl.buscar(idPapel));
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@ApiOperation(value = "inserir um Papel")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Papel inserido com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PostMapping
	public ResponseEntity<PapelResponseDTO> inserir(@RequestBody PapelRequestDTO papelRequestDTO) {
		PapelResponseDTO papel = new PapelResponseDTO();
		papel = papelServiceImpl.inserirDTO(papelRequestDTO);
		return ResponseEntity.ok(papel);
	}
		
			
	@ApiOperation(value = "atualizar uma papel")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Papel atualizado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
	@PutMapping("/{id}")
	public ResponseEntity<PapelResponseDTO> atualizar(@PathVariable("id") Long id, 
			@Valid @RequestBody PapelRequestDTO papelRequestDTO) {
		if (papelServiceImpl.atualizar(id, papelRequestDTO) != null) {
			return ResponseEntity.ok(papelServiceImpl.atualizar(id, papelRequestDTO));
		}
		return ResponseEntity.notFound().build();
	}
	
			
	@ApiOperation(value = "Deletar um papel")
	@ApiResponses(value = {
			@ApiResponse(code = 204, message = "Papel deletado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), 
			@ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (papelServiceImpl.deletar(id) != null) {
			papelServiceImpl.deletar(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
		
	}
	
}


