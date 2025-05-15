package com.api_filmes.ApiFilmes.service;

import com.api_filmes.ApiFilmes.client.FilmeClientOMDBFeign;
import com.api_filmes.ApiFilmes.dto.FilmeRequestDTO;
import com.api_filmes.ApiFilmes.dto.FilmeResponseDTO;
import com.api_filmes.ApiFilmes.model.Filme;
import com.api_filmes.ApiFilmes.repository.FilmeRepository;
import com.api_filmes.ApiFilmes.vo.FilmeOMDB;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@Service
@RequiredArgsConstructor
public class FilmeService {

    @Value("${omdb.apiKey}")
    private String apiKey;
    @Autowired
    private FilmeClientOMDBFeign filmeClientFeign;
    @Autowired
    private FilmeRepository filmeRepository;


    public FilmeResponseDTO salvarFilme(FilmeRequestDTO request) {
        FilmeOMDB filmeOMDB = filmeClientFeign.buscarFilme(request.getTitulo(), apiKey);

        if (filmeOMDB == null) {
            throw new ResponseStatusException(NOT_FOUND, "Filme não encontrado na OMDb");
        }

        Filme filme = filmeRepository.save(Filme.builder()
                .title(filmeOMDB.getTitle())
                .year(filmeOMDB.getYear())
                .genre(filmeOMDB.getGenre())
                .plot(filmeOMDB.getPlot())
                .build());

        return toResponseDTO(filme);

    }

    public List<FilmeResponseDTO> listarFilmes() {
        return filmeRepository.findAll().stream().map(this::toResponseDTO).collect(Collectors.toList());
    }

    public FilmeResponseDTO buscarPorId(int id) {
        Filme filme = filmeRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(NOT_FOUND, "Filme não encontrado."));
        return toResponseDTO(filme);
    }

    public void removerFilme(int id) {
        if(!filmeRepository.existsById(id)) {
            throw new ResponseStatusException(NOT_FOUND, "Filme não encontrado.");
        }
        filmeRepository.deleteById(id);
    }


    private FilmeResponseDTO toResponseDTO(Filme filme) {
        return FilmeResponseDTO.builder()
                .id(filme.getId())
                .title(filme.getTitle())
                .year(filme.getYear())
                .genre(filme.getGenre())
                .plot(filme.getPlot())
                .build();
    }
}
