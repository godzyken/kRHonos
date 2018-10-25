import {FamilySituation} from './familySituation';

export interface Salarie {
  nom?: string;
  nomNaissance?: string;
  prenom?: string;
  numSecu?: number;
  cleSecu?: number;
  adresse?: string;
  codePostal?: number;
  ville?: string;
  telephone?: number;
  mail?: string;
  dateNaissance?: Date;
  cpNaissance?: number;
  villeNaissance?: string;
  dateEntree?: Date;
  civilite?: number;
  situationFam?: FamilySituation;
  active?: boolean;
}
