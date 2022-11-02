package com.gamegeeks.domain.repository;

import com.gamegeeks.domain.model.Developer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends MongoRepository<Developer, String> {
}
