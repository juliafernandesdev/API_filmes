package com.api_filmes.ApiFilmes.repository;

import com.api_filmes.ApiFilmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer>{

}
