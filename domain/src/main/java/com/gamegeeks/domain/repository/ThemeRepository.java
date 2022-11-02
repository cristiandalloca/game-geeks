package com.gamegeeks.domain.repository;

import com.gamegeeks.domain.model.Theme;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends MongoRepository<Theme, String> {
}
