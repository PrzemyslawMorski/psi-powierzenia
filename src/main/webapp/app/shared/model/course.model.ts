export interface ICourse {
  id?: number;
  name?: string;
  code?: string;
  classesId?: number;
  tagsId?: number;
}

export const defaultValue: Readonly<ICourse> = {};
