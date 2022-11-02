package com.gamegeeks.domain.repository;

import com.gamegeeks.domain.model.GameMode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameModeRepository extends MongoRepository<GameMode, String> {
}
