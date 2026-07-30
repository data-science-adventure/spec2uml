package com.github.danimaniarqsoft.repository;

import com.github.danimaniarqsoft.domain.Requirement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data MongoDB reactive repository for the Requirement entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RequirementRepository extends ReactiveMongoRepository<Requirement, String> {
    Flux<Requirement> findAllBy(Pageable pageable);

    /**
     * Finds requirements by nested project ID (requirement.project.id).
     */
    @Query("{ 'project.id': ?0 }")
    Flux<Requirement> findByProjectId(String projectId, Pageable pageable);

    /**
     * Counts requirements by nested project ID (requirement.project.id).
     */
    @Query(value = "{ 'project.id': ?0 }", count = true)
    Mono<Long> countByProjectId(String projectId);

    @Query("{}")
    Flux<Requirement> findAllWithEagerRelationships(Pageable pageable);

    @Query("{}")
    Flux<Requirement> findAllWithEagerRelationships();

    @Query("{'id': ?0}")
    Mono<Requirement> findOneWithEagerRelationships(String id);
}
