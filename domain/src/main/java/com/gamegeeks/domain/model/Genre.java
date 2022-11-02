package com.gamegeeks.domain.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@Getter
public class Genre extends AbstractDocument {

    @Indexed(unique = true)
    private String name;

}
