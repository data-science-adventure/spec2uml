import React, { useEffect } from 'react';
import { Button, Col, Row } from 'react-bootstrap';
import { TextFormat, Translate } from 'react-jhipster';
import { Link, useParams } from 'react-router';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './requirement.reducer';

export const RequirementDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id!));
  }, []);

  const requirementEntity = useAppSelector(state => state.requirement.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="requirementDetailsHeading">
          <Translate contentKey="spec2UmlApp.requirement.detail.title">Requirement</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{requirementEntity.id}</dd>
          <dt>
            <span id="sentId">
              <Translate contentKey="spec2UmlApp.requirement.sentId">Sent Id</Translate>
            </span>
          </dt>
          <dd>{requirementEntity.sentId}</dd>
          <dt>
            <span id="text">
              <Translate contentKey="spec2UmlApp.requirement.text">Text</Translate>
            </span>
          </dt>
          <dd>{requirementEntity.text}</dd>
          <dt>
            <span id="source">
              <Translate contentKey="spec2UmlApp.requirement.source">Source</Translate>
            </span>
          </dt>
          <dd>{requirementEntity.source}</dd>
          <dt>
            <span id="projectId">
              <Translate contentKey="spec2UmlApp.requirement.projectId">Project Id</Translate>
            </span>
          </dt>
          <dd>{requirementEntity.projectId}</dd>
          <dt>
            <span id="type">
              <Translate contentKey="spec2UmlApp.requirement.type">Type</Translate>
            </span>
          </dt>
          <dd>{requirementEntity.type}</dd>
          <dt>
            <span id="specLevel">
              <Translate contentKey="spec2UmlApp.requirement.specLevel">Spec Level</Translate>
            </span>
          </dt>
          <dd>{requirementEntity.specLevel}</dd>
          <dt>
            <span id="classDiagram">
              <Translate contentKey="spec2UmlApp.requirement.classDiagram">Class Diagram</Translate>
            </span>
          </dt>
          <dd>{requirementEntity.classDiagram}</dd>
          <dt>
            <span id="useCaseDiagram">
              <Translate contentKey="spec2UmlApp.requirement.useCaseDiagram">Use Case Diagram</Translate>
            </span>
          </dt>
          <dd>{requirementEntity.useCaseDiagram}</dd>
          <dt>
            <span id="status">
              <Translate contentKey="spec2UmlApp.requirement.status">Status</Translate>
            </span>
          </dt>
          <dd>{requirementEntity.status}</dd>
          <dt>
            <span id="createdAt">
              <Translate contentKey="spec2UmlApp.requirement.createdAt">Created At</Translate>
            </span>
          </dt>
          <dd>
            {requirementEntity.createdAt ? <TextFormat value={requirementEntity.createdAt} type="date" format={APP_DATE_FORMAT} /> : null}
          </dd>
          <dt>
            <span id="updatedAt">
              <Translate contentKey="spec2UmlApp.requirement.updatedAt">Updated At</Translate>
            </span>
          </dt>
          <dd>
            {requirementEntity.updatedAt ? <TextFormat value={requirementEntity.updatedAt} type="date" format={APP_DATE_FORMAT} /> : null}
          </dd>
          <dt>
            <Translate contentKey="spec2UmlApp.requirement.useCaseConcepts">Use Case Concepts</Translate>
          </dt>
          <dd>{requirementEntity.useCaseConcepts ? requirementEntity.useCaseConcepts.id : ''}</dd>
          <dt>
            <Translate contentKey="spec2UmlApp.requirement.classConcepts">Class Concepts</Translate>
          </dt>
          <dd>{requirementEntity.classConcepts ? requirementEntity.classConcepts.id : ''}</dd>
          <dt>
            <Translate contentKey="spec2UmlApp.requirement.project">Project</Translate>
          </dt>
          <dd>{requirementEntity.project ? requirementEntity.project.name : ''}</dd>
          <dt>
            <Translate contentKey="spec2UmlApp.requirement.annotators">Annotators</Translate>
          </dt>
          <dd>
            {requirementEntity.annotatorses
              ? requirementEntity.annotatorses.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.id}</a>
                    {requirementEntity.annotatorses && i === requirementEntity.annotatorses.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
        </dl>
        <Button as={Link as any} to="/requirement" replace variant="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button as={Link as any} to={`/requirement/${requirementEntity.id}/edit`} replace variant="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default RequirementDetail;
