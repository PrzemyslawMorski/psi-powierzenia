import { TeacherType } from 'app/shared/model/enumerations/teacher-type.model';

export interface ITeacher {
  id?: number;
  firstName?: string;
  lastName?: string;
  email?: string;
  hourLimit?: number;
  pensum?: number;
  agreedToAdditionalPensum?: boolean;
  type?: TeacherType;
  entrustmentsId?: number;
  preferedCoursesId?: number;
  knowledgeAreasId?: number;
  allowedClassFormsId?: number;
}

export const defaultValue: Readonly<ITeacher> = {
  agreedToAdditionalPensum: false
};
