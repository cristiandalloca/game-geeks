package com.gamegeeks.api.v1.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class FranchiseInput {

    @NotBlank
    @Schema(example = "Zelda", required = true)
    private String name;

}
