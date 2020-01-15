import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './knowledge-area.reducer';
import { IKnowledgeArea } from 'app/shared/model/knowledge-area.model';
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IKnowledgeAreaUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const KnowledgeAreaUpdate = (props: IKnowledgeAreaUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { knowledgeAreaEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/knowledge-area' + props.location.search);
  };

  useEffect(() => {
    if (isNew) {
      props.reset();
    } else {
      props.getEntity(props.match.params.id);
    }
  }, []);

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const entity = {
        ...knowledgeAreaEntity,
        ...values
      };

      if (isNew) {
        props.createEntity(entity);
      } else {
        props.updateEntity(entity);
      }
    }
  };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="powierzeniaApp.knowledgeArea.home.createOrEditLabel">
            <Translate contentKey="powierzeniaApp.knowledgeArea.home.createOrEditLabel">Create or edit a KnowledgeArea</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : knowledgeAreaEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="knowledge-area-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="knowledge-area-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="typeLabel" for="knowledge-area-type">
                  <Translate contentKey="powierzeniaApp.knowledgeArea.type">Type</Translate>
                </Label>
                <AvInput
                  id="knowledge-area-type"
                  type="select"
                  className="form-control"
                  name="type"
                  value={(!isNew && knowledgeAreaEntity.type) || 'DATABASES'}
                >
                  <option value="DATABASES">{translate('powierzeniaApp.KnowledgeAreaType.DATABASES')}</option>
                  <option value="DESIGN">{translate('powierzeniaApp.KnowledgeAreaType.DESIGN')}</option>
                  <option value="AI">{translate('powierzeniaApp.KnowledgeAreaType.AI')}</option>
                  <option value="LINUX">{translate('powierzeniaApp.KnowledgeAreaType.LINUX')}</option>
                  <option value="WINDOWS">{translate('powierzeniaApp.KnowledgeAreaType.WINDOWS')}</option>
                  <option value="JAVA">{translate('powierzeniaApp.KnowledgeAreaType.JAVA')}</option>
                  <option value="GIT">{translate('powierzeniaApp.KnowledgeAreaType.GIT')}</option>
                  <option value="ANSIBLE">{translate('powierzeniaApp.KnowledgeAreaType.ANSIBLE')}</option>
                  <option value="VAGRANT">{translate('powierzeniaApp.KnowledgeAreaType.VAGRANT')}</option>
                  <option value="RESEARCH">{translate('powierzeniaApp.KnowledgeAreaType.RESEARCH')}</option>
                  <option value="MATHEMATICAL_ANALYSIS">{translate('powierzeniaApp.KnowledgeAreaType.MATHEMATICAL_ANALYSIS')}</option>
                  <option value="PHYSICS">{translate('powierzeniaApp.KnowledgeAreaType.PHYSICS')}</option>
                  <option value="ALGEBRA">{translate('powierzeniaApp.KnowledgeAreaType.ALGEBRA')}</option>
                </AvInput>
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/knowledge-area" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">
                  <Translate contentKey="entity.action.back">Back</Translate>
                </span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp;
                <Translate contentKey="entity.action.save">Save</Translate>
              </Button>
            </AvForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

const mapStateToProps = (storeState: IRootState) => ({
  knowledgeAreaEntity: storeState.knowledgeArea.entity,
  loading: storeState.knowledgeArea.loading,
  updating: storeState.knowledgeArea.updating,
  updateSuccess: storeState.knowledgeArea.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(KnowledgeAreaUpdate);
