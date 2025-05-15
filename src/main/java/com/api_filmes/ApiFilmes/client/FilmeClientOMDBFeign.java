package com.api_filmes.ApiFilmes.client;

import com.api_filmes.ApiFilmes.vo.FilmeOMDB;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="omdbFilmes", url="${omdb.api.url}")
public interface FilmeClientOMDBFeign {

    @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/")
    FilmeOMDB buscarFilme(@RequestParam("t") String titulo, @RequestParam("apiKey") String key);
}
