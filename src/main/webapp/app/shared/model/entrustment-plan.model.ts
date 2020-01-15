import { SemesterType } from 'app/shared/model/enumerations/semester-type.model';

export interface IEntrustmentPlan {
  id?: number;
  academicYear?: number;
  semesterType?: SemesterType;
  entrustmentsId?: number;
}

export const defaultValue: Readonly<IEntrustmentPlan> = {};
