import React, {useEffect} from 'react';
import {connect} from 'react-redux';
import {RouteComponentProps} from 'react-router-dom';
import {Button, Modal, ModalBody, ModalFooter, ModalHeader} from 'reactstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {IRootState} from 'app/shared/reducers';
import {deleteEntity, getEntity} from './education-plan.reducer';

export interface IEducationPlanDeleteDialogProps extends StateProps, DispatchProps, RouteComponentProps<{ id: string }> {
}

export const EducationPlanDeleteDialog = (props: IEducationPlanDeleteDialogProps) => {
  useEffect(() => {
    props.getEntity(props.match.params.id);
  }, []);

  const handleClose = () => {
    props.history.push('/education-plan' + props.location.search);
  };

  useEffect(() => {
    if (props.updateSuccess) {
      handleClose();
    }
  }, [props.updateSuccess]);

  const confirmDelete = () => {
    props.deleteEntity(props.educationPlanEntity.id);
  };

  const {educationPlanEntity} = props;
  return (
    <Modal isOpen toggle={handleClose}>
      <ModalHeader toggle={handleClose}>Confirm delete operation</ModalHeader>
      <ModalBody id="powierzeniaApp.educationPlan.delete.question">Are you sure you want to delete this
        EducationPlan?</ModalBody>
      <ModalFooter>
        <Button color="secondary" onClick={handleClose}>
          <FontAwesomeIcon icon="ban"/>
          &nbsp; Cancel
        </Button>
        <Button id="jhi-confirm-delete-educationPlan" color="danger" onClick={confirmDelete}>
          <FontAwesomeIcon icon="trash"/>
          &nbsp; Delete
        </Button>
      </ModalFooter>
    </Modal>
  );
};

const mapStateToProps = ({educationPlan}: IRootState) => ({
  educationPlanEntity: educationPlan.entity,
  updateSuccess: educationPlan.updateSuccess
});

const mapDispatchToProps = {getEntity, deleteEntity};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(mapStateToProps, mapDispatchToProps)(EducationPlanDeleteDialog);
