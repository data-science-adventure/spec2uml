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
    /**
     * Find projects where the given user is the creator, an annotator, or a reviewer.
     *
     * @param userLogin the login username of the authenticated user
     * @param pageable pagination parameters
     * @return a Flux emitting matching Projects
     */
    @Query("{ '$or': [ { 'createdBy.login': ?0 }, { 'annotatorses.login': ?0 }, { 'reviewerses.login': ?0 } ] }")
    Flux<Project> findByCurrentUser(String userLogin, Pageable pageable);

    /**
     * Count total projects where the given user is the creator, an annotator, or a reviewer.
     *
     * @param userLogin the login username of the authenticated user
     * @return a Mono emitting the total count
     */
    @Query(value = "{ '$or': [ { 'createdBy.login': ?0 }, { 'annotatorses.login': ?0 }, { 'reviewerses.login': ?0 } ] }", count = true)
    Mono<Long> countByCurrentUser(String userLogin);

    Flux<Project> findAllBy(Pageable pageable);

    @Query("{}")
    Flux<Project> findAllWithEagerRelationships(Pageable pageable);

    @Query("{}")
    Flux<Project> findAllWithEagerRelationships();

    @Query("{'id': ?0}")
    Mono<Project> findOneWithEagerRelationships(String id);
}
