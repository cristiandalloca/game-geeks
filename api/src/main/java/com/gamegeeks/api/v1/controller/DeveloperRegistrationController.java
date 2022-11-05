package com.gamegeeks.api.v1.controller;

import com.gamegeeks.api.util.CreatedLocationUtil;
import com.gamegeeks.api.v1.assembler.DeveloperModelAssembler;
import com.gamegeeks.api.v1.disassembler.DeveloperInputDisassembler;
import com.gamegeeks.api.v1.model.DeveloperModel;
import com.gamegeeks.api.v1.model.input.DeveloperInput;
import com.gamegeeks.domain.model.Developer;
import com.gamegeeks.domain.service.DeveloperRegistrationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Desenvolvedores")
@SecurityRequirement(name = "security_auth")
@RestController
@RequestMapping(value = "/v1/developers", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DeveloperRegistrationController {

    private final DeveloperRegistrationService developerRegistrationService;
    private final DeveloperModelAssembler developerModelAssembler;
    private final DeveloperInputDisassembler developerInputDisassembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DeveloperModel> search() {
        return developerModelAssembler.toCollectionModel(developerRegistrationService.findAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DeveloperModel> insert(@Valid @RequestBody DeveloperInput developerInput) {
        Developer developer = developerInputDisassembler.toDomainObject(developerInput);
        developer = developerRegistrationService.createOrUpdate(developer);
        return ResponseEntity.created(CreatedLocationUtil.getURI(developer.getId())).body(developerModelAssembler.toModel(developer));
    }

    @GetMapping("/{developerId}")
    @ResponseStatus(HttpStatus.OK)
    public DeveloperModel searchById(@PathVariable String developerId) {
        Developer developer = developerRegistrationService.findByIdOrFail(developerId);
        return developerModelAssembler.toModel(developer);
    }

}
