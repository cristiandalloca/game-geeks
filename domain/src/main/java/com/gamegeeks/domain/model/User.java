package com.gamegeeks.domain.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@Getter
public class User extends AbstractDocument {

    private String firstName;
    private String lastName;

}
