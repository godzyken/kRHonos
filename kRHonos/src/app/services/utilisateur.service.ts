import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Utilisateur} from '../models/salaried/utilisateur';

const httpOptions = {
  headers: new HttpHeaders({'Content-type': 'application/json'})
};

@Injectable()
export class UtilisateurService {

  private utilisateurUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) {
  }

  public getUtilisateur(): Observable<Utilisateur> {
    return this.http.get(this.utilisateurUrl + '/utilisateurs');
  }


}
