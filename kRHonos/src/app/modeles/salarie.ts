export interface Salarie {
  id?: number;
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
  dateNaissance?: Date;
  cpNaissance?: number;
  villeNaissance?: string;
  civilite?: number;
  situationFam?: number;
  active?: boolean;
}
