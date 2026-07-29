import { IClassConcept } from 'app/shared/model/class-concept.model';

export interface IClassOperation {
  id?: string;
  name?: string | null;
  returnType?: string | null;
  classConcept?: IClassConcept | null;
}

export const defaultValue: Readonly<IClassOperation> = {};
