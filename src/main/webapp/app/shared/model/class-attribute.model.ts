import { IClassConcept } from 'app/shared/model/class-concept.model';

export interface IClassAttribute {
  id?: string;
  name?: string;
  type?: string;
  visibility?: string | null;
  classConcept?: IClassConcept | null;
}

export const defaultValue: Readonly<IClassAttribute> = {};
