import dayjs from 'dayjs';

import { RequirementStatus } from 'app/shared/model/enumerations/requirement-status.model';
import { IProject } from 'app/shared/model/project.model';
import { IRequirementClassConcepts } from 'app/shared/model/requirement-class-concepts.model';
import { IRequirementUseCaseConcepts } from 'app/shared/model/requirement-use-case-concepts.model';
import { IUser } from 'app/shared/model/user.model';

export interface IRequirement {
  id?: string;
  sentId?: number;
  text?: string;
  source?: string;
  projectId?: string;
  type?: string;
  specLevel?: string;
  classDiagram?: string | null;
  useCaseDiagram?: string | null;
  status?: keyof typeof RequirementStatus;
  createdAt?: dayjs.Dayjs;
  updatedAt?: dayjs.Dayjs | null;
  useCaseConcepts?: IRequirementUseCaseConcepts | null;
  classConcepts?: IRequirementClassConcepts | null;
  project?: IProject;
  annotatorses?: IUser[] | null;
}

export const defaultValue: Readonly<IRequirement> = {};
