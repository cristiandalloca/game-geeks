package com.gamegeeks.domain.repository;

import com.gamegeeks.domain.model.Platform;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends MongoRepository<Platform, String> {
}
