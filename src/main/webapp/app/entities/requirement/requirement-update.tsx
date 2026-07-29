import React, { useEffect } from 'react';
import { Button, Col, FormText, Row } from 'react-bootstrap';
import { Translate, ValidatedField, ValidatedForm, isNumber, translate } from 'react-jhipster';
import { Link, useNavigate, useParams } from 'react-router';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { useAppDispatch, useAppSelector } from 'app/config/store';
import { getEntities as getProjects } from 'app/entities/project/project.reducer';
import { getUsers } from 'app/modules/administration/user-management/user-management.reducer';
import { RequirementStatus } from 'app/shared/model/enumerations/requirement-status.model';
import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

import { createEntity, getEntity, reset, updateEntity } from './requirement.reducer';

export const RequirementUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const requirementUseCaseConceptses = useAppSelector(state => state.requirementUseCaseConcepts.entities);
  const requirementClassConceptses = useAppSelector(state => state.requirementClassConcepts.entities);
  const projects = useAppSelector(state => state.project.entities);
  const users = useAppSelector(state => state.userManagement.users);
  const requirementEntity = useAppSelector(state => state.requirement.entity);
  const loading = useAppSelector(state => state.requirement.loading);
  const updating = useAppSelector(state => state.requirement.updating);
  const updateSuccess = useAppSelector(state => state.requirement.updateSuccess);
  const requirementStatusValues = Object.keys(RequirementStatus);

  const handleClose = () => {
    navigate(`/requirement${location.search}`);
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }

    dispatch(getProjects({}));
    dispatch(getUsers({}));
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = values => {
    if (values.sentId !== undefined && typeof values.sentId !== 'number') {
      values.sentId = Number(values.sentId);
    }
    values.createdAt = convertDateTimeToServer(values.createdAt);
    values.updatedAt = convertDateTimeToServer(values.updatedAt);

    const entity = {
      ...requirementEntity,
      ...values,
      useCaseConcepts: requirementUseCaseConceptses.find(it => it.id.toString() === values.useCaseConcepts?.toString()),
      classConcepts: requirementClassConceptses.find(it => it.id.toString() === values.classConcepts?.toString()),
      project: projects.find(it => it.id.toString() === values.project?.toString()),
      annotatorses: mapIdList(values.annotatorses),
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {
          createdAt: displayDefaultDateTime(),
          updatedAt: displayDefaultDateTime(),
        }
      : {
          status: 'DRAFT',
          ...requirementEntity,
          createdAt: convertDateTimeFromServer(requirementEntity.createdAt),
          updatedAt: convertDateTimeFromServer(requirementEntity.updatedAt),
          useCaseConcepts: requirementEntity?.useCaseConcepts?.id,
          classConcepts: requirementEntity?.classConcepts?.id,
          project: requirementEntity?.project?.id,
          annotatorses: requirementEntity?.annotatorses?.map(e => e.id.toString()),
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="spec2UmlApp.requirement.home.createOrEditLabel" data-cy="RequirementCreateUpdateHeading">
            <Translate contentKey="spec2UmlApp.requirement.home.createOrEditLabel">Create or edit a Requirement</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew && (
                <ValidatedField
                  name="id"
                  required
                  readOnly
                  id="requirement-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              )}
              <ValidatedField
                label={translate('spec2UmlApp.requirement.sentId')}
                id="requirement-sentId"
                name="sentId"
                data-cy="sentId"
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
                data-cy="text"
                type="textarea"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('spec2UmlApp.requirement.source')}
                id="requirement-source"
                name="source"
                data-cy="source"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('spec2UmlApp.requirement.projectId')}
                id="requirement-projectId"
                name="projectId"
                data-cy="projectId"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('spec2UmlApp.requirement.type')}
                id="requirement-type"
                name="type"
                data-cy="type"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('spec2UmlApp.requirement.specLevel')}
                id="requirement-specLevel"
                name="specLevel"
                data-cy="specLevel"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('spec2UmlApp.requirement.classDiagram')}
                id="requirement-classDiagram"
                name="classDiagram"
                data-cy="classDiagram"
                type="textarea"
              />
              <ValidatedField
                label={translate('spec2UmlApp.requirement.useCaseDiagram')}
                id="requirement-useCaseDiagram"
                name="useCaseDiagram"
                data-cy="useCaseDiagram"
                type="textarea"
              />
              <ValidatedField
                label={translate('spec2UmlApp.requirement.status')}
                id="requirement-status"
                name="status"
                data-cy="status"
                type="select"
              >
                {requirementStatusValues.map(requirementStatus => (
                  <option value={requirementStatus} key={requirementStatus}>
                    {translate(`spec2UmlApp.RequirementStatus.${requirementStatus}`)}
                  </option>
                ))}
              </ValidatedField>
              <ValidatedField
                label={translate('spec2UmlApp.requirement.createdAt')}
                id="requirement-createdAt"
                name="createdAt"
                data-cy="createdAt"
                type="datetime-local"
                placeholder="YYYY-MM-DD HH:mm"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('spec2UmlApp.requirement.updatedAt')}
                id="requirement-updatedAt"
                name="updatedAt"
                data-cy="updatedAt"
                type="datetime-local"
                placeholder="YYYY-MM-DD HH:mm"
              />
              <ValidatedField
                id="requirement-useCaseConcepts"
                name="useCaseConcepts"
                data-cy="useCaseConcepts"
                label={translate('spec2UmlApp.requirement.useCaseConcepts')}
                type="select"
              >
                <option value="" key="0" />
                {requirementUseCaseConceptses
                  ? requirementUseCaseConceptses.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <ValidatedField
                id="requirement-classConcepts"
                name="classConcepts"
                data-cy="classConcepts"
                label={translate('spec2UmlApp.requirement.classConcepts')}
                type="select"
              >
                <option value="" key="0" />
                {requirementClassConceptses
                  ? requirementClassConceptses.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <ValidatedField
                id="requirement-project"
                name="project"
                data-cy="project"
                label={translate('spec2UmlApp.requirement.project')}
                type="select"
                required
              >
                <option value="" key="0" />
                {projects
                  ? projects.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.name}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <FormText>
                <Translate contentKey="entity.validation.required">This field is required.</Translate>
              </FormText>
              <ValidatedField
                label={translate('spec2UmlApp.requirement.annotators')}
                id="requirement-annotators"
                data-cy="annotators"
                type="select"
                multiple
                name="annotatorses"
              >
                <option value="" key="0" />
                {users
                  ? users.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <Button as={Link as any} id="cancel-save" data-cy="entityCreateCancelButton" to="/requirement" replace variant="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button variant="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default RequirementUpdate;
