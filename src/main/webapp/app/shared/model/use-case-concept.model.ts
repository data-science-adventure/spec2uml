import { IRequirementUseCaseConcepts } from 'app/shared/model/requirement-use-case-concepts.model';

export interface IUseCaseConcept {
  id?: string;
  name?: string;
  description?: string | null;
  trigger?: string | null;
  systemBoundary?: string | null;
  requirementUseCaseConcepts?: IRequirementUseCaseConcepts | null;
}

export const defaultValue: Readonly<IUseCaseConcept> = {};
