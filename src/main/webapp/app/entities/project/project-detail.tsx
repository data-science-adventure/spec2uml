import React, { useEffect, useState } from 'react';
import { Button, Col, Modal, ModalBody, ModalFooter, ModalHeader, Row, Table } from 'react-bootstrap';
import { JhiItemCount, JhiPagination, TextFormat, Translate, ValidatedField, ValidatedForm, isNumber, translate } from 'react-jhipster';
import { Link, useParams } from 'react-router';

import { faCheck, faCopy, faPlus, faSort, faSortDown, faSortUp, faSync } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';
import { createEntity, getEntitiesByProject } from 'app/entities/requirement/requirement.reducer';
import { ASC, DESC, ITEMS_PER_PAGE } from 'app/shared/util/pagination.constants';

import { getEntity } from './project.reducer';

export const ProjectDetail = () => {
  const dispatch = useAppDispatch();
  const { id } = useParams<'id'>();

  // State
  const [copied, setCopied] = useState(false);
  const [showModal, setShowModal] = useState(false);
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
  const updatingRequirement = useAppSelector(state => state.requirement.updating);
  const updateSuccess = useAppSelector(state => state.requirement.updateSuccess);

  useEffect(() => {
    if (id) {
      dispatch(getEntity(id));
      loadProjectRequirements();
    }
  }, [id, paginationState.activePage, paginationState.sort, paginationState.order]);

  useEffect(() => {
    if (updateSuccess && showModal) {
      setShowModal(false);
      loadProjectRequirements();
    }
  }, [updateSuccess]);

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

  const handleOpenModal = () => setShowModal(true);
  const handleCloseModal = () => setShowModal(false);

  const saveRequirement = values => {
    if (values.sentId !== undefined && typeof values.sentId !== 'number') {
      values.sentId = Number(values.sentId);
    }

    const entity = {
      ...values,
      project: { id: projectEntity.id, name: projectEntity.name },
    };

    dispatch(createEntity(entity));
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
        <h2 data-cy="projectDetailsHeading">
          <Translate contentKey="spec2UmlApp.project.detail.title">Project</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>
            <span>{projectEntity.id}</span>
            {projectEntity.id && (
              <Button
                variant="outline-secondary"
                size="sm"
                className="ms-2 py-0 px-2"
                onClick={copyToClipboard}
                title="Copy ID to clipboard"
              >
                <FontAwesomeIcon icon={copied ? faCheck : faCopy} />
                <span className="ms-1 d-none d-md-inline">{copied ? 'Copied!' : 'Copy'}</span>
              </Button>
            )}
          </dd>
          <dt>
            <span id="name">
              <Translate contentKey="spec2UmlApp.project.name">Name</Translate>
            </span>
          </dt>
          <dd>{projectEntity.name}</dd>
          <dt>
            <span id="description">
              <Translate contentKey="spec2UmlApp.project.description">Description</Translate>
            </span>
          </dt>
          <dd>{projectEntity.description}</dd>
          <dt>
            <span id="language">
              <Translate contentKey="spec2UmlApp.project.language">Language</Translate>
            </span>
          </dt>
          <dd>{projectEntity.language}</dd>
          <dt>
            <span id="umlVersion">
              <Translate contentKey="spec2UmlApp.project.umlVersion">Uml Version</Translate>
            </span>
          </dt>
          <dd>{projectEntity.umlVersion}</dd>
          <dt>
            <span id="createdAt">
              <Translate contentKey="spec2UmlApp.project.createdAt">Created At</Translate>
            </span>
          </dt>
          <dd>{projectEntity.createdAt ? <TextFormat value={projectEntity.createdAt} type="date" format={APP_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="updatedAt">
              <Translate contentKey="spec2UmlApp.project.updatedAt">Updated At</Translate>
            </span>
          </dt>
          <dd>{projectEntity.updatedAt ? <TextFormat value={projectEntity.updatedAt} type="date" format={APP_DATE_FORMAT} /> : null}</dd>
          <dt>
            <Translate contentKey="spec2UmlApp.project.createdBy">Created By</Translate>
          </dt>
          <dd>{projectEntity.createdBy ? projectEntity.createdBy.login || projectEntity.createdBy.id : ''}</dd>
        </dl>
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
        <hr className="my-4" />
        {/* Requirements Section */}
        <div className="d-flex justify-content-between align-items-center mb-3">
          <h3>
            <Translate contentKey="spec2UmlApp.requirement.home.title">Requirements</Translate>
          </h3>
          <div className="d-flex gap-2">
            <Button variant="info" onClick={handleRefresh} disabled={loadingRequirements}>
              <FontAwesomeIcon icon={faSync} spin={loadingRequirements} />{' '}
              <Translate contentKey="spec2UmlApp.requirement.home.refreshListLabel">Refresh List</Translate>
            </Button>
            {isOwner() && (
              <Button variant="primary" onClick={handleOpenModal} id="jh-create-entity">
                <FontAwesomeIcon icon={faPlus} />
                &nbsp;
                <Translate contentKey="spec2UmlApp.requirement.home.createLabel">Create new Requirement</Translate>
              </Button>
            )}
          </div>
        </div>
        <div className="table-responsive">
          {requirementList && requirementList.length > 0 ? (
            <Table responsive striped>
              <thead>
                <tr>
                  <th className="hand" onClick={sort('id')}>
                    <Translate contentKey="spec2UmlApp.requirement.id">ID</Translate>{' '}
                    <FontAwesomeIcon icon={getSortIconByFieldName('id')} />
                  </th>
                  <th className="hand" onClick={sort('sentId')}>
                    <Translate contentKey="spec2UmlApp.requirement.sentId">Sent Id</Translate>{' '}
                    <FontAwesomeIcon icon={getSortIconByFieldName('sentId')} />
                  </th>
                  <th className="hand" onClick={sort('text')}>
                    <Translate contentKey="spec2UmlApp.requirement.text">Text</Translate>{' '}
                    <FontAwesomeIcon icon={getSortIconByFieldName('text')} />
                  </th>
                  <th className="hand" onClick={sort('source')}>
                    <Translate contentKey="spec2UmlApp.requirement.source">Source</Translate>{' '}
                    <FontAwesomeIcon icon={getSortIconByFieldName('source')} />
                  </th>
                  <th className="hand" onClick={sort('projectId')}>
                    <Translate contentKey="spec2UmlApp.requirement.projectId">Project Id</Translate>{' '}
                    <FontAwesomeIcon icon={getSortIconByFieldName('projectId')} />
                  </th>
                  <th className="hand" onClick={sort('type')}>
                    <Translate contentKey="spec2UmlApp.requirement.type">Type</Translate>{' '}
                    <FontAwesomeIcon icon={getSortIconByFieldName('type')} />
                  </th>
                  <th className="hand" onClick={sort('specLevel')}>
                    <Translate contentKey="spec2UmlApp.requirement.specLevel">Spec Level</Translate>{' '}
                    <FontAwesomeIcon icon={getSortIconByFieldName('specLevel')} />
                  </th>
                  <th />
                </tr>
              </thead>
              <tbody>
                {requirementList.map(requirement => (
                  <tr key={`entity-${requirement.id}`}>
                    <td>
                      <Button as={Link as any} to={`/requirement/${requirement.id}`} variant="link" size="sm">
                        {requirement.id}
                      </Button>
                    </td>
                    <td>{requirement.sentId}</td>
                    <td>{requirement.text}</td>
                    <td>{requirement.source}</td>
                    <td>{requirement.projectId}</td>
                    <td>{requirement.type}</td>
                    <td>{requirement.specLevel}</td>
                    <td className="text-end">
                      <Button as={Link as any} to={`/requirement/${requirement.id}`} variant="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
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
        {/* Modal for Creating New Requirement */}
        <Modal show={showModal} onHide={handleCloseModal} size="lg">
          <ValidatedForm onSubmit={saveRequirement}>
            <ModalHeader closeButton>
              <Translate contentKey="spec2UmlApp.requirement.home.createOrEditLabel">Create or edit a Requirement</Translate>
            </ModalHeader>
            <ModalBody>
              <ValidatedField
                label={translate('spec2UmlApp.requirement.sentId')}
                id="requirement-sentId"
                name="sentId"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                  validate: v => isNumber(v) || translate('entity.validation.number'),
                }}
              />
              <ValidatedField
                label={translate('spec2UmlApp.requirement.text')}
                id="requirement-text"
                name="text"
                type="textarea"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('spec2UmlApp.requirement.source')}
                id="requirement-source"
                name="source"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('spec2UmlApp.requirement.projectId')}
                id="requirement-projectId"
                name="projectId"
                type="text"
                defaultValue={projectEntity?.id || ''}
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('spec2UmlApp.requirement.type')}
                id="requirement-type"
                name="type"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('spec2UmlApp.requirement.specLevel')}
                id="requirement-specLevel"
                name="specLevel"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('spec2UmlApp.requirement.classDiagram')}
                id="requirement-classDiagram"
                name="classDiagram"
                type="textarea"
              />
              <ValidatedField
                label={translate('spec2UmlApp.requirement.useCaseDiagram')}
                id="requirement-useCaseDiagram"
                name="useCaseDiagram"
                type="textarea"
              />
            </ModalBody>
            <ModalFooter>
              <Button variant="secondary" onClick={handleCloseModal}>
                <Translate contentKey="entity.action.cancel">Cancel</Translate>
              </Button>
              <Button variant="primary" type="submit" disabled={updatingRequirement}>
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ModalFooter>
          </ValidatedForm>
        </Modal>
      </Col>
    </Row>
  );
};

export default ProjectDetail;
