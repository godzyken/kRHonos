import {SituationFamiliale} from "./situationFamiliale";

export interface Salarie {
  id?: number;
  numSecu: string;
  cleSecu: number;
  dateNaissance: Date;
  civilite: number;
  situationFam: SituationFamiliale;
}
