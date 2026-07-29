import { IUseCaseConcept } from 'app/shared/model/use-case-concept.model';

export interface IUseCaseBusinessRule {
  id?: string;
  ruleText?: string | null;
  useCaseConcept?: IUseCaseConcept | null;
}

export const defaultValue: Readonly<IUseCaseBusinessRule> = {};
