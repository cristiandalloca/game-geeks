package com.gamegeeks.api.v1.controller;

import com.gamegeeks.api.util.CreatedLocationUtil;
import com.gamegeeks.api.v1.assembler.FranchiseModelAssembler;
import com.gamegeeks.api.v1.disassembler.FranchiseInputDisassembler;
import com.gamegeeks.api.v1.model.FranchiseModel;
import com.gamegeeks.api.v1.model.input.FranchiseInput;
import com.gamegeeks.api.v1.openapi.FranchiseRegistrationControllerOpenApi;
import com.gamegeeks.domain.model.Franchise;
import com.gamegeeks.domain.service.FranchiseRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/v1/franchises", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class FranchiseRegistrationController implements FranchiseRegistrationControllerOpenApi {

    private final FranchiseRegistrationService franchiseRegistrationService;
    private final FranchiseModelAssembler franchiseModelAssembler;
    private final FranchiseInputDisassembler franchiseInputDisassembler;

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FranchiseModel> search() {
        return franchiseModelAssembler.toCollectionModel(franchiseRegistrationService.findAll());
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FranchiseModel> insert(@Valid @RequestBody FranchiseInput franchiseInput) {
        Franchise franchise = franchiseInputDisassembler.toDomainObject(franchiseInput);
        franchise = franchiseRegistrationService.createOrUpdate(franchise);
        return ResponseEntity.created(CreatedLocationUtil.getURI(franchise.getId())).body(franchiseModelAssembler.toModel(franchise));
    }

    @Override
    @GetMapping("/{franchiseId}")
    @ResponseStatus(HttpStatus.OK)
    public FranchiseModel searchById(@PathVariable String franchiseId) {
        Franchise franchise = franchiseRegistrationService.findByIdOrFail(franchiseId);
        return franchiseModelAssembler.toModel(franchise);
    }

}
