import { FieldOfStudy } from 'app/shared/model/enumerations/field-of-study.model';
import { Specialization } from 'app/shared/model/enumerations/specialization.model';
import { StudiesLevel } from 'app/shared/model/enumerations/studies-level.model';
import { StudiesType } from 'app/shared/model/enumerations/studies-type.model';

export interface IEducationPlan {
  id?: number;
  startAcademicYear?: number;
  fieldOfStudy?: FieldOfStudy;
  specialization?: Specialization;
  studiesLevel?: StudiesLevel;
  studiesType?: StudiesType;
  educationPlansId?: number;
  coursesId?: number;
}

export const defaultValue: Readonly<IEducationPlan> = {};
