import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Etablissement} from '../models/etablissement';

@Injectable({
  providedIn: 'root'
})
export class EtablissementService {

  private baseUrl = 'http://localhost:9008/api/etablissement';
  private newEtabUrl = 'http://localhost:9008/api/etablissement/create';

  constructor(private http: HttpClient) {

  }

  getEtablissement(id: number): Observable<object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getEtablissementList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  createNewEtablissement(etabNew: Etablissement) {
    this.http.post(`${this.newEtabUrl}`, etabNew);
  }
}
