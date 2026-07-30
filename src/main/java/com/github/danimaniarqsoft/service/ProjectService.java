package com.github.danimaniarqsoft.service;

import com.github.danimaniarqsoft.domain.Project;
import com.github.danimaniarqsoft.domain.UserRef;
import com.github.danimaniarqsoft.repository.ProjectRepository;
import com.github.danimaniarqsoft.repository.UserRepository;
import com.github.danimaniarqsoft.security.SecurityUtils;
import com.github.danimaniarqsoft.service.dto.ProjectDTO;
import com.github.danimaniarqsoft.service.mapper.ProjectMapper;
import com.github.danimaniarqsoft.service.mapper.UserRefMapper;
import java.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link com.github.danimaniarqsoft.domain.Project}.
 */
@Service
public class ProjectService {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectService.class);

    private final ProjectRepository projectRepository;

    private final UserRepository userRepository;

    private final ProjectMapper projectMapper;

    private final UserRefMapper userRefMapper;

    public ProjectService(
        ProjectRepository projectRepository,
        UserRepository userRepository,
        ProjectMapper projectMapper,
        UserRefMapper userRefMapper
    ) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.projectMapper = projectMapper;
        this.userRefMapper = userRefMapper;
    }

    /**
     * Save a project.
     *
     * Sets createdAt and updatedAt to the current time, and resolves createdBy
     * as a lightweight UserRef from the Security Context.
     *
     * @param projectDTO the entity to save.
     * @return the persisted entity.
     */
    public Mono<ProjectDTO> save(ProjectDTO projectDTO) {
        LOG.debug("Request to save Project : {}", projectDTO);

        Project entity = projectMapper.toEntity(projectDTO);
        Instant now = Instant.now();
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);

        return SecurityUtils.getCurrentUserLogin()
            .flatMap(userRepository::findOneByLogin)
            .map(currentUser -> {
                UserRef userRef = userRefMapper.userToUserRef(currentUser);
                entity.setCreatedBy(userRef);
                return entity;
            })
            .defaultIfEmpty(entity)
            .flatMap(projectRepository::save)
            .map(projectMapper::toDto);
    }

    /**
     * Update a project.
     *
     * Preserves existing createdAt and createdBy from the database,
     * while updating updatedAt to the current time.
     *
     * @param projectDTO the entity to save.
     * @return the persisted entity.
     */
    public Mono<ProjectDTO> update(ProjectDTO projectDTO) {
        LOG.debug("Request to update Project : {}", projectDTO);

        return projectRepository.findById(projectDTO.getId()).flatMap(existingProject -> {
            Project entityToSave = projectMapper.toEntity(projectDTO);

            // Preserve original system attributes
            entityToSave.setCreatedAt(existingProject.getCreatedAt());
            entityToSave.setCreatedBy(existingProject.getCreatedBy());

            // System updates modification timestamp
            entityToSave.setUpdatedAt(Instant.now());

            return projectRepository.save(entityToSave).map(projectMapper::toDto);
        });
    }

    /**
     * Partially update a project.
     *
     * Ignores incoming values for createdAt and createdBy, while updating
     * updatedAt to the current time.
     *
     * @param projectDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Mono<ProjectDTO> partialUpdate(ProjectDTO projectDTO) {
        LOG.debug("Request to partially update Project : {}", projectDTO);

        return projectRepository
            .findById(projectDTO.getId())
            .map(existingProject -> {
                // Ignore client-supplied system attributes before mapping
                projectDTO.setCreatedAt(null);
                projectDTO.setCreatedBy(null);
                projectDTO.setUpdatedAt(null);

                projectMapper.partialUpdate(existingProject, projectDTO);

                // Set system updated timestamp
                existingProject.setUpdatedAt(Instant.now());

                return existingProject;
            })
            .flatMap(projectRepository::save)
            .map(projectMapper::toDto);
    }

    /**
     * Get all projects where the currently authenticated user is the owner (createdBy),
     * an annotator (annotatorses), or a reviewer (reviewerses).
     *
     * @param pageable the pagination information.
     * @return the filtered list of entities.
     */
    public Flux<ProjectDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all Projects for current user");
        return SecurityUtils.getCurrentUserLogin()
            .flatMapMany(userLogin -> projectRepository.findByCurrentUser(userLogin, pageable))
            .map(projectMapper::toDto);
    }

    /**
     * Get all the projects with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Flux<ProjectDTO> findAllWithEagerRelationships(Pageable pageable) {
        return projectRepository.findAllWithEagerRelationships(pageable).map(projectMapper::toDto);
    }

    /**
     * Returns the total number of projects available to the currently authenticated user.
     *
     * @return the number of matching entities in the database.
     */
    public Mono<Long> countAll() {
        return SecurityUtils.getCurrentUserLogin().flatMap(projectRepository::countByCurrentUser).defaultIfEmpty(0L);
    }

    /**
     * Get one project by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Mono<ProjectDTO> findOne(String id) {
        LOG.debug("Request to get Project : {}", id);
        return projectRepository.findOneWithEagerRelationships(id).map(projectMapper::toDto);
    }

    /**
     * Delete the project by id.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    public Mono<Void> delete(String id) {
        LOG.debug("Request to delete Project : {}", id);
        return projectRepository.deleteById(id);
    }
}
