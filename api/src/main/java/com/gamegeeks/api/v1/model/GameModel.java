package com.gamegeeks.api.v1.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class GameModel {

    private String id;
    private String name;
    private String description;
    private LocalDate releaseDate;
    private FranchiseModel franchise;
    private Set<ThemeModel> themes;
    private Set<GenreModel> genres;
    private Set<GameModeModel> gameModes;
    private Set<PlatformModel> platforms;
    private Set<DeveloperModel> developers;

}
