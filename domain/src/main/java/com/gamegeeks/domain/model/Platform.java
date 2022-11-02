package com.gamegeeks.domain.model;

import lombok.Builder;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
public class Platform extends AbstractDocument {

    @Indexed(unique = true)
    private String name;

    private String description;

}
