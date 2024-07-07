package ilab.projeto.up.ilab.up.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ilab.projeto.up.ilab.up.dto.UsuarioResponseDTO;
import ilab.projeto.up.ilab.up.model.Perfil;
import ilab.projeto.up.ilab.up.model.Usuario;
import ilab.projeto.up.ilab.up.service.UsuarioService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/login")
public class LoginController {

     @Autowired
    private UsuarioService usuarioService;



    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        Optional<UsuarioResponseDTO> usuarioOptional = usuarioService.obterUsuarioPorNome(usuario.getNome());
        
        if (usuarioOptional.isPresent()) {
           UsuarioResponseDTO usuarioEncontrado = usuarioOptional.get();
            if (usuarioEncontrado.getSenha().equals(usuario.getSenha())) {
                Perfil perfilUsuario = usuarioEncontrado.getPerfil();
                switch (perfilUsuario) {
                    case ADMINISTRADOR:
                    case AUTOR:
                    case COLECIONADOR:
                        return ResponseEntity.ok("Login realizado com sucesso para: " + usuarioEncontrado.getNome());
                    default:
                        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Perfil não autorizado");
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
    }
}

