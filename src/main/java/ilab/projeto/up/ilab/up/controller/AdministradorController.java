package ilab.projeto.up.ilab.up.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ilab.projeto.up.ilab.up.dto.UsuarioRequestDTO;
import ilab.projeto.up.ilab.up.dto.UsuarioResponseDTO;
import ilab.projeto.up.ilab.up.mapper.UsuarioMapper;
import ilab.projeto.up.ilab.up.model.Perfil;
import ilab.projeto.up.ilab.up.model.Usuario;
import ilab.projeto.up.ilab.up.service.TemPermissaoGerenciarColecao;
import ilab.projeto.up.ilab.up.service.impl.UsuarioServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/usuarios")
public class AdministradorController {

	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;


	@ApiOperation(value = "listar todos os clientes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "clientes listados com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
    @TemPermissaoGerenciarColecao
	@GetMapping("/perfil-usuario")
    public ResponseEntity<Map<String, Boolean>> getPerfil(@RequestParam Long id) {
    UsuarioResponseDTO usuarioDTO = usuarioServiceImpl.buscarUsuarioPorId(id);
    if (usuarioDTO == null) {
        return ResponseEntity.notFound().build();
    }

    Map<String, Boolean> perfil = new HashMap<>();
    perfil.put("isAdmin", usuarioDTO.getPerfil() == Perfil.ADMINISTRADOR);
    perfil.put("isAutor", usuarioDTO.getPerfil() == Perfil.AUTOR);
    perfil.put("isColecionador", usuarioDTO.getPerfil() == Perfil.COLECIONADOR);

    return ResponseEntity.ok(perfil);
}


@ApiOperation(value = "buscar um cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "cliente encontrado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
            @ApiResponse(code = 505, message = "Ocorreu uma exceção") })

@TemPermissaoGerenciarColecao
@GetMapping("/usuarios")
public ResponseEntity<Page<UsuarioResponseDTO>> obterTodos(@PageableDefault Pageable pageable) {
    Page<UsuarioResponseDTO> usuarioPage = usuarioServiceImpl.obterTodosUsuarios(pageable);
    return ResponseEntity.ok(usuarioPage);
}

@ApiOperation(value = "buscar um cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "cliente encontrado com sucesso!"),
			@ApiResponse(code = 401, message = "Erro de autenticação"), @ApiResponse(code = 403, message = "Proibido"),
			@ApiResponse(code = 404, message = "Recurso não disponível"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"),
			@ApiResponse(code = 505, message = "Ocorreu uma exceção") })
@TemPermissaoGerenciarColecao
@GetMapping("/{id}")
public ResponseEntity<UsuarioResponseDTO> buscar(@PathVariable("id") Long id) {
    UsuarioResponseDTO usuarioDTO = usuarioServiceImpl.buscarUsuarioPorId(id);
    
    if (usuarioDTO != null) {
        return ResponseEntity.ok(usuarioDTO);
    }
    return ResponseEntity.notFound().build();
}

@TemPermissaoGerenciarColecao
@PostMapping
public ResponseEntity<UsuarioResponseDTO> adicionar(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
    UsuarioResponseDTO usuarioDTO = usuarioServiceImpl.adicionarUsuario(usuarioRequestDTO);
    return ResponseEntity.ok(usuarioDTO);
}

@TemPermissaoGerenciarColecao
@PutMapping("/{id}")
public ResponseEntity<UsuarioResponseDTO> atualizar(@PathVariable("id") Long id, @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
    UsuarioResponseDTO usuarioDTO = usuarioServiceImpl.atualizarUsuario(id, usuarioRequestDTO);
    
    if (usuarioDTO != null) {
        return ResponseEntity.ok(usuarioDTO);
    }
    return ResponseEntity.notFound().build();
}

@TemPermissaoGerenciarColecao
@PutMapping("/{id}/zerar-senha")
public ResponseEntity<UsuarioResponseDTO> zerarSenha(@PathVariable("id") Long id, @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
    UsuarioResponseDTO usuarioDTO = usuarioServiceImpl.zerarSenha(id, usuarioRequestDTO);
    
    if (usuarioDTO != null) {
        return ResponseEntity.ok(usuarioDTO);
    }
    return ResponseEntity.notFound().build();
}

@TemPermissaoGerenciarColecao
@DeleteMapping("/{id}/deletar")
    public ResponseEntity<UsuarioResponseDTO> deletarUsuario(@PathVariable("id") Long id) {
        UsuarioResponseDTO usuarioDTO = usuarioServiceImpl.deletarUsuario(id);

        if (usuarioDTO != null) {
            return ResponseEntity.ok(usuarioDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
