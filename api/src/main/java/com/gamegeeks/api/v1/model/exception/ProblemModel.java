package com.gamegeeks.api.v1.model.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class ProblemModel {

    @Schema(example = "400")
    private Integer status;

    @Schema(example = "2022-12-01T18:09:02.70844Z")
    private OffsetDateTime timestamp;

    @Schema(example = "https://gamegeeks.com/invalid-data")
    private String type;

    @Schema(example = "Invalid data")
    private String title;

    @Schema(example = "One or more fields are invalid. Please fill in correctly and try again")
    private String detail;

    @Schema(example = "One or more fields are invalid. Please fill in correctly and try again")
    private String userMessage;

    @ArraySchema
    private List<Field> fields;

    @Getter
    @Schema(name = "ProblemModelField")
    public static class Field {

        @Schema(example = "price")
        private String name;

        @Schema(example = "Price is mandatory")
        private String userMessage;

    }
}
