package com.gamegeeks.api.v1.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class DeveloperInput {

    @NotBlank
    @Schema(example = "Hazelight", required = true)
    private String name;

}
