package com.prj.albumdefigurinhas.service;

/* 
import java.util.Optional;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import ilab.projeto.up.ilab.up.dto.UsuarioResponseDTO;
import ilab.projeto.up.ilab.up.model.Usuario;



@Aspect
@Component
public class PermissaoAspect {

      

    @Autowired
    private UsuarioService usuarioService;

   @Before("@annotation(TemPermissaoLerPublicacao)")
    public void verificarPermissaoLerPublicacao() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName(); // Obtenha o nome de usuário

        Optional<UsuarioResponseDTO> optionalUsuario = usuarioService.obterUsuarioPorNome(userName);

        if (!optionalUsuario.isPresent()) {
            throw new AccessDeniedException("Acesso negado: usuário não encontrado");
        }

        UsuarioResponseDTO usuarioDTO = optionalUsuario.get();
        if (!usuarioService.temPermissaoLerPublicacao(usuarioDTO.getId())) {
            throw new AccessDeniedException("Acesso negado: você não tem permissão para ler publicações");
        }
    }
    

    @Before("@annotation(TemPermissaoCriarPublicacao)")
    public void verificarPermissaoCriarPublicacao() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName(); // Obtenha o nome de usuário

        Optional<UsuarioResponseDTO> optionalUsuario = usuarioService.obterUsuarioPorNome(userName);

        if (!optionalUsuario.isPresent()) {
            throw new AccessDeniedException("Acesso negado: usuário não encontrado");
        }

        UsuarioResponseDTO usuarioDTO = optionalUsuario.get();
        if (!usuarioService.temPermissaoCriarPublicacao(usuarioDTO.getId())) {
            throw new AccessDeniedException("Acesso negado: você não tem permissão para ler publicações");
        }
    }

    @Before("@annotation(TemPermissaoGerenciarColecao)")
    public void verificarPermissaoGerenciarColecao() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName(); // Obtenha o nome de usuário

        Optional<UsuarioResponseDTO> optionalUsuario = usuarioService.obterUsuarioPorNome(userName);

        if (!optionalUsuario.isPresent()) {
            throw new AccessDeniedException("Acesso negado: usuário não encontrado");
        }

        UsuarioResponseDTO usuarioDTO = optionalUsuario.get();
        if (!usuarioService.temPermissaoGerenciarColecao(usuarioDTO.getId())) {
            throw new AccessDeniedException("Acesso negado: você não tem permissão para ler publicações");
        }
    }
}*/