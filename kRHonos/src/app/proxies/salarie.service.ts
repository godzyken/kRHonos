import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Salarie} from '../models/salarie';

@Injectable({
  providedIn: 'root'
})
export class SalarieService {

  private baseUrl = 'http://localhost:9006/api/salaried';
  private newSalarieUrl = 'http://localhost:9006/api/salarie/create';

  constructor(private http: HttpClient) {
  }

  getSalarie(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getSalarieList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  createNewSalarie(salarieNew: Salarie) {
    this.http.post(`${this.newSalarieUrl}`, salarieNew);
  }
}
