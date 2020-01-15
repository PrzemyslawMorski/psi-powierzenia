import React, { useState, useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col, Label } from 'reactstrap';
import { AvFeedback, AvForm, AvGroup, AvInput, AvField } from 'availity-reactstrap-validation';
import { Translate, translate, ICrudGetAction, ICrudGetAllAction, ICrudPutAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IRootState } from 'app/shared/reducers';

import { ICourse } from 'app/shared/model/course.model';
import { getEntities as getCourses } from 'app/entities/course/course.reducer';
import { ITeacher } from 'app/shared/model/teacher.model';
import { getEntities as getTeachers } from 'app/entities/teacher/teacher.reducer';
import { getEntity, updateEntity, createEntity, reset } from './knowledge-area.reducer';
import { IKnowledgeArea } from 'app/shared/model/knowledge-area.model';
import { convertDateTimeFromServer, convertDateTimeToServer } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';

export interface IKnowledgeAreaUpdateProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const KnowledgeAreaUpdate = (props: IKnowledgeAreaUpdateProps) => {
  const [courseId, setCourseId] = useState('0');
  const [teacherId, setTeacherId] = useState('0');
  const [isNew, setIsNew] = useState(!props.match.params || !props.match.params.id);

  const { knowledgeAreaEntity, courses, teachers, loading, updating } = props;

  const handleClose = () => {
    props.history.push('/knowledge-area' + props.location.search);
  };

  useEffect(() => {
    if (isNew) {
      props.reset();
    } else {
      props.getEntity(props.match.params.id);
    }

    props.getCourses();
    props.getTeachers();
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
                <AvField id="knowledge-area-type" type="text" name="type" />
              </AvGroup>
              <AvGroup>
                <Label for="knowledge-area-course">
                  <Translate contentKey="powierzeniaApp.knowledgeArea.course">Course</Translate>
                </Label>
                <AvInput id="knowledge-area-course" type="select" className="form-control" name="courseId">
                  <option value="" key="0" />
                  {courses
                    ? courses.map(otherEntity => (
                        <option value={otherEntity.id} key={otherEntity.id}>
                          {otherEntity.id}
                        </option>
                      ))
                    : null}
                </AvInput>
              </AvGroup>
              <AvGroup>
                <Label for="knowledge-area-teacher">
                  <Translate contentKey="powierzeniaApp.knowledgeArea.teacher">Teacher</Translate>
                </Label>
                <AvInput id="knowledge-area-teacher" type="select" className="form-control" name="teacherId">
                  <option value="" key="0" />
                  {teachers
                    ? teachers.map(otherEntity => (
                        <option value={otherEntity.id} key={otherEntity.id}>
                          {otherEntity.id}
                        </option>
                      ))
                    : null}
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
  courses: storeState.course.entities,
  teachers: storeState.teacher.entities,
  knowledgeAreaEntity: storeState.knowledgeArea.entity,
  loading: storeState.knowledgeArea.loading,
  updating: storeState.knowledgeArea.updating,
  updateSuccess: storeState.knowledgeArea.updateSuccess
});

const mapDispatchToProps = {
  getCourses,
  getTeachers,
  getEntity,
  updateEntity,
  createEntity,
  reset
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(KnowledgeAreaUpdate);
