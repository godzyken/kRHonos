import {Injectable} from '@angular/core';
import * as moment from 'moment';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Commune} from '../models/commune';
import {Observable, Subject} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class NirService {


  private API_URL = 'https://geo.api.gouv.fr/';

  constructor(private http: HttpClient) {
  }

  private extractCivilite(nir: string) {
    return parseInt(nir.charAt(0), 10);
  }

  private extractAnneeNaissance(nir: string) {
    return parseInt(nir.substr(1, 2), 10);
  }

  private extractDepartement(nir: String) {
    const departement = nir.substr(5, 2).replace('2A', '19').replace('2B', '18');
    return parseInt(departement, 10);
  }

  private extractCommune(nir: string) {
    return parseInt(nir.substr(7, 3), 10);
  }

  private extractOrdre(nir: string) {
    return parseInt(nir.substr(10, 3), 10);
  }

  getCivilite(nir: string) {
    const civilite = this.extractCivilite(nir);
    return civilite === 1 ? '0' :
      civilite === 2 ? '1' :
        '';
  }

  getAnneeNaissance(nir: string) {
    const annee = this.extractAnneeNaissance(nir);
    const yearNow = parseInt(moment().format('YY'), 10);
    return annee <= yearNow ? '20' + annee : '19' + annee;
  }


  getMoisNaissance(nir: string) {
    return parseInt(nir.substr(3, 2), 10);
  }

  public leftPad(number, targetLength) {
    let output = number + '';
    while (output.length < targetLength) {
      output = '0' + output;
    }
    return output;
  }


  getCommune(nir: string): Observable<Commune> {
    const numHorsFrance = this.extractDepartement(nir);
    if (numHorsFrance !== 99) {
      const departement = nir.substr(5, 5);
      let params = new HttpParams().set('code', departement);
      const fields = ['nom'];
      params = params.set('fields', fields.toString());
      return this.http.get<Commune>(this.API_URL + 'communes', {params}).pipe();
    }
  }


  getCodeSecuriteSocial(nir: string) {
    const civilite = this.leftPad(this.extractCivilite(nir), 1);
    const anneeNaissance = this.leftPad(this.extractAnneeNaissance(nir), 2);
    const moisNaissance = this.leftPad(this.getMoisNaissance(nir), 2);
    const departement = this.leftPad(this.extractDepartement(nir), 2);
    const commune = this.leftPad(this.extractCommune(nir), 3);
    const ordre = this.leftPad(this.extractOrdre(nir), 3);

    const numero = civilite + anneeNaissance + moisNaissance + departement + commune + ordre;

    const result = (97 - (parseInt(numero, 10) % 97));
    return result < 10 ? '0' + result : result;
  }


}
