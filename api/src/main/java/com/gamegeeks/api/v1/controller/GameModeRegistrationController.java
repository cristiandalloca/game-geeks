package com.gamegeeks.api.v1.controller;

import com.gamegeeks.api.v1.assembler.GameModeModelAssembler;
import com.gamegeeks.api.v1.model.GameModeModel;
import com.gamegeeks.api.v1.openapi.GameModeRegistrationControllerOpenApi;
import com.gamegeeks.domain.service.GameModeRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/v1/game-modes", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class GameModeRegistrationController implements GameModeRegistrationControllerOpenApi {

    private final GameModeRegistrationService gameModeRegistrationService;
    private final GameModeModelAssembler gameModeModelAssembler;

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameModeModel> search() {
        return gameModeModelAssembler.toCollectionModel(gameModeRegistrationService.findAll());
    }

}
