package ilab.projeto.up.ilab.up.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import ilab.projeto.up.ilab.up.dto.FigurinhaRequestDTO;
import ilab.projeto.up.ilab.up.dto.FigurinhaResponseDTO;

import ilab.projeto.up.ilab.up.service.FigurinhaService;
//import ilab.projeto.up.ilab.up.service.TemPermissaoGerenciarColecao;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;


import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Controller
@RequestMapping("/api/autor")
public class AutorController {

     @Autowired
    private FigurinhaService figurinhaService;

      @ApiOperation(value = "Adicionar uma nova figurinha")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Figurinha adicionada com sucesso!"),
            @ApiResponse(code = 401, message = "Erro de autenticação"),
            @ApiResponse(code = 403, message = "Proibido"),
            @ApiResponse(code = 404, message = "Recurso não disponível"),
            @ApiResponse(code = 500, message = "Erro interno no servidor"),
            @ApiResponse(code = 505, message = "Ocorreu uma exceção")
    })
    //@TemPermissaoGerenciarColecao
    @PostMapping
    public ResponseEntity<FigurinhaResponseDTO> adicionarFigurinha(@RequestParam int numeroAlbum,
                                                                   @RequestParam int pagina,
                                                                   @RequestBody FigurinhaRequestDTO figurinhaRequestDTO) {
        FigurinhaResponseDTO response = figurinhaService.adicionarfigurinha(numeroAlbum, pagina, figurinhaRequestDTO);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Atualizar uma figurinha existente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Figurinha atualizada com sucesso!"),
            @ApiResponse(code = 401, message = "Erro de autenticação"),
            @ApiResponse(code = 403, message = "Proibido"),
            @ApiResponse(code = 404, message = "Recurso não disponível"),
            @ApiResponse(code = 500, message = "Erro interno no servidor"),
            @ApiResponse(code = 505, message = "Ocorreu uma exceção")
    })
    //@TemPermissaoGerenciarColecao
    @PutMapping("/{id}")
    public ResponseEntity<FigurinhaResponseDTO> atualizarFigurinha(@PathVariable Long id,
                                                                   @RequestParam int numeroAlbum,
                                                                   @RequestParam int pagina,
                                                                   @RequestBody FigurinhaRequestDTO figurinhaRequestDTO) {
        FigurinhaResponseDTO response = figurinhaService.atualizarFigurinha(id, numeroAlbum, pagina, figurinhaRequestDTO);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Deletar uma figurinha")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Figurinha deletada com sucesso!"),
            @ApiResponse(code = 401, message = "Erro de autenticação"),
            @ApiResponse(code = 403, message = "Proibido"),
            @ApiResponse(code = 404, message = "Recurso não disponível"),
            @ApiResponse(code = 500, message = "Erro interno no servidor"),
            @ApiResponse(code = 505, message = "Ocorreu uma exceção")
    })
    //@TemPermissaoGerenciarColecao
    @DeleteMapping("/{idAlbum}/{idFigurinha}")
    public ResponseEntity<Void> deletarFigurinha(@PathVariable Long idAlbum, @PathVariable Long idFigurinha) {
        figurinhaService.deletarFigurinha(idAlbum, idFigurinha);
        return ResponseEntity.noContent().build();
    }
}
