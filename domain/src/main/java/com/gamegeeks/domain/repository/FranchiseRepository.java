package com.gamegeeks.domain.repository;

import com.gamegeeks.domain.model.Franchise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends MongoRepository<Franchise, String> {
}
