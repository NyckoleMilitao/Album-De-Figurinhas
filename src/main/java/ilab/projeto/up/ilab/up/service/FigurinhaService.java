package ilab.projeto.up.ilab.up.service;

import java.util.List;

import ilab.projeto.up.ilab.up.dto.FigurinhaRequestDTO;
import ilab.projeto.up.ilab.up.dto.FigurinhaResponseDTO;
import ilab.projeto.up.ilab.up.model.Album;

public interface FigurinhaService {

    FigurinhaResponseDTO adicionarfigurinha(int numeroAlbum, int pagina, FigurinhaRequestDTO figurinhaRequestDTO);

    Album procurarAlbum(int numeroAlbum, int pagina);

    FigurinhaResponseDTO atualizarFigurinha(Long id, int numeroAlbum, int pagina,
            FigurinhaRequestDTO figurinhaRequestDTO);

    FigurinhaResponseDTO deletarFigurinha(Long idAlbum, Long idFigurinha);

    Album obterAlbum(Long idAlbum);

    Album criarAlbum();

    List<FigurinhaResponseDTO> listarFigurinhas(int numeroAlbum, int pagina);

    FigurinhaResponseDTO buscarFigurinha(Long id);

    List<FigurinhaResponseDTO> filtrarFigurinhasPorNome(int numeroAlbum, int pagina, String nomeFigurinha);

    List<FigurinhaResponseDTO> filtrarFigurinhasPorTag(int numeroAlbum, int pagina, String tag);
}
