package com.gamegeeks.api.v1.controller;

import com.gamegeeks.api.v1.assembler.PlatformModelAssembler;
import com.gamegeeks.api.v1.model.PlatformModel;
import com.gamegeeks.api.v1.openapi.PlatformRegistrationControllerOpenApi;
import com.gamegeeks.domain.service.PlatformRegistrationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/v1/platforms", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PlatformRegistrationController implements PlatformRegistrationControllerOpenApi {

    private final PlatformRegistrationService platformRegistrationService;
    private final PlatformModelAssembler platformModelAssembler;

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PlatformModel> search() {
        return platformModelAssembler.toCollectionModel(platformRegistrationService.findAll());
    }

}
