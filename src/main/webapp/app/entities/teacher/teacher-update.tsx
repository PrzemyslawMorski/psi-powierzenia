import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { getEntity, updateEntity, createEntity, reset } from './teacher.reducer';
import { ITeacher } from 'app/shared/model/teacher.model';
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface ITeacherUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const TeacherUpdate = (props: ITeacherUpdateProps) => {
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { teacherEntity, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/teacher' + props.location.search);
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
        ...teacherEntity,
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
          <h2 id="powierzeniaApp.teacher.home.createOrEditLabel">
            <Translate contentKey="powierzeniaApp.teacher.home.createOrEditLabel">Create or edit a Teacher</Translate>
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <AvForm model={isNew ? {} : teacherEntity} onSubmit={saveEntity}>
              {!isNew ? (
                <AvGroup>
                  <Label for="teacher-id">
                    <Translate contentKey="global.field.id">ID</Translate>
                  </Label>
                  <AvInput id="teacher-id" type="text" className="form-control" name="id" required readOnly />
                </AvGroup>
              ) : null}
              <AvGroup>
                <Label id="firstNameLabel" for="teacher-firstName">
                  <Translate contentKey="powierzeniaApp.teacher.firstName">First Name</Translate>
                </Label>
                <AvField id="teacher-firstName" type="text" name="firstName" />
              </AvGroup>
              <AvGroup>
                <Label id="lastNameLabel" for="teacher-lastName">
                  <Translate contentKey="powierzeniaApp.teacher.lastName">Last Name</Translate>
                </Label>
                <AvField id="teacher-lastName" type="text" name="lastName" />
              </AvGroup>
              <AvGroup>
                <Label id="emailLabel" for="teacher-email">
                  <Translate contentKey="powierzeniaApp.teacher.email">Email</Translate>
                </Label>
                <AvField id="teacher-email" type="text" name="email" />
              </AvGroup>
              <AvGroup>
                <Label id="hourLimitLabel" for="teacher-hourLimit">
                  <Translate contentKey="powierzeniaApp.teacher.hourLimit">Hour Limit</Translate>
                </Label>
                <AvField id="teacher-hourLimit" type="string" className="form-control" name="hourLimit" />
              </AvGroup>
              <AvGroup>
                <Label id="pensumLabel" for="teacher-pensum">
                  <Translate contentKey="powierzeniaApp.teacher.pensum">Pensum</Translate>
                </Label>
                <AvField id="teacher-pensum" type="string" className="form-control" name="pensum" />
              </AvGroup>
              <AvGroup check>
                <Label id="agreedToAdditionalPensumLabel">
                  <AvInput
                    id="teacher-agreedToAdditionalPensum"
                    type="checkbox"
                    className="form-check-input"
                    name="agreedToAdditionalPensum"
                  />
                  <Translate contentKey="powierzeniaApp.teacher.agreedToAdditionalPensum">Agreed To Additional Pensum</Translate>
                </Label>
              </AvGroup>
              <AvGroup>
                <Label id="typeLabel" for="teacher-type">
                  <Translate contentKey="powierzeniaApp.teacher.type">Type</Translate>
                </Label>
                <AvInput
                  id="teacher-type"
                  type="select"
                  className="form-control"
                  name="type"
                  value={(!isNew && teacherEntity.type) || 'EXTERNAL_SPECIALIST'}
                >
                  <option value="EXTERNAL_SPECIALIST">{translate('powierzeniaApp.TeacherType.EXTERNAL_SPECIALIST')}</option>
                  <option value="DOCTORATE_STUDENT">{translate('powierzeniaApp.TeacherType.DOCTORATE_STUDENT')}</option>
                  <option value="ACADEMIC_TEACHER">{translate('powierzeniaApp.TeacherType.ACADEMIC_TEACHER')}</option>
                </AvInput>
              </AvGroup>
              <Button tag={Link} id="cancel-save" to="/teacher" replace color="info">
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
  teacherEntity: storeState.teacher.entity,
  loading: storeState.teacher.loading,
  updating: storeState.teacher.updating,
  updateSuccess: storeState.teacher.updateSuccess
});

const mapDispatchToProps = {
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(TeacherUpdate);
