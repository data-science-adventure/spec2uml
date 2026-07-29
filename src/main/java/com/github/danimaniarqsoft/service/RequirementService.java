package com.github.danimaniarqsoft.service;

import com.github.danimaniarqsoft.repository.RequirementRepository;
import com.github.danimaniarqsoft.service.dto.RequirementDTO;
import com.github.danimaniarqsoft.service.mapper.RequirementMapper;
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

    private final RequirementMapper requirementMapper;

    public RequirementService(RequirementRepository requirementRepository, RequirementMapper requirementMapper) {
        this.requirementRepository = requirementRepository;
        this.requirementMapper = requirementMapper;
    }

    /**
     * Save a requirement.
     *
     * @param requirementDTO the entity to save.
     * @return the persisted entity.
     */
    public Mono<RequirementDTO> save(RequirementDTO requirementDTO) {
        LOG.debug("Request to save Requirement : {}", requirementDTO);
        return requirementRepository.save(requirementMapper.toEntity(requirementDTO)).map(requirementMapper::toDto);
    }

    /**
     * Update a requirement.
     *
     * @param requirementDTO the entity to save.
     * @return the persisted entity.
     */
    public Mono<RequirementDTO> update(RequirementDTO requirementDTO) {
        LOG.debug("Request to update Requirement : {}", requirementDTO);
        return requirementRepository.save(requirementMapper.toEntity(requirementDTO)).map(requirementMapper::toDto);
    }

    /**
     * Partially update a requirement.
     *
     * @param requirementDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Mono<RequirementDTO> partialUpdate(RequirementDTO requirementDTO) {
        LOG.debug("Request to partially update Requirement : {}", requirementDTO);

        return requirementRepository
            .findById(requirementDTO.getId())
            .map(existingRequirement -> {
                requirementMapper.partialUpdate(existingRequirement, requirementDTO);

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
     * @return the number of entities in the database.
     *
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
