package ilab.projeto.up.ilab.up.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import ilab.projeto.up.ilab.up.dto.UsuarioRequestDTO;
import ilab.projeto.up.ilab.up.dto.UsuarioResponseDTO;
import ilab.projeto.up.ilab.up.mapper.UsuarioMapper;
import ilab.projeto.up.ilab.up.model.Perfil;
import ilab.projeto.up.ilab.up.model.Usuario;
import ilab.projeto.up.ilab.up.repository.UsuarioRepository;
import ilab.projeto.up.ilab.up.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<UsuarioResponseDTO> obterUsuarioPorNome(String nome) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByNome(nome);
        return usuarioOpt.map(UsuarioMapper::toDto);
    }

    @Override
    public Page<UsuarioResponseDTO> obterTodosUsuarios(Pageable pageable) {
        Page<Usuario> usuariosPage = usuarioRepository.findAll(pageable);
        return usuariosPage.map(UsuarioMapper::toDto);
    }

    @Override
    public UsuarioResponseDTO buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        Usuario usuario = usuarioOpt.orElseThrow();
        return UsuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioResponseDTO adicionarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(usuarioRequestDTO.getNome());
        novoUsuario.setSenha(usuarioRequestDTO.getSenha());
        novoUsuario.setPerfil(usuarioRequestDTO.getPerfil());

        Usuario usuarioSalvo = usuarioRepository.save(novoUsuario);
        return UsuarioMapper.toDto(usuarioSalvo);
    }

    @Override
    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setNome(usuarioRequestDTO.getNome());
            usuario.setSenha(usuarioRequestDTO.getSenha());
            usuario.setPerfil(usuarioRequestDTO.getPerfil());

            Usuario usuarioAtualizado = usuarioRepository.save(usuario);
            return UsuarioMapper.toDto(usuarioAtualizado);
        } else {
            return null; // Ou outra forma de indicar que o usuário não foi encontrado
        }
    }

    @Override
    public UsuarioResponseDTO deletarUsuario(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuarioRepository.deleteById(id);
            return UsuarioMapper.toDto(usuario);
        } else {
            return null; // Ou outra forma de indicar que o usuário não foi encontrado
        }
    }

    @Override
    public UsuarioResponseDTO zerarSenha(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if ("nome".equals(usuarioRequestDTO.getNome())) {
                usuario.setSenha(usuario.getNome());
            } else {
                usuario.setSenha("123456");
            }

            Usuario usuarioAtualizado = usuarioRepository.save(usuario);
            return UsuarioMapper.toDto(usuarioAtualizado);
        } else {
            return null; // Ou outra forma de indicar que o usuário não foi encontrado
        }
    }

    @Override
    public Perfil verificarPerfilUsuario(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            return usuario.getPerfil();
        }
        return null; // Ou lançar exceção ou tratar de outra forma se o usuário não for encontrado
    }

    public UsuarioResponseDTO toDto(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setPerfil(usuario.getPerfil());
        // Preencher outros campos do DTO, se houver

        return dto;
    }

    private UsuarioResponseDTO converterParaUsuarioResponseDTO(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getSenha(), usuario.getPerfil());
    }

    public boolean temPermissaoLerPublicacao(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (!usuario.isPresent()) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + id);
        }

        UsuarioResponseDTO usuarioDTO = converterParaUsuarioResponseDTO(usuario.get());

        return usuarioDTO.getPerfil() == Perfil.COLECIONADOR;
    }

    public boolean temPermissaoCriarPublicacao(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (!usuario.isPresent()) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + id);
        }

        UsuarioResponseDTO usuarioDTO = converterParaUsuarioResponseDTO(usuario.get());

        return usuarioDTO.getPerfil() == Perfil.AUTOR;
    }

    public boolean temPermissaoGerenciarColecao(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (!usuario.isPresent()) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + id);
        }

        UsuarioResponseDTO usuarioDTO = converterParaUsuarioResponseDTO(usuario.get());

        return usuarioDTO.getPerfil() == Perfil.ADMINISTRADOR;
    }
}
