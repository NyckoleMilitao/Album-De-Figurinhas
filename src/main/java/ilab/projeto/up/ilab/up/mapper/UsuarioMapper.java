package ilab.projeto.up.ilab.up.mapper;

import ilab.projeto.up.ilab.up.dto.UsuarioRequestDTO;
import ilab.projeto.up.ilab.up.dto.UsuarioResponseDTO;
import ilab.projeto.up.ilab.up.model.Usuario;

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
