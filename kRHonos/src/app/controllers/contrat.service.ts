import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Contrat} from '../modeles/contrat';

@Injectable({
  providedIn: 'root'
})
export class ContratService {

  private baseUrl = 'http://localhost:9007/api/contrat';
  private newContratUrl = 'http://localhost:9007/api/contrat-service/create';

  constructor(private http: HttpClient) {
  }

  getContrat(id: number): Observable<object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getContratList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  createNewContrat(contratNew: Contrat) {
    this.http.post(`${this.newContratUrl}`, contratNew);
  }
}
