import { ICourseClass } from 'app/shared/model/course-class.model';
import { IKnowledgeArea } from 'app/shared/model/knowledge-area.model';

export interface ICourse {
  id?: number;
  name?: string;
  code?: string;
  classes?: ICourseClass[];
  tags?: IKnowledgeArea[];
  educationPlanId?: number;
  teacherId?: number;
}

export const defaultValue: Readonly<ICourse> = {};
