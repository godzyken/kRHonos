import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Nominatim} from '../modeles/nominatim';

@Injectable({
  providedIn: 'root'
})


export class NominatimService {

  private API_NOMINATIM = 'https://nominatim.openstreetmap.org/';
  private  SEPARATOR = '@@';

  constructor(private http: HttpClient) {
  }

  getLatitude(address: string) {
    return parseFloat(address.substring(0, address.indexOf(this.SEPARATOR)));
  }

  getLongitude(address: string){
    return parseFloat(address.substring((address.indexOf(this.SEPARATOR) + this.SEPARATOR.length), address.length));
  }


  getAddressSearch(addressSearch: string): Observable<Nominatim[]> {
    const params = new HttpParams().set('format', 'json')
      .set('q', addressSearch)
      .set('addressdetails', '1')
      .set('countrycodes', 'fr');

    return this.http.get<Nominatim[]>(this.API_NOMINATIM + 'search', {params}).pipe();
  }
}
