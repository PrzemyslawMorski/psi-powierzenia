import { KnowledgeAreaType } from 'app/shared/model/enumerations/knowledge-area-type.model';

export interface IKnowledgeArea {
  id?: number;
  type?: KnowledgeAreaType;
}

export const defaultValue: Readonly<IKnowledgeArea> = {};
