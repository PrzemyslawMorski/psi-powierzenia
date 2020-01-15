import { ClassFormType } from 'app/shared/model/enumerations/class-form-type.model';

export interface IClassForm {
  id?: number;
  type?: ClassFormType;
}

export const defaultValue: Readonly<IClassForm> = {};