import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AbsenceService {

  private baseUrl = 'http://localhost:9005/api/absences';

  constructor(private http: HttpClient) { }

  getAbsence(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createAbsence(absence: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}` + `/create`, absence);
  }


}
