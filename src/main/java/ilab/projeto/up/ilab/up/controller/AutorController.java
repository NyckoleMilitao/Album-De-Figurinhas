package ilab.projeto.up.ilab.up.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import ilab.projeto.up.ilab.up.dto.FigurinhaRequestDTO;
import ilab.projeto.up.ilab.up.dto.FigurinhaResponseDTO;

import ilab.projeto.up.ilab.up.service.FigurinhaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/api/autor")
public class AutorController {

     @Autowired
    private FigurinhaService figurinhaService;

    @PostMapping("/album/{numeroAlbum}/pagina/{pagina}")
    public ResponseEntity<FigurinhaResponseDTO> adicionarFigurinha(
            @PathVariable int numeroAlbum, 
            @PathVariable int pagina,
            @RequestBody FigurinhaRequestDTO figurinhaRequestDTO) {
        FigurinhaResponseDTO response = figurinhaService.adicionarfigurinha(numeroAlbum, pagina, figurinhaRequestDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/album/{numeroAlbum}/pagina/{pagina}")
    public ResponseEntity<FigurinhaResponseDTO> atualizarFigurinha(
            @PathVariable Long id,
            @PathVariable int numeroAlbum,
            @PathVariable int pagina,
            @RequestBody FigurinhaRequestDTO figurinhaRequestDTO) {
        FigurinhaResponseDTO response = figurinhaService.atualizarFigurinha(id, numeroAlbum, pagina, figurinhaRequestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/album/{idAlbum}/figurinha/{idFigurinha}")
    public ResponseEntity<Void> deletarFigurinha(
            @PathVariable Long idAlbum, 
            @PathVariable Long idFigurinha) {
        figurinhaService.deletarFigurinha(idAlbum, idFigurinha);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/album/{numeroAlbum}/pagina/{pagina}")
    public ResponseEntity<List<FigurinhaResponseDTO>> listarFigurinhas(
            @PathVariable int numeroAlbum, 
            @PathVariable int pagina) {
        List<FigurinhaResponseDTO> response = figurinhaService.listarFigurinhas(numeroAlbum, pagina);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FigurinhaResponseDTO> buscarFigurinha(@PathVariable Long id) {
        FigurinhaResponseDTO response = figurinhaService.buscarFigurinha(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/filtrar/nome")
    public ResponseEntity<List<FigurinhaResponseDTO>> filtrarFigurinhasPorNome(
            @RequestParam int numeroAlbum, 
            @RequestParam int pagina,
            @RequestParam String nomeFigurinha) {
        List<FigurinhaResponseDTO> response = figurinhaService.filtrarFigurinhasPorNome(numeroAlbum, pagina, nomeFigurinha);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/filtrar/tag")
    public ResponseEntity<List<FigurinhaResponseDTO>> filtrarFigurinhasPorTag(
            @RequestParam int numeroAlbum, 
            @RequestParam int pagina,
            @RequestParam String tag) {
        List<FigurinhaResponseDTO> response = figurinhaService.filtrarFigurinhasPorTag(numeroAlbum, pagina, tag);
        return ResponseEntity.ok(response);
    }
}
