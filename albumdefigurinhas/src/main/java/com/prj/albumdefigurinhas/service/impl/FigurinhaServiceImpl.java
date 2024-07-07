package com.prj.albumdefigurinhas.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.albumdefigurinhas.dto.FigurinhaRequestDTO;
import com.prj.albumdefigurinhas.dto.FigurinhaResponseDTO;
import com.prj.albumdefigurinhas.mapper.FigurinhaMapper;
import com.prj.albumdefigurinhas.model.Album;
import com.prj.albumdefigurinhas.model.Figurinha;
import com.prj.albumdefigurinhas.reposiory.AlbumRepository;
import com.prj.albumdefigurinhas.reposiory.FigurinhaRepository;
import com.prj.albumdefigurinhas.service.FigurinhaService;

import jakarta.persistence.EntityNotFoundException;



@Service
public class FigurinhaServiceImpl implements FigurinhaService {

    @Autowired
    private FigurinhaRepository figurinhaRepository;

    private AlbumRepository albumRepository;

    // Métodos para gerenciar o álbum de figurinhas

    public Album criarAlbum() {
        Album album = new Album();
        // Lógica para inicializar o álbum, se necessário
        return albumRepository.save(album);
    }

    public Album obterAlbum(Long idAlbum) {
        return albumRepository.findById(idAlbum)
                .orElseThrow(() -> new RuntimeException("Álbum não encontrado com ID: " + idAlbum));
    }

    public Album procurarAlbum(int numeroAlbum, int pagina) {
        Optional<Album> albumNumero = albumRepository.findByNumeroAlbum(numeroAlbum);
        Optional<Album> albumPagina = albumRepository.findByPagina(numeroAlbum);

        if (!albumNumero.isPresent() && albumPagina.isPresent()) {
            return null;
        }
        Album album = albumNumero.get();
        album = albumPagina.get();

        return album;
    }

    @Override
    public FigurinhaResponseDTO adicionarfigurinha(int numeroAlbum, int pagina,
            FigurinhaRequestDTO figurinhaRequestDTO) {

        if (procurarAlbum(numeroAlbum, pagina) != null) {

            Figurinha novaFigurinha = new Figurinha();
            novaFigurinha.setNomeFigurinha(figurinhaRequestDTO.getNomeFigurinha());
            novaFigurinha.setDescricao(figurinhaRequestDTO.getDescricao());
            novaFigurinha.setTag(figurinhaRequestDTO.getTag());
            novaFigurinha.setFoto(figurinhaRequestDTO.getFoto());

            Figurinha figurinhaSalvo = figurinhaRepository.save(novaFigurinha);
            return FigurinhaMapper.toResponseDTO(figurinhaSalvo);
        } else {
            return null;
        }

    }

    @Override
    public FigurinhaResponseDTO atualizarFigurinha(Long id, int numeroAlbum, int pagina,
            FigurinhaRequestDTO figurinhaRequestDTO) {

        if (procurarAlbum(numeroAlbum, pagina) != null) {
            Optional<Figurinha> figurinhaOpt = figurinhaRepository.findById(id);
            if (!figurinhaOpt.isPresent()) {
                return null;
            }
            Figurinha novaFigurinha = new Figurinha();
            novaFigurinha.setNomeFigurinha(figurinhaRequestDTO.getNomeFigurinha());
            novaFigurinha.setDescricao(figurinhaRequestDTO.getDescricao());
            novaFigurinha.setTag(figurinhaRequestDTO.getTag());
            novaFigurinha.setFoto(figurinhaRequestDTO.getFoto());

            Figurinha figurinhaSalvo = figurinhaRepository.save(novaFigurinha);
            return FigurinhaMapper.toResponseDTO(figurinhaSalvo);
        } else {
            return null;
        }
    }

    @Override
    public FigurinhaResponseDTO deletarFigurinha(Long idAlbum, Long idFigurinha) {
        Optional<Album> albumOpt = albumRepository.findById(idAlbum);

        if (albumOpt.isPresent()) {
            Album album = albumOpt.get();
            List<Figurinha> figurinhas = album.getFigurinhas();

            // Procura a figurinha pelo ID dentro do álbum
            Optional<Figurinha> figurinhaOpt = figurinhas.stream()
                    .filter(figurinha -> figurinha.getId().equals(idFigurinha))
                    .findFirst();

            if (figurinhaOpt.isPresent()) {
                Figurinha figurinha = figurinhaOpt.get();
                figurinhas.remove(figurinha); // Remove a figurinha do álbum

                // Salva o álbum atualizado no banco de dados
                albumRepository.save(album);

                // A exclusão foi realizada com sucesso
                return null;
            }
        }

        // Caso o álbum ou a figurinha não sejam encontrados
        throw new EntityNotFoundException("Não foi possível encontrar o álbum ou a figurinha.");
    }

    @Override
    public List<FigurinhaResponseDTO> listarFigurinhas(int numeroAlbum, int pagina) {
        Album album = procurarAlbum(numeroAlbum, pagina);

        if (album != null) {
            List<Figurinha> figurinhas = album.getFigurinhas();
            return FigurinhaMapper.toResponseDTOList(figurinhas);
        }

        return Collections.emptyList();
    }

    @Override
    public FigurinhaResponseDTO buscarFigurinha(Long id) {
        Optional<Figurinha> figurinhaOpt = figurinhaRepository.findById(id);

        if (figurinhaOpt.isPresent()) {
            Figurinha figurinha = figurinhaOpt.get();
            return FigurinhaMapper.toResponseDTO(figurinha);
        }

        throw new EntityNotFoundException("Figurinha não encontrada com o ID fornecido: " + id);
    }

    @Override
    public List<FigurinhaResponseDTO> filtrarFigurinhasPorNome(int numeroAlbum, int pagina, String nomeFigurinha) {
        Album album = procurarAlbum(numeroAlbum, pagina);

        if (album != null) {
            List<Figurinha> figurinhas = album.getFigurinhas().stream()
                    .filter(figurinha -> figurinha.getNomeFigurinha().toLowerCase()
                            .contains(nomeFigurinha.toLowerCase()))
                    .collect(Collectors.toList());

            return FigurinhaMapper.toResponseDTOList(figurinhas);
        }

        return Collections.emptyList();
    }

    @Override
    public List<FigurinhaResponseDTO> filtrarFigurinhasPorTag(int numeroAlbum, int pagina, String tag) {
        Album album = procurarAlbum(numeroAlbum, pagina);

        if (album != null) {
            List<Figurinha> figurinhas = album.getFigurinhas().stream()
                    .filter(figurinha -> figurinha.getTag().equals(tag))
                    .collect(Collectors.toList());

            return FigurinhaMapper.toResponseDTOList(figurinhas);
        }

        return Collections.emptyList();
    }

}