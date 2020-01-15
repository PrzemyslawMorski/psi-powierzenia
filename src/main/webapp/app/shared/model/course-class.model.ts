import { ClassFormType } from 'app/shared/model/enumerations/class-form-type.model';

export interface ICourseClass {
  id?: number;
  hours?: number;
  form?: ClassFormType;
  entrustmentsId?: number;
}

export const defaultValue: Readonly<ICourseClass> = {};
