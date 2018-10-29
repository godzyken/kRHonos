import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";

@Injectable()
export class AuthService {

  baseUrl: 'http://localhost:8080/email2sms/';

  constructor(private http: HttpClient) {
  }

  attemptAuth(username: string, password: string): Observable {
    const credentials = {
      username: username, password: password
    };
    console.log('attemptAuth ::');

    return this.http.post('http://localhost:8080/token/generate-token', credentials);

  }

}
