package ilab.projeto.up.ilab.up.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ilab.projeto.up.ilab.up.dto.UsuarioRequestDTO;
import ilab.projeto.up.ilab.up.dto.UsuarioResponseDTO;
import ilab.projeto.up.ilab.up.model.Perfil;
import ilab.projeto.up.ilab.up.model.Usuario;


public interface UsuarioService {

	Optional<UsuarioResponseDTO> obterUsuarioPorNome(String nome);

	Page<UsuarioResponseDTO> obterTodosUsuarios(Pageable pageable);

	UsuarioResponseDTO buscarUsuarioPorId(Long id);

	UsuarioResponseDTO adicionarUsuario(UsuarioRequestDTO usuarioRequestDTO);

	UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO);

	UsuarioResponseDTO deletarUsuario(Long id);

	UsuarioResponseDTO zerarSenha(Long id, UsuarioRequestDTO usuarioRequestDTO);

	UsuarioResponseDTO toDto(Usuario usuario);

	Perfil verificarPerfilUsuario(Long id);

	boolean temPermissaoLerPublicacao(Long id);

	boolean temPermissaoCriarPublicacao(Long id);

	boolean temPermissaoGerenciarColecao(Long id);
}
