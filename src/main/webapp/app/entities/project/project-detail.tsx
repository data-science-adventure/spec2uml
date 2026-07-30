import React, { useEffect, useState } from 'react';
import { Button, Col, Row } from 'react-bootstrap';
import { TextFormat, Translate } from 'react-jhipster';
import { Link, useParams } from 'react-router';

import { faCopy, faCheck } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './project.reducer';

export const ProjectDetail = () => {
  const dispatch = useAppDispatch();
  const [copied, setCopied] = useState(false);

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id!));
  }, []);

  const projectEntity = useAppSelector(state => state.project.entity);
  const account = useAppSelector(state => state.authentication.account);

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

  return (
    <Row>
      <Col md="8">
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
          <dt>
            <Translate contentKey="spec2UmlApp.project.annotators">Annotators</Translate>
          </dt>
          <dd>
            {projectEntity.annotatorses
              ? projectEntity.annotatorses.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.login || val.id}</a>
                    {projectEntity.annotatorses && i === projectEntity.annotatorses.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
          <dt>
            <Translate contentKey="spec2UmlApp.project.reviewers">Reviewers</Translate>
          </dt>
          <dd>
            {projectEntity.reviewerses
              ? projectEntity.reviewerses.map((val, i) => (
                  <span key={val.id}>
                    <a>{val.login || val.id}</a>
                    {projectEntity.reviewerses && i === projectEntity.reviewerses.length - 1 ? '' : ', '}
                  </span>
                ))
              : null}
          </dd>
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
      </Col>
    </Row>
  );
};

export default ProjectDetail;
