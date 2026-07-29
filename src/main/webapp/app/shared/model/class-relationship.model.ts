import { IRequirementClassConcepts } from 'app/shared/model/requirement-class-concepts.model';

export interface IClassRelationship {
  id?: string;
  source?: string;
  target?: string;
  type?: string;
  sourceMultiplicity?: string | null;
  targetMultiplicity?: string | null;
  label?: string | null;
  requirementClassConcepts?: IRequirementClassConcepts | null;
}

export const defaultValue: Readonly<IClassRelationship> = {};
