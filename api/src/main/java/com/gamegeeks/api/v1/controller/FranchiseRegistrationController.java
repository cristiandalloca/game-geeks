package com.gamegeeks.api.v1.controller;

import com.gamegeeks.api.v1.assembler.FranchiseModelAssembler;
import com.gamegeeks.api.v1.model.FranchiseModel;
import com.gamegeeks.domain.service.FranchiseRegistrationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Franquias")
@RestController
@RequestMapping(value = "/v1/franchises", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class FranchiseRegistrationController {

    private final FranchiseRegistrationService franchiseRegistrationService;
    private final FranchiseModelAssembler franchiseModelAssembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FranchiseModel> search() {
        return franchiseModelAssembler.toCollectionModel(franchiseRegistrationService.findAll());
    }

}
