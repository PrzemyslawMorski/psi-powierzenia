import { IEntrustment } from 'app/shared/model/entrustment.model';
import { ICourse } from 'app/shared/model/course.model';
import { IKnowledgeArea } from 'app/shared/model/knowledge-area.model';
import { IClassForm } from 'app/shared/model/class-form.model';
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
  entrustments?: IEntrustment[];
  preferedCourses?: ICourse[];
  knowledgeAreas?: IKnowledgeArea[];
  allowedClassForms?: IClassForm[];
}

export const defaultValue: Readonly<ITeacher> = {
  agreedToAdditionalPensum: false
};
