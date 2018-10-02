import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { FullCalendarModule } from 'ng-fullcalendar';

@Injectable({
  providedIn: 'root'
})
export class PlanningService {

  private baseUrl = 'http://localhost:9005/api/planning';

  constructor(private http: HttpClient) { }

  listEvent(): Observable<any> {
    let data: any = this.http.get(`${this.baseUrl}`);
    console.log(data);
    return data;
  }

  getEvents(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  public getEvents2(): Observable<any> {
    const dateObj = new Date();
    const yearMonth = dateObj.getUTCFullYear() + '-' + (dateObj.getUTCMonth() + 1);
    const data: any = [
      {
        id: 5,
        title: 'Test',
        start: '2018-10-01 10:00',
        end: '2018-10-01 11:45'
      },
      {
        id: 6,
        title: 'Test2',
        start: '2018-10-03 15:30',
        end: '2018-10-03 16:45'
      },
    ];
    return of(data);
  }
  getPlanningList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
