import { IClassOperation } from 'app/shared/model/class-operation.model';

export interface IOperationParameter {
  id?: string;
  paramName?: string | null;
  classOperation?: IClassOperation | null;
}

export const defaultValue: Readonly<IOperationParameter> = {};
