package com.github.danimaniarqsoft.web.rest;

import static com.github.danimaniarqsoft.domain.RequirementAsserts.*;
import static com.github.danimaniarqsoft.web.rest.TestUtil.createUpdateProxyForBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.danimaniarqsoft.IntegrationTest;
import com.github.danimaniarqsoft.domain.Project;
import com.github.danimaniarqsoft.domain.Requirement;
import com.github.danimaniarqsoft.domain.enumeration.RequirementStatus;
import com.github.danimaniarqsoft.repository.RequirementRepository;
import com.github.danimaniarqsoft.service.RequirementService;
import com.github.danimaniarqsoft.service.dto.RequirementDTO;
import com.github.danimaniarqsoft.service.mapper.RequirementMapper;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webtestclient.autoconfigure.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

/**
 * Integration tests for the {@link RequirementResource} REST controller.
 */
@IntegrationTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureWebTestClient(timeout = IntegrationTest.DEFAULT_ENTITY_TIMEOUT)
@WithMockUser
class RequirementResourceIT {

    private static final Integer DEFAULT_SENT_ID = 1;
    private static final Integer UPDATED_SENT_ID = 2;

    private static final String DEFAULT_TEXT = "AAAAAAAAAA";
    private static final String UPDATED_TEXT = "BBBBBBBBBB";

    private static final String DEFAULT_SOURCE = "AAAAAAAAAA";
    private static final String UPDATED_SOURCE = "BBBBBBBBBB";

    private static final String DEFAULT_PROJECT_ID = "AAAAAAAAAA";
    private static final String UPDATED_PROJECT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_SPEC_LEVEL = "AAAAAAAAAA";
    private static final String UPDATED_SPEC_LEVEL = "BBBBBBBBBB";

    private static final String DEFAULT_CLASS_DIAGRAM = "AAAAAAAAAA";
    private static final String UPDATED_CLASS_DIAGRAM = "BBBBBBBBBB";

    private static final String DEFAULT_USE_CASE_DIAGRAM = "AAAAAAAAAA";
    private static final String UPDATED_USE_CASE_DIAGRAM = "BBBBBBBBBB";

    private static final RequirementStatus DEFAULT_STATUS = RequirementStatus.DRAFT;
    private static final RequirementStatus UPDATED_STATUS = RequirementStatus.IN_REVIEW;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.ofEpochMilli(1784742281462L);

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.ofEpochMilli(1784742281462L);

    private static final String ENTITY_API_URL = "/api/requirements";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private RequirementRepository requirementRepository;

    @Mock
    private RequirementRepository requirementRepositoryMock;

    @Autowired
    private RequirementMapper requirementMapper;

    @Mock
    private RequirementService requirementServiceMock;

    @Autowired
    private WebTestClient webTestClient;

    private Requirement requirement;

