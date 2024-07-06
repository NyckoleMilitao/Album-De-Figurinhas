package ilab.projeto.up.ilab.up.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ilab.projeto.up.ilab.up.dto.FigurinhaResponseDTO;
import ilab.projeto.up.ilab.up.service.FigurinhaService;

@RestController
@RequestMapping("/api/colecionador")
public class ColecionadorController {

    @Autowired
    private FigurinhaService figurinhaService;

    // Endpoint para listar todas as figurinhas de uma página específica do álbum
    @GetMapping("/album/{numeroAlbum}/pagina/{pagina}")
    public ResponseEntity<List<FigurinhaResponseDTO>> listarFigurinhas(
            @PathVariable int numeroAlbum, 
            @PathVariable int pagina) {
        List<FigurinhaResponseDTO> response = figurinhaService.listarFigurinhas(numeroAlbum, pagina);
        return ResponseEntity.ok(response);
    }

    // Endpoint para obter detalhes de uma figurinha específica
    @GetMapping("/figurinha/{id}")
    public ResponseEntity<FigurinhaResponseDTO> buscarFigurinha(@PathVariable Long id) {
        FigurinhaResponseDTO response = figurinhaService.buscarFigurinha(id);
        return ResponseEntity.ok(response);
    }
}
