package com.prj.albumdefigurinhas.mapper;

import com.prj.albumdefigurinhas.dto.UsuarioRequestDTO;
import com.prj.albumdefigurinhas.dto.UsuarioResponseDTO;
import com.prj.albumdefigurinhas.model.Usuario;

public class UsuarioMapper {

    private UsuarioMapper() {
        // Construtor privado para evitar instâncias
    }

    public static UsuarioResponseDTO toDto(Usuario usuario) {
        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO();
                responseDTO.setId(usuario.getId());
                responseDTO.setNome(usuario.getNome());
                responseDTO.setPerfil(usuario.getPerfil());

            return responseDTO;
    }

    public static Usuario toEntity(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setSenha(usuarioRequestDTO.getSenha());
        usuario.setPerfil(usuarioRequestDTO.getPerfil());
        return usuario;
    }
}
