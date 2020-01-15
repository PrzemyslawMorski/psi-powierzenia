import React, { useEffect } from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate, ICrudGetAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntity } from './knowledge-area.reducer';
import { IKnowledgeArea } from 'app/shared/model/knowledge-area.model';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface IKnowledgeAreaDetailProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {}

export const KnowledgeAreaDetail = (props: IKnowledgeAreaDetailProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const { knowledgeAreaEntity } = props;
  return (
    <Row>
      <Col md="8">
        <h2>
          <Translate contentKey="powierzeniaApp.knowledgeArea.detail.title">KnowledgeArea</Translate> [<b>{knowledgeAreaEntity.id}</b>]
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="type">
              <Translate contentKey="powierzeniaApp.knowledgeArea.type">Type</Translate>
            </span>
          </dt>
          <dd>{knowledgeAreaEntity.type}</dd>
          <dt>
            <Translate contentKey="powierzeniaApp.knowledgeArea.course">Course</Translate>
          </dt>
          <dd>{knowledgeAreaEntity.courseId ? knowledgeAreaEntity.courseId : ''}</dd>
          <dt>
            <Translate contentKey="powierzeniaApp.knowledgeArea.teacher">Teacher</Translate>
          </dt>
          <dd>{knowledgeAreaEntity.teacherId ? knowledgeAreaEntity.teacherId : ''}</dd>
        </dl>
        <Button tag={Link} to="/knowledge-area" replace color="info">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/knowledge-area/${knowledgeAreaEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

const mapStateToProps = ({ knowledgeArea }: IRootState) => ({
  knowledgeAreaEntity: knowledgeArea.entity
});

const mapDispatchToProps = { getEntity };

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(KnowledgeAreaDetail);
