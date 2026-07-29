import { IUseCaseConcept } from 'app/shared/model/use-case-concept.model';

export interface IUseCaseActorRef {
  id?: string;
  actorName?: string;
  primaryUseCaseConcept?: IUseCaseConcept | null;
  secondaryUseCaseConcept?: IUseCaseConcept | null;
}

export const defaultValue: Readonly<IUseCaseActorRef> = {};
