package com.gamegeeks.domain.repository;

import com.gamegeeks.domain.model.Developer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeveloperRepository extends MongoRepository<Developer, String> {

    Optional<Developer> findByNameIgnoreCase(String name);

}
