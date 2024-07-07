package com.prj.albumdefigurinhas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prj.albumdefigurinhas.dto.UsuarioResponseDTO;
import com.prj.albumdefigurinhas.model.Perfil;
import com.prj.albumdefigurinhas.model.Usuario;
import com.prj.albumdefigurinhas.service.UsuarioService;

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
/* 
@PostMapping("/login")
public ResponseEntity<String> login(@RequestBody Usuario usuario) {
    Optional<UsuarioResponseDTO> usuarioOptional = usuarioService.obterUsuarioPorNome(usuario.getNome());

    if (usuarioOptional.isPresent()) {
        UsuarioResponseDTO usuarioEncontrado = usuarioOptional.get();
        String hashedPassword = hashPassword(usuario.getSenha());
        if (usuarioEncontrado.getSenha().equals(hashedPassword)) {
            Perfil perfilUsuario = usuarioEncontrado.getPerfil();
            String token = generateToken(usuarioEncontrado.getNome(), perfilUsuario);
            switch (perfilUsuario) {
                case ADMINISTRADOR:
                case AUTOR:
                case COLECIONADOR:
                    return ResponseEntity.ok("Login realizado com sucesso para: " + usuarioEncontrado.getNome() + ". Token: " + token);
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

private String hashPassword(String password) {
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
}

private String generateToken(String nome, Perfil perfil) {
    // Implemente a lógica de geração de token aqui (JWT, UUID, etc.)
    // Esta é uma implementação simples usando UUID:
    return java.util.UUID.randomUUID().toString();
}*/