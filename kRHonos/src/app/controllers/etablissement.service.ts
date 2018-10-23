import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
<<<<<<< HEAD
=======
import {Etablissement} from '../modeles/etablissement';
>>>>>>> master

@Injectable({
  providedIn: 'root'
})
export class EtablissementService {

<<<<<<< HEAD
  private baseUrl = 'http://localhost:9006/api/etablissement';
  private newEtabUrl = 'http://localhost:9006/api/etablissement/create';
=======
  private baseUrl = 'http://localhost:9008/api/etablissement';
  private newEtabUrl = 'http://localhost:9008/api/etablissement/create';
>>>>>>> master

  constructor(private http: HttpClient) {

  }

  getEtablissement(id: number): Observable<object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getEtablissementList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

<<<<<<< HEAD
=======
  createNewEtablissement(etabNew: Etablissement) {
    this.http.post(`${this.newEtabUrl}`, etabNew);
  }

>>>>>>> master
}
