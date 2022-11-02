package com.gamegeeks.api.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

    @Schema(example = "6362927a289959266849759a")
    private String id;


    private String firstName;
    private String lastName;
}
