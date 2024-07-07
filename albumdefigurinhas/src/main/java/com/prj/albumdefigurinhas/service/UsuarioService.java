package com.prj.albumdefigurinhas.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.prj.albumdefigurinhas.dto.UsuarioRequestDTO;
import com.prj.albumdefigurinhas.dto.UsuarioResponseDTO;
import com.prj.albumdefigurinhas.model.Usuario;




public interface UsuarioService {

	Optional<UsuarioResponseDTO> obterUsuarioPorNome(String nome);

	Page<UsuarioResponseDTO> obterTodosUsuarios(Pageable pageable);

	UsuarioResponseDTO buscarUsuarioPorId(Long id);

	UsuarioResponseDTO adicionarUsuario(UsuarioRequestDTO usuarioRequestDTO);

	UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO);

	UsuarioResponseDTO deletarUsuario(Long id);

	UsuarioResponseDTO zerarSenha(Long id, UsuarioRequestDTO usuarioRequestDTO);

	UsuarioResponseDTO toDto(Usuario usuario);

	/*Perfil verificarPerfilUsuario(Long id);

	boolean temPermissaoLerPublicacao(Long id);

	boolean temPermissaoCriarPublicacao(Long id);

	boolean temPermissaoGerenciarColecao(Long id);*/
}