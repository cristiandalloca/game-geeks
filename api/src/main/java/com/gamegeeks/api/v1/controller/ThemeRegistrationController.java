package com.gamegeeks.api.v1.controller;

import com.gamegeeks.api.v1.assembler.ThemeModelAssembler;
import com.gamegeeks.api.v1.model.ThemeModel;
import com.gamegeeks.domain.service.ThemeRegistrationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Temas")
@RestController
@RequestMapping(value = "/v1/themes", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ThemeRegistrationController {

    private final ThemeRegistrationService themeRegistrationService;
    private final ThemeModelAssembler themeModelAssembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ThemeModel> search() {
        return themeModelAssembler.toCollectionModel(themeRegistrationService.findAll());
    }

}
