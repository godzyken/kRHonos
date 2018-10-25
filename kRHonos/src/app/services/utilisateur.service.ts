import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({'Content-type': 'application/json'})
};

@Injectable()
export class UtilisateurService {

  private userUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) {
  }

  public getUsers(): Observable {
    return this.http.get(this.userUrl + '/users');
  }

}
