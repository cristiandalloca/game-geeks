package com.gamegeeks.domain.model;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
public class Developer extends AbstractDocument {

    @Indexed(unique = true)
    private String name;

}
