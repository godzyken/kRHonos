import {Injectable} from '@angular/core';
import * as moment from 'moment';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Commune} from '../modeles/commune';
import {Subject} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class NirService {

  private API_URL = 'https://geo.api.gouv.fr/';

  commune: Commune = null;
  communeSubject = new Subject<Commune>();

  constructor(private http: HttpClient) {
  }

  emitCommune() {
    this.communeSubject.next(this.commune);
  }

  getCivilite(nir: string) {
    const civilite = parseInt(nir.charAt(0), 10);
    return civilite === 1 ? '0' :
      civilite === 2 ? '1' :
        '';
  }

  getAnneeNaissance(nir: string) {
    const annee = parseInt(nir.substr(1, 2), 10);
    const yearNow = parseInt(moment().format('YY'), 10);
    return annee <= yearNow ? '20' + annee : '19' + annee;
  }


  getMoisNaissance(nir: string) {
    return (parseInt(nir.substr(3, 2), 10) - 1);
  }

  getVilleNaissance(nir: string): Commune {
    const numHorsFrance = parseInt(nir.substr(5, 2), 10);
    this.commune = new Commune();
    if (numHorsFrance !== 99) {
      const departement = nir.substr(5, 5);
      let params = new HttpParams().set('code', departement);
      const fields = ['nom'];
      params = params.set('fields', fields.toString());
      this.http.get<Commune>(this.API_URL + 'communes', {params}).toPromise().then(
        data => {
          this.commune.nom = data[0].nom;
          this.commune.code = data[0].code;
        }
      );
      this.emitCommune();
      return this.commune;
    }
  }


}
