package com.api_filmes.ApiFilmes.controller;

import com.api_filmes.ApiFilmes.dto.FilmeRequestDTO;
import com.api_filmes.ApiFilmes.dto.FilmeResponseDTO;
import com.api_filmes.ApiFilmes.service.FilmeService;
import com.api_filmes.ApiFilmes.vo.FilmeOMDB;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;



@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmeController {

    @Autowired
    private FilmeService filmeService;


    @PostMapping
    public ResponseEntity<FilmeResponseDTO> salvar(@RequestBody FilmeRequestDTO request) {
        try {
            return ResponseEntity.ok(filmeService.salvarFilme(request));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<FilmeResponseDTO>> listar() {
        try{
            return ResponseEntity.ok(filmeService.listarFilmes());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<FilmeResponseDTO> buscarPorId(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(filmeService.buscarPorId(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") int id) {
        try {
            filmeService.removerFilme(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
