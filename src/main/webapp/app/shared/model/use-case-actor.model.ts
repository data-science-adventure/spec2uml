import { IRequirementUseCaseConcepts } from 'app/shared/model/requirement-use-case-concepts.model';

export interface IUseCaseActor {
  id?: string;
  name?: string;
  description?: string | null;
  requirementUseCaseConcepts?: IRequirementUseCaseConcepts | null;
}

export const defaultValue: Readonly<IUseCaseActor> = {};
