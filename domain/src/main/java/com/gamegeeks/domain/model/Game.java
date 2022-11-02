package com.gamegeeks.domain.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Document
@Builder
@Getter
public class Game extends AbstractDocument {

    private String name;
    private String description;
    private LocalDate releaseDate;

    @DBRef
    private Franchise franchise;

    @DBRef
    @Builder.Default
    private Set<Theme> themes = new HashSet<>();

    @DBRef
    @Builder.Default
    private Set<Genre> genres = new HashSet<>();

    @DBRef
    @Builder.Default
    private Set<GameMode> gameModes = new HashSet<>();

    @DBRef
    @Builder.Default
    private Set<Platform> platforms = new HashSet<>();

    @DBRef
    @Builder.Default
    private Set<Developer> developers = new HashSet<>();

}
