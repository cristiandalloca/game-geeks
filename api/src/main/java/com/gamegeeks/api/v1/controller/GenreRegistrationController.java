package com.gamegeeks.api.v1.controller;

import com.gamegeeks.api.v1.assembler.GenreModelAssembler;
import com.gamegeeks.api.v1.model.GenreModel;
import com.gamegeeks.api.v1.openapi.GenreRegistrationControllerOpenApi;
import com.gamegeeks.domain.service.GenreRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/genres", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class GenreRegistrationController implements GenreRegistrationControllerOpenApi {

    private final GenreRegistrationService genreRegistrationService;
    private final GenreModelAssembler genreModelAssembler;

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GenreModel> search() {
        return genreModelAssembler.toCollectionModel(genreRegistrationService.findAll());
    }

}
