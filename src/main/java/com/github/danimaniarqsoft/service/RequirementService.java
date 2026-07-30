package com.github.danimaniarqsoft.service;

import com.github.danimaniarqsoft.domain.Requirement;
import com.github.danimaniarqsoft.domain.UserRef;
import com.github.danimaniarqsoft.repository.RequirementRepository;
import com.github.danimaniarqsoft.repository.UserRepository;
import com.github.danimaniarqsoft.security.SecurityUtils;
import com.github.danimaniarqsoft.service.dto.RequirementDTO;
import com.github.danimaniarqsoft.service.mapper.RequirementMapper;
import com.github.danimaniarqsoft.service.mapper.UserRefMapper;
import java.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link com.github.danimaniarqsoft.domain.Requirement}.
 */
@Service
public class RequirementService {

    private static final Logger LOG = LoggerFactory.getLogger(RequirementService.class);

    private final RequirementRepository requirementRepository;

    private final UserRepository userRepository;

    private final RequirementMapper requirementMapper;

    private final UserRefMapper userRefMapper;

    public RequirementService(
        RequirementRepository requirementRepository,
        UserRepository userRepository,
        RequirementMapper requirementMapper,
        UserRefMapper userRefMapper
    ) {
        this.requirementRepository = requirementRepository;
        this.userRepository = userRepository;
        this.requirementMapper = requirementMapper;
        this.userRefMapper = userRefMapper;
    }

    /**
     * Save a requirement.
     *
     * Sets createdAt and updatedAt to current time, and resolves createdBy
     * as a lightweight UserRef from the Security Context.
     *
     * @param requirementDTO the entity to save.
     * @return the persisted entity.
     */
    public Mono<RequirementDTO> save(RequirementDTO requirementDTO) {
        LOG.debug("Request to save Requirement : {}", requirementDTO);

        Requirement entity = requirementMapper.toEntity(requirementDTO);
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
            .flatMap(requirementRepository::save)
            .map(requirementMapper::toDto);
    }

    /**
     * Update a requirement.
     *
     * Preserves existing createdAt and createdBy from the database,
     * while updating updatedAt to current time.
     *
     * @param requirementDTO the entity to save.
     * @return the persisted entity.
     */
    public Mono<RequirementDTO> update(RequirementDTO requirementDTO) {
        LOG.debug("Request to update Requirement : {}", requirementDTO);

        return requirementRepository.findById(requirementDTO.getId()).flatMap(existingRequirement -> {
            Requirement entityToSave = requirementMapper.toEntity(requirementDTO);

            // Preserve original system attributes
            entityToSave.setCreatedAt(existingRequirement.getCreatedAt());
            entityToSave.setCreatedBy(existingRequirement.getCreatedBy());

            // System updates modification timestamp
            entityToSave.setUpdatedAt(Instant.now());

            return requirementRepository.save(entityToSave).map(requirementMapper::toDto);
        });
    }

    /**
     * Partially update a requirement.
     *
     * Ignores incoming values for createdAt and createdBy, while updating
     * updatedAt to current time.
     *
     * @param requirementDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Mono<RequirementDTO> partialUpdate(RequirementDTO requirementDTO) {
        LOG.debug("Request to partially update Requirement : {}", requirementDTO);

        return requirementRepository
            .findById(requirementDTO.getId())
            .map(existingRequirement -> {
                // Ignore client-supplied system attributes before mapping
                requirementDTO.setCreatedAt(null);
                requirementDTO.setCreatedBy(null);
                requirementDTO.setUpdatedAt(null);

                requirementMapper.partialUpdate(existingRequirement, requirementDTO);

                // Set system updated timestamp
                existingRequirement.setUpdatedAt(Instant.now());

                return existingRequirement;
            })
            .flatMap(requirementRepository::save)
            .map(requirementMapper::toDto);
    }

    /**
     * Get all the requirements.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    public Flux<RequirementDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all Requirements");
        return requirementRepository.findAllBy(pageable).map(requirementMapper::toDto);
    }

    /**
     * Get all the requirements with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Flux<RequirementDTO> findAllWithEagerRelationships(Pageable pageable) {
        return requirementRepository.findAllWithEagerRelationships(pageable).map(requirementMapper::toDto);
    }

    /**
     * Returns the number of requirements available.
     *
     * @return the number of entities in the database.
     */
    public Mono<Long> countAll() {
        return requirementRepository.count();
    }

    /**
     * Get one requirement by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    public Mono<RequirementDTO> findOne(String id) {
        LOG.debug("Request to get Requirement : {}", id);
        return requirementRepository.findOneWithEagerRelationships(id).map(requirementMapper::toDto);
    }

    /**
     * Get all requirements by project id (filters by requirement.project.id).
     *
     * @param projectId the project id to filter by.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    public Flux<RequirementDTO> findByProject(String projectId, Pageable pageable) {
        LOG.debug("Request to get Requirements by project id : {}", projectId);
        return requirementRepository.findByProjectId(projectId, pageable).map(requirementMapper::toDto);
    }

    /**
     * Returns the number of requirements available for a specific project.
     *
     * @param projectId the project id.
     * @return the count of entities.
     */
    public Mono<Long> countByProject(String projectId) {
        return requirementRepository.countByProjectId(projectId);
    }

    /**
     * Delete the requirement by id.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    public Mono<Void> delete(String id) {
        LOG.debug("Request to delete Requirement : {}", id);
        return requirementRepository.deleteById(id);
    }
}
