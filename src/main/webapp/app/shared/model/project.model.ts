import dayjs from 'dayjs';

import { Language } from 'app/shared/model/enumerations/language.model';
import { IProjectStatistics } from 'app/shared/model/project-statistics.model';
import { IUser } from 'app/shared/model/user.model';

export interface IProject {
  id?: string;
  name?: string;
  description?: string | null;
  language?: keyof typeof Language;
  umlVersion?: string | null;
  createdAt?: dayjs.Dayjs;
  updatedAt?: dayjs.Dayjs | null;
  statistics?: IProjectStatistics | null;
  createdBy?: IUser | null;
  annotatorses?: IUser[] | null;
  reviewerses?: IUser[] | null;
}

export const defaultValue: Readonly<IProject> = {};
