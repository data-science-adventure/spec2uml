import React, { useEffect, useState } from 'react';
import { Button, Card, Col, Modal, ModalBody, ModalFooter, ModalHeader, Row, Table } from 'react-bootstrap';
import { JhiItemCount, JhiPagination, TextFormat, Translate } from 'react-jhipster';
import { Link, useParams } from 'react-router';
import Editor from '@monaco-editor/react';
import plantumlEncoder from 'plantuml-encoder';

import { faCheck, faCopy, faEdit, faSort, faSortDown, faSortUp, faSync } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';
import { getEntitiesByProject } from 'app/entities/requirement/requirement.reducer';
import { IRequirement } from 'app/shared/model/requirement.model';
import { ASC, DESC, ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

import { getEntity } from './project.reducer';

/**
 * Safely encodes PlantUML markup into an image URL.
 * Extracted outside the component to keep React render logic clean and pure.
 */
const getPlantUmlUrl = (code: string): string | null => {
  try {
    const encoded = plantumlEncoder.encode(code);
    return `https://www.plantuml.com/plantuml/png/${encoded}`;
  } catch {
    return null;
  }
};

/**
 * PlantUMLPreview Component
 * Encodes PlantUML text into a URL and renders the resulting PNG diagram from PlantUML server.
 */
const PlantUMLPreview: React.FC<{ code: string }> = ({ code }) => {
  if (!code || !code.trim()) {
    return (
      <div className="d-flex align-items-center justify-content-center h-100 bg-light border rounded text-muted p-3">
        <em>No diagram code provided</em>
      </div>
    );
  }

  const imageUrl = getPlantUmlUrl(code);

  if (!imageUrl) {
    return (
      <div className="d-flex align-items-center justify-content-center h-100 bg-light border rounded text-danger p-3">
        <em>Error encoding PlantUML diagram syntax</em>
      </div>
    );
  }

  return (
    <div className="border rounded bg-white p-2 text-center overflow-auto" style={{ maxHeight: '200px', minHeight: '200px' }}>
      <img src={imageUrl} alt="PlantUML Diagram" className="img-fluid" />
    </div>
  );
};

export const ProjectDetail = () => {
  const dispatch = useAppDispatch();
  const { id } = useParams<'id'>();

  // State
  const [copied, setCopied] = useState(false);

  // State for Annotate Modal
  const [showAnnotateModal, setShowAnnotateModal] = useState(false);
  const [selectedRequirement, setSelectedRequirement] = useState<IRequirement | null>(null);

  // State for editable diagram fields
  const [annotateFormState, setAnnotateFormState] = useState({
    classDiagram: '',
    useCaseDiagram: '',
  });

  const [paginationState, setPaginationState] = useState({
    activePage: 1,
    itemsPerPage: ITEMS_PER_PAGE,
    sort: 'id',
    order: ASC,
  });

  // Selectors
  const projectEntity = useAppSelector(state => state.project.entity);
  const account = useAppSelector(state => state.authentication.account);
  const requirementList = useAppSelector(state => state.requirement.entities);
  const totalItems = useAppSelector(state => state.requirement.totalItems);
  const loadingRequirements = useAppSelector(state => state.requirement.loading);

  useEffect(() => {
    if (id) {
      dispatch(getEntity(id));
      loadProjectRequirements();
    }
  }, [id, paginationState.activePage, paginationState.sort, paginationState.order]);

  const loadProjectRequirements = () => {
    if (id) {
      dispatch(
        getEntitiesByProject({
          projectId: id,
          page: paginationState.activePage - 1,
          size: paginationState.itemsPerPage,
          sort: `${paginationState.sort},${paginationState.order}`,
        }),
      );
    }
  };

  const handleRefresh = () => {
    loadProjectRequirements();
  };

  const copyToClipboard = () => {
    if (projectEntity?.id) {
      navigator.clipboard.writeText(projectEntity.id);
      setCopied(true);
      setTimeout(() => setCopied(false), 2000);
    }
  };

  const isOwner = () => {
    if (!account || !projectEntity?.createdBy) return false;
    const creatorLogin = projectEntity.createdBy.login || projectEntity.createdBy.id;
    return creatorLogin === account.login;
  };

  // Annotate Modal Handlers
  const handleOpenAnnotateModal = (requirement: IRequirement) => {
    setSelectedRequirement(requirement);
    setAnnotateFormState({
      classDiagram: requirement.classDiagram || '',
      useCaseDiagram: requirement.useCaseDiagram || '',
    });
    setShowAnnotateModal(true);
  };

  const handleCloseAnnotateModal = () => {
    setSelectedRequirement(null);
    setShowAnnotateModal(false);
  };

  const handleClassDiagramChange = (value: string | undefined) => {
    setAnnotateFormState(prevState => ({
      ...prevState,
      classDiagram: value || '',
    }));
  };

  const handleUseCaseDiagramChange = (value: string | undefined) => {
    setAnnotateFormState(prevState => ({
      ...prevState,
      useCaseDiagram: value || '',
    }));
  };

  const handlePagination = currentPage => {
    setPaginationState({
      ...paginationState,
      activePage: currentPage,
    });
  };

  const sort = p => () => {
    setPaginationState({
      ...paginationState,
      order: paginationState.order === ASC ? DESC : ASC,
      sort: p,
    });
  };

  const getSortIconByFieldName = (fieldName: string) => {
    if (paginationState.sort !== fieldName) return faSort;
    return paginationState.order === ASC ? faSortUp : faSortDown;
  };

  return (
    <Row>
      <Col md="12">
        <h2 data-cy="projectDetailsHeading" className="mb-4">
          <Translate contentKey="spec2UmlApp.project.detail.title">Project</Translate>
        </h2>

        {/* Project Info displayed horizontally using Bootstrap Grid */}
        <Card className="mb-4 shadow-sm">
          <Card.Body>
            <Row className="g-3">
              <Col md={3} sm={6}>
                <strong>
                  <Translate contentKey="global.field.id">ID</Translate>:
                </strong>
                <div className="d-flex align-items-center mt-1">
                  <span className="text-truncate">{projectEntity.id}</span>
                  {projectEntity.id && (
                    <Button
                      variant="outline-secondary"
                      size="sm"
                      className="ms-2 py-0 px-2"
                      onClick={copyToClipboard}
                      title="Copy ID to clipboard"
                    >
                      <FontAwesomeIcon icon={copied ? faCheck : faCopy} />
                    </Button>
                  )}
                </div>
              </Col>
              <Col md={3} sm={6}>
                <strong>
                  <Translate contentKey="spec2UmlApp.project.name">Name</Translate>:
                </strong>
                <div className="mt-1">{projectEntity.name}</div>
              </Col>
              <Col md={3} sm={6}>
                <strong>
                  <Translate contentKey="spec2UmlApp.project.description">Description</Translate>:
                </strong>
                <div className="mt-1">{projectEntity.description}</div>
              </Col>
              <Col md={3} sm={6}>
                <strong>
                  <Translate contentKey="spec2UmlApp.project.language">Language</Translate>:
                </strong>
                <div className="mt-1">{projectEntity.language}</div>
              </Col>
              <Col md={3} sm={6}>
                <strong>
                  <Translate contentKey="spec2UmlApp.project.umlVersion">Uml Version</Translate>:
                </strong>
                <div className="mt-1">{projectEntity.umlVersion}</div>
              </Col>
              <Col md={3} sm={6}>
                <strong>
                  <Translate contentKey="spec2UmlApp.project.createdAt">Created At</Translate>:
                </strong>
                <div className="mt-1">
                  {projectEntity.createdAt ? <TextFormat value={projectEntity.createdAt} type="date" format={APP_DATE_FORMAT} /> : null}
                </div>
              </Col>
              <Col md={3} sm={6}>
                <strong>
                  <Translate contentKey="spec2UmlApp.project.updatedAt">Updated At</Translate>:
                </strong>
                <div className="mt-1">
                  {projectEntity.updatedAt ? <TextFormat value={projectEntity.updatedAt} type="date" format={APP_DATE_FORMAT} /> : null}
                </div>
              </Col>
              <Col md={3} sm={6}>
                <strong>
                  <Translate contentKey="spec2UmlApp.project.createdBy">Created By</Translate>:
                </strong>
                <div className="mt-1">{projectEntity.createdBy ? projectEntity.createdBy.login || projectEntity.createdBy.id : ''}</div>
              </Col>
            </Row>
          </Card.Body>
        </Card>

        <div className="mb-4">
          <Button as={Link as any} to="/project" replace variant="info" data-cy="entityDetailsBackButton">
            <FontAwesomeIcon icon="arrow-left" />{' '}
            <span className="d-none d-md-inline">
              <Translate contentKey="entity.action.back">Back</Translate>
            </span>
          </Button>
          &nbsp;
          {isOwner() && (
            <Button as={Link as any} to={`/project/${projectEntity.id}/edit`} replace variant="primary">
              <FontAwesomeIcon icon="pencil-alt" />{' '}
              <span className="d-none d-md-inline">
                <Translate contentKey="entity.action.edit">Edit</Translate>
              </span>
            </Button>
          )}
        </div>

        <hr className="my-4" />

        {/* Requirements Header Section */}
        <div className="d-flex justify-content-between align-items-center mb-3">
          <h3>
            <Translate contentKey="spec2UmlApp.requirement.home.title">Requirements</Translate>
          </h3>
          <div className="d-flex gap-2">
            <Button variant="info" onClick={handleRefresh} disabled={loadingRequirements}>
              <FontAwesomeIcon icon={faSync} spin={loadingRequirements} />{' '}
              <Translate contentKey="spec2UmlApp.requirement.home.refreshListLabel">Refresh List</Translate>
            </Button>
          </div>
        </div>

        {/* Requirements Table showing only sentId, text, status, and Annotate button */}
        <div className="table-responsive">
          {requirementList && requirementList.length > 0 ? (
            <Table responsive striped>
              <thead>
                <tr>
                  <th className="hand" onClick={sort('sentId')}>
                    <Translate contentKey="spec2UmlApp.requirement.sentId">Sent Id</Translate>{' '}
                    <FontAwesomeIcon icon={getSortIconByFieldName('sentId')} />
                  </th>
                  <th className="hand" onClick={sort('text')}>
                    <Translate contentKey="spec2UmlApp.requirement.text">Text</Translate>{' '}
                    <FontAwesomeIcon icon={getSortIconByFieldName('text')} />
                  </th>
                  <th className="hand" onClick={sort('status')}>
                    <Translate contentKey="spec2UmlApp.requirement.status">Status</Translate>{' '}
                    <FontAwesomeIcon icon={getSortIconByFieldName('status')} />
                  </th>
                  <th className="text-end">Actions</th>
                </tr>
              </thead>
              <tbody>
                {requirementList.map(requirement => (
                  <tr key={`entity-${requirement.id}`}>
                    <td>{requirement.sentId}</td>
                    <td>{requirement.text}</td>
                    <td>{requirement.status || 'N/A'}</td>
                    <td className="text-end">
                      <Button variant="warning" size="sm" onClick={() => handleOpenAnnotateModal(requirement)}>
                        <FontAwesomeIcon icon={faEdit} /> <span className="d-none d-md-inline">Annotate</span>
                      </Button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
          ) : (
            !loadingRequirements && (
              <div className="alert alert-warning">
                <Translate contentKey="spec2UmlApp.requirement.home.notFound">No Requirements found</Translate>
              </div>
            )
          )}
        </div>

        {totalItems > 0 && (
          <div>
            <div className="justify-content-center d-flex">
              <JhiItemCount page={paginationState.activePage} total={totalItems} itemsPerPage={paginationState.itemsPerPage} i18nEnabled />
            </div>
            <div className="justify-content-center d-flex">
              <JhiPagination
                activePage={paginationState.activePage}
                onSelect={handlePagination}
                maxButtons={5}
                itemsPerPage={paginationState.itemsPerPage}
                totalItems={totalItems}
              />
            </div>
          </div>
        )}

        {/* Centered Modal Popup for Requirement Annotation View/Edit with Side-by-Side Editors & Previews */}
        <Modal show={showAnnotateModal} onHide={handleCloseAnnotateModal} size="xl" centered>
          <ModalHeader closeButton closeVariant="white" className="bg-primary text-white">
            <Modal.Title className="text-white fs-5">Requirement Annotation - Sent ID #{selectedRequirement?.sentId}</Modal.Title>
          </ModalHeader>
          <ModalBody>
            {selectedRequirement && (
              <div>
                <div className="mb-4">
                  <label className="fw-bold form-label">Requirement Text:</label>
                  <textarea className="form-control bg-light" rows={2} value={selectedRequirement.text || ''} readOnly />
                </div>

                {/* Class Diagram Section */}
                <div className="mb-4">
                  <h6 className="fw-bold">Class Diagram</h6>
                  <Row>
                    <Col md={6}>
                      <label className="form-label text-muted small">PlantUML Code:</label>
                      <div className="border rounded overflow-hidden">
                        <Editor
                          height="200px"
                          defaultLanguage="apex"
                          theme="vs-light"
                          value={annotateFormState.classDiagram}
                          onChange={handleClassDiagramChange}
                          options={{
                            minimap: { enabled: false },
                            scrollBeyondLastLine: false,
                            fontSize: 13,
                          }}
                        />
                      </div>
                    </Col>
                    <Col md={6}>
                      <label className="form-label text-muted small">Diagram Preview:</label>
                      <PlantUMLPreview code={annotateFormState.classDiagram} />
                    </Col>
                  </Row>
                </div>

                {/* Use Case Diagram Section */}
                <div className="mb-3">
                  <h6 className="fw-bold">Use Case Diagram</h6>
                  <Row>
                    <Col md={6}>
                      <label className="form-label text-muted small">PlantUML Code:</label>
                      <div className="border rounded overflow-hidden">
                        <Editor
                          height="200px"
                          defaultLanguage="apex"
                          theme="vs-light"
                          value={annotateFormState.useCaseDiagram}
                          onChange={handleUseCaseDiagramChange}
                          options={{
                            minimap: { enabled: false },
                            scrollBeyondLastLine: false,
                            fontSize: 13,
                          }}
                        />
                      </div>
                    </Col>
                    <Col md={6}>
                      <label className="form-label text-muted small">Diagram Preview:</label>
                      <PlantUMLPreview code={annotateFormState.useCaseDiagram} />
                    </Col>
                  </Row>
                </div>
              </div>
            )}
          </ModalBody>
          <ModalFooter>
            <Button variant="secondary" onClick={handleCloseAnnotateModal}>
              Cancel
            </Button>
          </ModalFooter>
        </Modal>
      </Col>
    </Row>
  );
};

export default ProjectDetail;
