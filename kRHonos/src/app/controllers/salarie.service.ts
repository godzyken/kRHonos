import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Salarie} from '../modeles/salarie';

@Injectable({
  providedIn: 'root'
})
export class SalarieService {

  private baseUrl = 'http://localhost:9006/api/salaried';

  constructor(private http: HttpClient) { }

  getSalarie(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }
  getSalarieList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
