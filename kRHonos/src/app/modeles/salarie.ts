<<<<<<< guillaume_dev
import {FamilySituation} from './familySituation';

export interface Salarie {
=======
export class Salarie {
>>>>>>> comit autogodzy form contrat
  id?: number;
<<<<<<< guillaume_dev
  nom: string;
  nomNaissance: string;
  prenom: string;
  numSecu: number;
  cleSecu: number;
  adresseNumero: string;
  adresseComplement: string;
  adresseLatitude: number;
  adresseLongitude: number;
  telephone: number;
  mail: string;
=======
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
>>>>>>> debut de conception de contrat
  dateNaissance?: Date;
  cpNaissance?: number;
  villeNaissance?: string;
<<<<<<< guillaume_dev
  civilite?: number;
  situationFam?: FamilySituation;
=======
  dateEntree?: Date;
  civilite?: number;
  situationFam?: number;
>>>>>>> comit autogodzy form contrat
  active?: boolean;
}
