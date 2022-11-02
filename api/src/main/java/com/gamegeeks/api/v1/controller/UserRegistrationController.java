package com.gamegeeks.api.v1.controller;

import com.gamegeeks.api.v1.assembler.UserModelAssembler;
import com.gamegeeks.api.v1.model.UserModel;
import com.gamegeeks.domain.service.UserRegistrationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Usuários")
@RestController
@RequestMapping(value = "/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;
    private final UserModelAssembler userModelAssembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserModel> search() {
        return userModelAssembler.toCollectionModel(userRegistrationService.findAll());
    }

}
