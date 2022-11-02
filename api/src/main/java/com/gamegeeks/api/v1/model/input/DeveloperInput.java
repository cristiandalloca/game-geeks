package com.gamegeeks.api.v1.model.input;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class DeveloperInput {

    @NotBlank
    private String name;

}
