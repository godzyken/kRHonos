import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Nominatim} from '../modeles/nominatim';

@Injectable({
  providedIn: 'root'
})
export class NominatimService {

  private API_NOMINATIM = 'https://nominatim.openstreetmap.org/';

  constructor(private http: HttpClient) {
  }


  getAddressSearch(addressSearch: string): Observable<Nominatim[]> {
    const params = new HttpParams().set('format', 'json')
      .set('q', addressSearch)
      .set('addressdetails', '1')
      .set('countrycodes', 'fr');

    return this.http.get<Nominatim[]>(this.API_NOMINATIM + 'search', {params}).pipe();
  }
}
