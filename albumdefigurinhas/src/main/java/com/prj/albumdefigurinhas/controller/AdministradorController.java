package com.prj.albumdefigurinhas.controller;

import java.util.HashMap;
import java.util.Map;

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

import com.prj.albumdefigurinhas.dto.UsuarioRequestDTO;
import com.prj.albumdefigurinhas.dto.UsuarioResponseDTO;
import com.prj.albumdefigurinhas.model.Perfil;
import com.prj.albumdefigurinhas.service.impl.UsuarioServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/usuarios")
public class AdministradorController {

	@Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @ApiOperation(value = "Listar todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuários listados com sucesso!"),
            @ApiResponse(code = 401, message = "Erro de autenticação"),
            @ApiResponse(code = 403, message = "Proibido"),
            @ApiResponse(code = 404, message = "Recurso não disponível"),
            @ApiResponse(code = 500, message = "Erro interno no servidor"),
            @ApiResponse(code = 505, message = "Ocorreu uma exceção")
    })
    //@TemPermissaoGerenciarColecao
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

    @ApiOperation(value = "Buscar todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuários encontrados com sucesso!"),
            @ApiResponse(code = 401, message = "Erro de autenticação"),
            @ApiResponse(code = 403, message = "Proibido"),
            @ApiResponse(code = 404, message = "Recurso não disponível"),
            @ApiResponse(code = 500, message = "Erro interno no servidor"),
            @ApiResponse(code = 505, message = "Ocorreu uma exceção")
    })
   // @TemPermissaoGerenciarColecao
    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> obterTodos(@PageableDefault Pageable pageable) {
        Page<UsuarioResponseDTO> usuarioPage = usuarioServiceImpl.obterTodosUsuarios(pageable);
        return ResponseEntity.ok(usuarioPage);
    }

    @ApiOperation(value = "Buscar um usuário pelo ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário encontrado com sucesso!"),
            @ApiResponse(code = 401, message = "Erro de autenticação"),
            @ApiResponse(code = 403, message = "Proibido"),
            @ApiResponse(code = 404, message = "Recurso não disponível"),
            @ApiResponse(code = 500, message = "Erro interno no servidor"),
            @ApiResponse(code = 505, message = "Ocorreu uma exceção")
    })
    //@TemPermissaoGerenciarColecao
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscar(@PathVariable("id") Long id) {
        UsuarioResponseDTO usuarioDTO = usuarioServiceImpl.buscarUsuarioPorId(id);

        if (usuarioDTO != null) {
            return ResponseEntity.ok(usuarioDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Adicionar um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário adicionado com sucesso!"),
            @ApiResponse(code = 401, message = "Erro de autenticação"),
            @ApiResponse(code = 403, message = "Proibido"),
            @ApiResponse(code = 404, message = "Recurso não disponível"),
            @ApiResponse(code = 500, message = "Erro interno no servidor"),
            @ApiResponse(code = 505, message = "Ocorreu uma exceção")
    })
    //@TemPermissaoGerenciarColecao
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> adicionar(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioResponseDTO usuarioDTO = usuarioServiceImpl.adicionarUsuario(usuarioRequestDTO);
        return ResponseEntity.ok(usuarioDTO);
    }

    @ApiOperation(value = "Atualizar um usuário existente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário atualizado com sucesso!"),
            @ApiResponse(code = 401, message = "Erro de autenticação"),
            @ApiResponse(code = 403, message = "Proibido"),
            @ApiResponse(code = 404, message = "Recurso não disponível"),
            @ApiResponse(code = 500, message = "Erro interno no servidor"),
            @ApiResponse(code = 505, message = "Ocorreu uma exceção")
    })
   // @TemPermissaoGerenciarColecao
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizar(@PathVariable("id") Long id, @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioResponseDTO usuarioDTO = usuarioServiceImpl.atualizarUsuario(id, usuarioRequestDTO);

        if (usuarioDTO != null) {
            return ResponseEntity.ok(usuarioDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Zerar a senha de um usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Senha zerada com sucesso!"),
            @ApiResponse(code = 401, message = "Erro de autenticação"),
            @ApiResponse(code = 403, message = "Proibido"),
            @ApiResponse(code = 404, message = "Recurso não disponível"),
            @ApiResponse(code = 500, message = "Erro interno no servidor"),
            @ApiResponse(code = 505, message = "Ocorreu uma exceção")
    })
    //@TemPermissaoGerenciarColecao
    @PutMapping("/{id}/zerar-senha")
    public ResponseEntity<UsuarioResponseDTO> zerarSenha(@PathVariable("id") Long id, @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioResponseDTO usuarioDTO = usuarioServiceImpl.zerarSenha(id, usuarioRequestDTO);

        if (usuarioDTO != null) {
            return ResponseEntity.ok(usuarioDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Deletar um usuário")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário deletado com sucesso!"),
            @ApiResponse(code = 401, message = "Erro de autenticação"),
            @ApiResponse(code = 403, message = "Proibido"),
            @ApiResponse(code = 404, message = "Recurso não disponível"),
            @ApiResponse(code = 500, message = "Erro interno no servidor"),
            @ApiResponse(code = 505, message = "Ocorreu uma exceção")
    })
   // @TemPermissaoGerenciarColecao
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