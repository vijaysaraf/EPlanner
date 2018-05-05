package com.twosri.dev.database.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.twosri.dev.database.model.PhaseEntity;

public interface PhaseRepository extends MongoRepository<PhaseEntity, String> {
	
	void delete(PhaseEntity deleted);

	List<PhaseEntity> findAll();

	PhaseEntity findOne(String id);

	PhaseEntity save(PhaseEntity saved);
}
