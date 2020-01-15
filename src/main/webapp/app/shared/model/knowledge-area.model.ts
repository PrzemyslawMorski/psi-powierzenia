export interface IKnowledgeArea {
  id?: number;
  type?: string;
  courseId?: number;
  teacherId?: number;
}

export const defaultValue: Readonly<IKnowledgeArea> = {};
