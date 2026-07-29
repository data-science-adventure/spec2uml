import { IRequirementClassConcepts } from 'app/shared/model/requirement-class-concepts.model';

export interface IClassConcept {
  id?: string;
  name?: string;
  stereotype?: string | null;
  requirementClassConcepts?: IRequirementClassConcepts | null;
}

export const defaultValue: Readonly<IClassConcept> = {};
