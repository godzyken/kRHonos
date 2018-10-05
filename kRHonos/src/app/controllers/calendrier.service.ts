import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Calendar} from 'fullcalendar';

@Injectable({
  providedIn: 'root'
})
export class CalendrierService {

  private baseUrl = 'http://localhos:9005/api/calendar';

  constructor(private http: HttpClient) {
  }

  getCanlendrier(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  getCalendrierJour(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }


}
