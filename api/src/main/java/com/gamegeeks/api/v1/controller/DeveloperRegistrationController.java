package com.gamegeeks.api.v1.controller;

import com.gamegeeks.api.v1.assembler.DeveloperModelAssembler;
import com.gamegeeks.api.v1.model.DeveloperModel;
import com.gamegeeks.domain.service.DeveloperRegistrationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Desenvolvedores")
@RestController
@RequestMapping(value = "/v1/developers", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DeveloperRegistrationController {

    private final DeveloperRegistrationService developerRegistrationService;
    private final DeveloperModelAssembler gameModelAssembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DeveloperModel> search() {
        return gameModelAssembler.toCollectionModel(developerRegistrationService.findAll());
    }

}
