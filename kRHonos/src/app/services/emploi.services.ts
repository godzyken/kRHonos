import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Emploi} from '../models/emploi';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmploiServices {
  private baseUrl = 'http://localhost:9007/api/contrat';
  private newEmploiUrl = 'http://localhost:9008/api/contrat/create';

  constructor(private http: HttpClient) {

  }

  getEmploi(id: number): Observable<object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getEmploiList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  createNewEmploi(emploiNew: Emploi) {
    this.http.post(`${this.newEmploiUrl}`, emploiNew);
  }
}
