package com.gamegeeks.api.v1.model.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class Problem {

    private Integer status;

    private OffsetDateTime timestamp;

    private String type;

    private String title;

    private String detail;

    private String userMessage;

    private List<Object> objects;

    @Getter
    public static class Object {

        private String name;

        private String userMessage;

    }
}
