export interface IProjectStatistics {
  id?: string;
  requirements?: number | null;
  completed?: number | null;
  approved?: number | null;
}

export const defaultValue: Readonly<IProjectStatistics> = {};
