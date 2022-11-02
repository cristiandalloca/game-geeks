package com.gamegeeks.api.v1.controller;

import com.gamegeeks.api.v1.assembler.GameModelAssembler;
import com.gamegeeks.api.v1.model.GameModel;
import com.gamegeeks.domain.service.GameRegistrationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Jogos")
@RestController
@RequestMapping(value = "/v1/games", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class GameRegistrationController {

    private final GameRegistrationService gameRegistrationService;
    private final GameModelAssembler gameModelAssembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameModel> search() {
        return gameModelAssembler.toCollectionModel(gameRegistrationService.findAll());
    }

}