    private Requirement insertedRequirement;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Requirement createEntity() {
        Requirement requirement = new Requirement()
            .sentId(DEFAULT_SENT_ID)
            .text(DEFAULT_TEXT)
            .source(DEFAULT_SOURCE)
            .projectId(DEFAULT_PROJECT_ID)
            .type(DEFAULT_TYPE)
            .specLevel(DEFAULT_SPEC_LEVEL)
            .classDiagram(DEFAULT_CLASS_DIAGRAM)
            .useCaseDiagram(DEFAULT_USE_CASE_DIAGRAM)
            .status(DEFAULT_STATUS)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT);
        // Add required entity
        Project project;
        project = ProjectResourceIT.createEntity();
        project.setId("fixed-id-for-tests");
        requirement.setProject(project);
        return requirement;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Requirement createUpdatedEntity() {
        Requirement updatedRequirement = new Requirement()
            .sentId(UPDATED_SENT_ID)
            .text(UPDATED_TEXT)
            .source(UPDATED_SOURCE)
            .projectId(UPDATED_PROJECT_ID)
            .type(UPDATED_TYPE)
            .specLevel(UPDATED_SPEC_LEVEL)
            .classDiagram(UPDATED_CLASS_DIAGRAM)
            .useCaseDiagram(UPDATED_USE_CASE_DIAGRAM)
            .status(UPDATED_STATUS)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT);
        // Add required entity
        Project project;
        project = ProjectResourceIT.createUpdatedEntity();
        project.setId("fixed-id-for-tests");
        updatedRequirement.setProject(project);
        return updatedRequirement;
    }

    @BeforeEach
    void initTest() {
        requirement = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedRequirement != null) {
            requirementRepository.delete(insertedRequirement).block();
            insertedRequirement = null;
        }
    }

    @Test
    void createRequirement() throws Exception {
        long databaseSizeBeforeCreate = getRepositoryCount();
        // Create the Requirement
        RequirementDTO requirementDTO = requirementMapper.toDto(requirement);
        var returnedRequirementDTO = webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isCreated()
            .expectBody(RequirementDTO.class)
            .returnResult()
            .getResponseBody();

        // Validate the Requirement in the database
        assertIncrementedRepositoryCount(databaseSizeBeforeCreate);
        var returnedRequirement = requirementMapper.toEntity(returnedRequirementDTO);
        assertRequirementUpdatableFieldsEquals(returnedRequirement, getPersistedRequirement(returnedRequirement));

        insertedRequirement = returnedRequirement;
    }

    @Test
    void createRequirementWithExistingId() throws Exception {
        // Create the Requirement with an existing ID
        requirement.setId("existing_id");
        RequirementDTO requirementDTO = requirementMapper.toDto(requirement);

        long databaseSizeBeforeCreate = getRepositoryCount();

        // An entity with an existing ID cannot be created, so this API call must fail
        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Requirement in the database
        assertSameRepositoryCount(databaseSizeBeforeCreate);
    }

    @Test
    void checkSentIdIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        requirement.setSentId(null);

        // Create the Requirement, which fails.
        RequirementDTO requirementDTO = requirementMapper.toDto(requirement);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    void checkSourceIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        requirement.setSource(null);

        // Create the Requirement, which fails.
        RequirementDTO requirementDTO = requirementMapper.toDto(requirement);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    void checkProjectIdIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        requirement.setProjectId(null);

        // Create the Requirement, which fails.
        RequirementDTO requirementDTO = requirementMapper.toDto(requirement);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    void checkTypeIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        requirement.setType(null);

        // Create the Requirement, which fails.
        RequirementDTO requirementDTO = requirementMapper.toDto(requirement);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    void checkSpecLevelIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        requirement.setSpecLevel(null);

        // Create the Requirement, which fails.
        RequirementDTO requirementDTO = requirementMapper.toDto(requirement);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    void checkStatusIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        requirement.setStatus(null);

        // Create the Requirement, which fails.
        RequirementDTO requirementDTO = requirementMapper.toDto(requirement);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    void checkCreatedAtIsRequired() throws Exception {
        long databaseSizeBeforeTest = getRepositoryCount();
        // set the field null
        requirement.setCreatedAt(null);

        // Create the Requirement, which fails.
        RequirementDTO requirementDTO = requirementMapper.toDto(requirement);

        webTestClient
            .post()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        assertSameRepositoryCount(databaseSizeBeforeTest);
    }

    @Test
    void getAllRequirements() {
        // Initialize the database
        insertedRequirement = requirementRepository.save(requirement).block();

        // Get all the requirementList
        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?sort=id,desc")
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.[*].id")
            .value(hasItem(requirement.getId()))
            .jsonPath("$.[*].sentId")
            .value(hasItem(DEFAULT_SENT_ID))
            .jsonPath("$.[*].text")
            .value(hasItem(DEFAULT_TEXT))
            .jsonPath("$.[*].source")
            .value(hasItem(DEFAULT_SOURCE))
            .jsonPath("$.[*].projectId")
            .value(hasItem(DEFAULT_PROJECT_ID))
            .jsonPath("$.[*].type")
            .value(hasItem(DEFAULT_TYPE))
            .jsonPath("$.[*].specLevel")
            .value(hasItem(DEFAULT_SPEC_LEVEL))
            .jsonPath("$.[*].classDiagram")
            .value(hasItem(DEFAULT_CLASS_DIAGRAM))
            .jsonPath("$.[*].useCaseDiagram")
            .value(hasItem(DEFAULT_USE_CASE_DIAGRAM))
            .jsonPath("$.[*].status")
            .value(hasItem(DEFAULT_STATUS.toString()))
            .jsonPath("$.[*].createdAt")
            .value(hasItem(DEFAULT_CREATED_AT.toString()))
            .jsonPath("$.[*].updatedAt")
            .value(hasItem(DEFAULT_UPDATED_AT.toString()));
    }

    @SuppressWarnings({ "unchecked" })
    void getAllRequirementsWithEagerRelationshipsIsEnabled() {
        when(requirementServiceMock.findAllWithEagerRelationships(any())).thenReturn(Flux.empty());

        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?eagerload=true")
            .exchange()
            .expectStatus()
            .isOk();

        verify(requirementServiceMock, times(1)).findAllWithEagerRelationships(any());
    }

    @SuppressWarnings({ "unchecked" })
    void getAllRequirementsWithEagerRelationshipsIsNotEnabled() {
        when(requirementServiceMock.findAllWithEagerRelationships(any())).thenReturn(Flux.empty());

        webTestClient
            .get()
            .uri(ENTITY_API_URL + "?eagerload=false")
            .exchange()
            .expectStatus()
            .isOk();
        verify(requirementRepositoryMock, times(1)).findAllWithEagerRelationships(any());
    }

    @Test
    void getRequirement() {
        // Initialize the database
        insertedRequirement = requirementRepository.save(requirement).block();

        // Get the requirement
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, requirement.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isOk()
            .expectHeader()
            .contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id")
            .value(is(requirement.getId()))
            .jsonPath("$.sentId")
            .value(is(DEFAULT_SENT_ID))
            .jsonPath("$.text")
            .value(is(DEFAULT_TEXT))
            .jsonPath("$.source")
            .value(is(DEFAULT_SOURCE))
            .jsonPath("$.projectId")
            .value(is(DEFAULT_PROJECT_ID))
            .jsonPath("$.type")
            .value(is(DEFAULT_TYPE))
            .jsonPath("$.specLevel")
            .value(is(DEFAULT_SPEC_LEVEL))
            .jsonPath("$.classDiagram")
            .value(is(DEFAULT_CLASS_DIAGRAM))
            .jsonPath("$.useCaseDiagram")
            .value(is(DEFAULT_USE_CASE_DIAGRAM))
            .jsonPath("$.status")
            .value(is(DEFAULT_STATUS.toString()))
            .jsonPath("$.createdAt")
            .value(is(DEFAULT_CREATED_AT.toString()))
            .jsonPath("$.updatedAt")
            .value(is(DEFAULT_UPDATED_AT.toString()));
    }

    @Test
    void getNonExistingRequirement() {
        // Get the requirement
        webTestClient
            .get()
            .uri(ENTITY_API_URL_ID, Long.MAX_VALUE)
            .accept(MediaType.APPLICATION_PROBLEM_JSON)
            .exchange()
            .expectStatus()
            .isNotFound();
    }

    @Test
    void putExistingRequirement() throws Exception {
        // Initialize the database
        insertedRequirement = requirementRepository.save(requirement).block();

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the requirement
        Requirement updatedRequirement = requirementRepository.findById(requirement.getId()).block();
        updatedRequirement
            .sentId(UPDATED_SENT_ID)
            .text(UPDATED_TEXT)
            .source(UPDATED_SOURCE)
            .projectId(UPDATED_PROJECT_ID)
            .type(UPDATED_TYPE)
            .specLevel(UPDATED_SPEC_LEVEL)
            .classDiagram(UPDATED_CLASS_DIAGRAM)
            .useCaseDiagram(UPDATED_USE_CASE_DIAGRAM)
            .status(UPDATED_STATUS)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT);
        RequirementDTO requirementDTO = requirementMapper.toDto(updatedRequirement);

        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, requirementDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Requirement in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertPersistedRequirementToMatchAllProperties(updatedRequirement);
    }

    @Test
    void putNonExistingRequirement() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        requirement.setId(UUID.randomUUID().toString());

        // Create the Requirement
        RequirementDTO requirementDTO = requirementMapper.toDto(requirement);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, requirementDTO.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Requirement in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithIdMismatchRequirement() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        requirement.setId(UUID.randomUUID().toString());

        // Create the Requirement
        RequirementDTO requirementDTO = requirementMapper.toDto(requirement);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL_ID, UUID.randomUUID().toString())
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Requirement in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    void putWithMissingIdPathParamRequirement() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        requirement.setId(UUID.randomUUID().toString());

        // Create the Requirement
        RequirementDTO requirementDTO = requirementMapper.toDto(requirement);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .put()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the Requirement in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    void partialUpdateRequirementWithPatch() throws Exception {
        // Initialize the database
        insertedRequirement = requirementRepository.save(requirement).block();

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the requirement using partial update
        Requirement partialUpdatedRequirement = new Requirement();
        partialUpdatedRequirement.setId(requirement.getId());

        partialUpdatedRequirement
            .sentId(UPDATED_SENT_ID)
            .text(UPDATED_TEXT)
            .projectId(UPDATED_PROJECT_ID)
            .type(UPDATED_TYPE)
            .specLevel(UPDATED_SPEC_LEVEL)
            .classDiagram(UPDATED_CLASS_DIAGRAM);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedRequirement.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(om.writeValueAsBytes(partialUpdatedRequirement))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Requirement in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertRequirementUpdatableFieldsEquals(
            createUpdateProxyForBean(partialUpdatedRequirement, requirement),
            getPersistedRequirement(requirement)
        );
    }

    @Test
    void fullUpdateRequirementWithPatch() throws Exception {
        // Initialize the database
        insertedRequirement = requirementRepository.save(requirement).block();

        long databaseSizeBeforeUpdate = getRepositoryCount();

        // Update the requirement using partial update
        Requirement partialUpdatedRequirement = new Requirement();
        partialUpdatedRequirement.setId(requirement.getId());

        partialUpdatedRequirement
            .sentId(UPDATED_SENT_ID)
            .text(UPDATED_TEXT)
            .source(UPDATED_SOURCE)
            .projectId(UPDATED_PROJECT_ID)
            .type(UPDATED_TYPE)
            .specLevel(UPDATED_SPEC_LEVEL)
            .classDiagram(UPDATED_CLASS_DIAGRAM)
            .useCaseDiagram(UPDATED_USE_CASE_DIAGRAM)
            .status(UPDATED_STATUS)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT);

        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, partialUpdatedRequirement.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(om.writeValueAsBytes(partialUpdatedRequirement))
            .exchange()
            .expectStatus()
            .isOk();

        // Validate the Requirement in the database

        assertSameRepositoryCount(databaseSizeBeforeUpdate);
        assertRequirementUpdatableFieldsEquals(partialUpdatedRequirement, getPersistedRequirement(partialUpdatedRequirement));
    }

    @Test
    void patchNonExistingRequirement() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        requirement.setId(UUID.randomUUID().toString());

        // Create the Requirement
        RequirementDTO requirementDTO = requirementMapper.toDto(requirement);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, requirementDTO.getId())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Requirement in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithIdMismatchRequirement() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        requirement.setId(UUID.randomUUID().toString());

        // Create the Requirement
        RequirementDTO requirementDTO = requirementMapper.toDto(requirement);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL_ID, UUID.randomUUID().toString())
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isBadRequest();

        // Validate the Requirement in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    void patchWithMissingIdPathParamRequirement() throws Exception {
        long databaseSizeBeforeUpdate = getRepositoryCount();
        requirement.setId(UUID.randomUUID().toString());

        // Create the Requirement
        RequirementDTO requirementDTO = requirementMapper.toDto(requirement);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        webTestClient
            .patch()
            .uri(ENTITY_API_URL)
            .contentType(MediaType.valueOf("application/merge-patch+json"))
            .bodyValue(om.writeValueAsBytes(requirementDTO))
            .exchange()
            .expectStatus()
            .isEqualTo(405);

        // Validate the Requirement in the database
        assertSameRepositoryCount(databaseSizeBeforeUpdate);
    }

    @Test
    void deleteRequirement() {
        // Initialize the database
        insertedRequirement = requirementRepository.save(requirement).block();

        long databaseSizeBeforeDelete = getRepositoryCount();

        // Delete the requirement
        webTestClient
            .delete()
            .uri(ENTITY_API_URL_ID, requirement.getId())
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus()
            .isNoContent();

        // Validate the database contains one less item
        assertDecrementedRepositoryCount(databaseSizeBeforeDelete);
    }

    protected long getRepositoryCount() {
        return requirementRepository.count().block();
    }

    protected void assertIncrementedRepositoryCount(long countBefore) {
        assertThat(countBefore + 1).isEqualTo(getRepositoryCount());
    }

    protected void assertDecrementedRepositoryCount(long countBefore) {
        assertThat(countBefore - 1).isEqualTo(getRepositoryCount());
    }

    protected void assertSameRepositoryCount(long countBefore) {
        assertThat(countBefore).isEqualTo(getRepositoryCount());
    }

    protected Requirement getPersistedRequirement(Requirement requirement) {
        return requirementRepository.findById(requirement.getId()).block();
    }

    protected void assertPersistedRequirementToMatchAllProperties(Requirement expectedRequirement) {
        assertRequirementAllPropertiesEquals(expectedRequirement, getPersistedRequirement(expectedRequirement));
    }

    protected void assertPersistedRequirementToMatchUpdatableProperties(Requirement expectedRequirement) {
        assertRequirementAllUpdatablePropertiesEquals(expectedRequirement, getPersistedRequirement(expectedRequirement));
    }
}
