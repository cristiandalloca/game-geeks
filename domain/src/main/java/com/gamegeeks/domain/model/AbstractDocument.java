package com.gamegeeks.domain.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Getter
public abstract class AbstractDocument {

    @Id
    private String id;

    @CreatedDate
    private Instant createdDateTime;

    @LastModifiedDate
    private Instant lastModifiedDateTime;

    public boolean isNew() {
        return this.id == null;
    }

}
