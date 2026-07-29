package com.github.danimaniarqsoft.repository;

import com.github.danimaniarqsoft.domain.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data MongoDB reactive repository for the Project entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProjectRepository extends ReactiveMongoRepository<Project, String> {
    Flux<Project> findAllBy(Pageable pageable);

    @Query("{}")
    Flux<Project> findAllWithEagerRelationships(Pageable pageable);

    @Query("{}")
    Flux<Project> findAllWithEagerRelationships();

    @Query("{'id': ?0}")
    Mono<Project> findOneWithEagerRelationships(String id);
}
