import React, { useEffect } from 'react';
import { Button, Col, Row } from 'react-bootstrap';
import { Translate, ValidatedField, ValidatedForm, translate } from 'react-jhipster';
import { Link, useNavigate, useParams, useLocation } from 'react-router';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { useAppDispatch, useAppSelector } from 'app/config/store';
import { getUsers } from 'app/modules/administration/user-management/user-management.reducer';
import { Language } from 'app/shared/model/enumerations/language.model';

import { createEntity, getEntity, reset, updateEntity } from './project.reducer';

export const ProjectUpdate = () => {
  const dispatch = useAppDispatch();
  const navigate = useNavigate();
  const location = useLocation();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const users = useAppSelector(state => state.userManagement.users);
  const projectEntity = useAppSelector(state => state.project.entity);
  const loading = useAppSelector(state => state.project.loading);
  const updating = useAppSelector(state => state.project.updating);
  const updateSuccess = useAppSelector(state => state.project.updateSuccess);
  const languageValues = Object.keys(Language);

  const handleClose = () => {
    navigate(`/project${location.search}`);
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }
    dispatch(getUsers({}));
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  /**
   * Helper function to map selected user IDs to objects containing both id and login.
   */
  const mapUserList = (selectedIds: any, userList: any[]) => {
    if (!selectedIds) return [];
    const ids = Array.isArray(selectedIds) ? selectedIds : [selectedIds];
    return ids
      .filter(userId => userId !== '' && userId !== null && userId !== undefined)
      .map(userId => {
        const foundUser = userList?.find(u => u.id.toString() === userId.toString());
        return {
          id: userId,
          login: foundUser ? foundUser.login : undefined,
        };
      });
  };

  const saveEntity = values => {
    const entity = {
      ...projectEntity,
      ...values,
      annotatorses: mapUserList(values.annotatorses, users),
      reviewerses: mapUserList(values.reviewerses, users),
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
          language: 'EN',
        }
      : {
          language: 'EN',
          ...projectEntity,
          annotatorses: projectEntity?.annotatorses?.map(e => e.id.toString()),
          reviewerses: projectEntity?.reviewerses?.map(e => e.id.toString()),
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="spec2UmlApp.project.home.createOrEditLabel" data-cy="ProjectCreateUpdateHeading">
            <Translate contentKey="spec2UmlApp.project.home.createOrEditLabel">Create or edit a Project</Translate>
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
                  id="project-id"
                  label={translate('global.field.id')}
                  validate={{ required: true }}
                />
              )}
              <ValidatedField
                label={translate('spec2UmlApp.project.name')}
                id="project-name"
                name="name"
                data-cy="name"
                type="text"
                validate={{
                  required: { value: true, message: translate('entity.validation.required') },
                }}
              />
              <ValidatedField
                label={translate('spec2UmlApp.project.description')}
                id="project-description"
                name="description"
                data-cy="description"
                type="textarea"
              />
              <ValidatedField
                label={translate('spec2UmlApp.project.language')}
                id="project-language"
                name="language"
                data-cy="language"
                type="select"
              >
                {languageValues.map(language => (
                  <option value={language} key={language}>
                    {translate(`spec2UmlApp.Language.${language}`)}
                  </option>
                ))}
              </ValidatedField>
              <ValidatedField
                label={translate('spec2UmlApp.project.umlVersion')}
                id="project-umlVersion"
                name="umlVersion"
                data-cy="umlVersion"
                type="text"
              />
              <ValidatedField
                label={translate('spec2UmlApp.project.annotators')}
                id="project-annotators"
                data-cy="annotators"
                type="select"
                multiple
                name="annotatorses"
              >
                <option value="" key="0" />
                {users
                  ? users.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.login || otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <ValidatedField
                label={translate('spec2UmlApp.project.reviewers')}
                id="project-reviewers"
                data-cy="reviewers"
                type="select"
                multiple
                name="reviewerses"
              >
                <option value="" key="0" />
                {users
                  ? users.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.login || otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <Button as={Link as any} id="cancel-save" data-cy="entityCreateCancelButton" to="/project" replace variant="info">
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

export default ProjectUpdate;
