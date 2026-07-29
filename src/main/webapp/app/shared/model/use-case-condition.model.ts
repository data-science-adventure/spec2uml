import { IUseCaseConcept } from 'app/shared/model/use-case-concept.model';

export interface IUseCaseCondition {
  id?: string;
  conditionText?: string | null;
  preconditionUseCaseConcept?: IUseCaseConcept | null;
  postconditionUseCaseConcept?: IUseCaseConcept | null;
}

export const defaultValue: Readonly<IUseCaseCondition> = {};
