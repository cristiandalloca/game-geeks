package com.gamegeeks.api.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class GameModel {

    @Schema(example = "6362927a289959266849759a")
    private String id;


    private String name;


    private String description;


    private LocalDate releaseDate;


    private FranchiseModel franchise;


    private Set<GenreModel> genres;


    private Set<GameModeModel> gameModes;


    private Set<PlatformModel> platforms;


    private Set<DeveloperModel> developers;

}
