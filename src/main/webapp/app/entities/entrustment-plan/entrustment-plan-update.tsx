import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { IEntrustment } from 'app/shared/model/entrustment.model';
import { getEntities as getEntrustments } from 'app/entities/entrustment/entrustment.reducer';
import { getEntity, updateEntity, createEntity, reset } from './entrustment-plan.reducer';
import { IEntrustmentPlan } from 'app/shared/model/entrustment-plan.model';
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IEntrustmentPlanUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const EntrustmentPlanUpdate = (props: IEntrustmentPlanUpdateProps) => {
  const [entrustmentsId, setEntrustmentsId] = useState('0');
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { entrustmentPlanEntity, entrustments, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/entrustment-plan' + props.location.search);
  };

  useEffect(() => {
    if (isNew) {
      props.reset();
    } else {
      props.getEntity(props.match.params.id);
    }

    props.getEntrustments();
  }, []);

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const saveEntity = (event, errors, values) => {
    if (errors.length === 0) {
      const entity = {
        ...entrustmentPlanEntity,
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
          <h2 id="powierzeniaApp.entrustmentPlan.home.createOrEditLabel">
            <Translate contentKey="powierzeniaApp.entrustmentPlan.home.createOrEditLabel">Create or edit a EntrustmentPlan</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : entrustmentPlanEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="entrustment-plan-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="entrustment-plan-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="academicYearLabel" for="entrustment-plan-academicYear">
                  <Translate contentKey="powierzeniaApp.entrustmentPlan.academicYear">Academic Year</Translate>
                </Label>
                <AvField id="entrustment-plan-academicYear" type="string" className="form-control" name="academicYear" />
              </AvGroup>
              <AvGroup>
                <Label id="semesterTypeLabel" for="entrustment-plan-semesterType">
                  <Translate contentKey="powierzeniaApp.entrustmentPlan.semesterType">Semester Type</Translate>
                </Label>
                <AvInput
                  id="entrustment-plan-semesterType"
                  type="select"
                  className="form-control"
                  name="semesterType"
                  value={(!isNew && entrustmentPlanEntity.semesterType) || 'SUMMER'}
                >
                  <option value="SUMMER">{translate('powierzeniaApp.SemesterType.SUMMER')}</option>
                  <option value="WINTER">{translate('powierzeniaApp.SemesterType.WINTER')}</option>
                </AvInput>
              </AvGroup>
              <AvGroup>
                <Label for="entrustment-plan-entrustments">
                  <Translate contentKey="powierzeniaApp.entrustmentPlan.entrustments">Entrustments</Translate>
                </Label>
                <AvInput id="entrustment-plan-entrustments" type="select" className="form-control" name="entrustmentsId">
                  <option value="" key="0" />
                  {entrustments
                    ? entrustments.map(otherEntity => (
                        <option value={otherEntity.id} key={otherEntity.id}>
                          {otherEntity.id}
                        </option>
                      ))
                    : null}
                </AvInput>
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/entrustment-plan" replace color="info">
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
  entrustments: storeState.entrustment.entities,
  entrustmentPlanEntity: storeState.entrustmentPlan.entity,
  loading: storeState.entrustmentPlan.loading,
  updating: storeState.entrustmentPlan.updating,
  updateSuccess: storeState.entrustmentPlan.updateSuccess
});

const mapDispatchToProps = {
  getEntrustments,
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(EntrustmentPlanUpdate);
