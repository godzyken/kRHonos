import {Address} from './address';

export interface Nominatim {
  display_name: string;
  lat: string;
  lon: string;
  address: Address;
}
