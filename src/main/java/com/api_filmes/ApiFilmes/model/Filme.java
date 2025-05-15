package com.api_filmes.ApiFilmes.model;

import jakarta.persistence.*;
import lombok.*;


@Table(name="filmes")
@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="titulo")
    private String title;
    @Column(name="ano")
    private String year;
    @Column(name="genero")
    private String genre;
    @Column(name="descricao")
    private String plot;
}
