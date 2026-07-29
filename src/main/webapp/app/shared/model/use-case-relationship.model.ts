import { IRequirementUseCaseConcepts } from 'app/shared/model/requirement-use-case-concepts.model';

export interface IUseCaseRelationship {
  id?: string;
  source?: string;
  target?: string;
  type?: string;
  label?: string | null;
  requirementUseCaseConcepts?: IRequirementUseCaseConcepts | null;
}

export const defaultValue: Readonly<IUseCaseRelationship> = {};
