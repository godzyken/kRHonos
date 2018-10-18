import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {FamilySituation} from '../modeles/familySituation';

@Injectable({
  providedIn: 'root'
})
export class FamilySituationService {

  private URL_ADDRESS = 'http://localhost:9006/api/';

  constructor(private http: HttpClient) {
  }

  getFamilySituationList(): Observable<FamilySituation[]> {
    return this.http.get<FamilySituation[]>(this.URL_ADDRESS + 'familySituations').pipe();
  }
}
