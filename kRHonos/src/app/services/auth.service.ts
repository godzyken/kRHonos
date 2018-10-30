import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class AuthService {

  baseUrl: 'http://localhost:8080/email2sms/';

  constructor(private http: HttpClient) {
  }

  attemptAuth(username: string, password: string): Observable {
    const credentials = {username: username, password: password};
    console.log('attempAuth ::');
    return this.http.post('http://localhost:8080/token/generate-token', credentials);
  }

}
