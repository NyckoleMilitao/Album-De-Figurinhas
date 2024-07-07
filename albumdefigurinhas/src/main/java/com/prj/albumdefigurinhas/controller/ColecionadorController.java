package com.prj.albumdefigurinhas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prj.albumdefigurinhas.dto.FigurinhaResponseDTO;
import com.prj.albumdefigurinhas.service.FigurinhaService;

import io.swagger.annotations.*;

@RestController
@RequestMapping("/api/colecionador")
public class ColecionadorController {

    @Autowired
    private FigurinhaService figurinhaService;

    @ApiOperation(value = "Listar todas as figurinhas de um álbum e página específicos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Figurinhas listadas com sucesso!"),
            @ApiResponse(code = 401, message = "Erro de autenticação"),
            @ApiResponse(code = 403, message = "Proibido"),
            @ApiResponse(code = 404, message = "Recurso não disponível"),
            @ApiResponse(code = 500, message = "Erro interno no servidor"),
            @ApiResponse(code = 505, message = "Ocorreu uma exceção")
    })
    //@TemPermissaoLerPublicacao
    @GetMapping("/album/{numeroAlbum}/pagina/{pagina}")
    public ResponseEntity<List<FigurinhaResponseDTO>> listarFigurinhas(
            @PathVariable int numeroAlbum, 
            @PathVariable int pagina) {
        List<FigurinhaResponseDTO> response = figurinhaService.listarFigurinhas(numeroAlbum, pagina);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Buscar uma figurinha pelo ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Figurinha encontrada com sucesso!"),
            @ApiResponse(code = 401, message = "Erro de autenticação"),
            @ApiResponse(code = 403, message = "Proibido"),
            @ApiResponse(code = 404, message = "Recurso não disponível"),
            @ApiResponse(code = 500, message = "Erro interno no servidor"),
            @ApiResponse(code = 505, message = "Ocorreu uma exceção")
    })
    //@TemPermissaoLerPublicacao
    @GetMapping("/figurinha/{id}")
    public ResponseEntity<FigurinhaResponseDTO> buscarFigurinha(@PathVariable Long id) {
        FigurinhaResponseDTO response = figurinhaService.buscarFigurinha(id);
        return ResponseEntity.ok(response);
    }
}
