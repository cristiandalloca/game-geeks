package com.gamegeeks.api.v1.controller;

import com.gamegeeks.api.util.CreatedLocationUtil;
import com.gamegeeks.api.v1.assembler.DeveloperModelAssembler;
import com.gamegeeks.api.v1.disassembler.DeveloperInputDisassembler;
import com.gamegeeks.api.v1.model.DeveloperModel;
import com.gamegeeks.api.v1.model.input.DeveloperInput;
import com.gamegeeks.api.v1.openapi.DeveloperRegistrationControllerOpenApi;
import com.gamegeeks.domain.model.Developer;
import com.gamegeeks.domain.service.DeveloperRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/developers", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DeveloperRegistrationController implements DeveloperRegistrationControllerOpenApi {

    private final DeveloperRegistrationService developerRegistrationService;
    private final DeveloperModelAssembler developerModelAssembler;
    private final DeveloperInputDisassembler developerInputDisassembler;

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DeveloperModel> search() {
        return developerModelAssembler.toCollectionModel(developerRegistrationService.findAll());
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DeveloperModel> insert(@Valid @RequestBody DeveloperInput developerInput) {
        Developer developer = developerInputDisassembler.toDomainObject(developerInput);
        developer = developerRegistrationService.createOrUpdate(developer);
        return ResponseEntity.created(CreatedLocationUtil.getURI(developer.getId())).body(developerModelAssembler.toModel(developer));
    }

    @Override
    @GetMapping("/{developerId}")
    @ResponseStatus(HttpStatus.OK)
    public DeveloperModel searchById(@PathVariable String developerId) {
        Developer developer = developerRegistrationService.findByIdOrFail(developerId);
        return developerModelAssembler.toModel(developer);
    }

    @Override
    @PutMapping("/{developerId}")
    @ResponseStatus(HttpStatus.OK)
    public DeveloperModel updateById(@PathVariable String developerId, @Valid @RequestBody DeveloperInput developerInput) {
        Developer actualDeveloper = developerRegistrationService.findByIdOrFail(developerId);
        developerInputDisassembler.copyToDomainObject(developerInput, actualDeveloper);
        actualDeveloper = developerRegistrationService.createOrUpdate(actualDeveloper);
        return developerModelAssembler.toModel(actualDeveloper);
    }

    @Override
    @DeleteMapping("/{developerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String developerId) {
        developerRegistrationService.deleteById(developerId);
    }

}
