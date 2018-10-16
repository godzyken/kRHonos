import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {Planning} from '../modeles/planning';
import * as moment from 'moment';
import {Constants} from './constants';

@Injectable({
  providedIn: 'root'
})
export class PlanningService {

  private baseUrl = 'http://localhost:9005/api/planning';

  constructor(private http: HttpClient) {
  }

  // @ calendar object
  calendarObject(_this) {
    const _ths = this;
    return {
      editable: true,
      schedulerLicenseKey: Constants.SCHEDULER_LICENSE_KEY,
      header: _ths.getHeader(),
      defaultView: 'agendaWeek',
      height: 640,
      selectable: true,
      selectHelper: true,
      locale: 'fr',
      timeFormat: 'H:mm',
      slotLabelFormat: 'H:mm',
      allDaySlot: false,
      eventSources: [
        {
          url: 'http://localhost:9005/api/planning',
          type: 'GET',
          dataType: 'json',
          cache: true,
          data: {
            custom_param1: 'something',
            custom_param2: 'somethingelse'
          },
          error: function () {
            alert('there was an error while fetching events!');
          },
          // color: 'yellow',   // a non-ajax option
          textColor: 'white' // a non-ajax option
        }
        // any other sources...
      ],
      select(start, end) {
        const testEvent = new Planning();
        testEvent.start = start;
        testEvent.end = end;
        _this.addEvent(start, end);
        // _ths.saveEvent(testEvent).subscribe(data => console.log(data), error => console.log(error));
      },
      eventClick(calEvent, jsEvent, view) {
        console.log(calEvent);
        _this.eventClick(calEvent);
      },
      eventResize(event, delta, revertFunc) {
        _this.eventResize(event);
      },
      eventDrop(event, delta, revertFunc) {
        _this.eventDrop(event);
      },
      eventRender: function (event) {
        if (event.ranges) {
          return (event.ranges.filter(function (range) { // test event against all the ranges

            return (event.start.isBefore(range.end) &&
              event.end.isAfter(range.start));

          }).length) > 0;
        }
      },
      selectOverlap: function (event) {
        if ((event.ranges.filter(function (range) {
          if (range.end === undefined) {
            range.end = '2100/12/31';
          }
          return (event.start.isBefore(moment.utc(range.end, 'YYYY-MM-DD')) &&
            event.end.isAfter(moment.utc(range.start, 'YYYY-MM-DD')));

        }).length) > 0) {
          return false;
        } else {
          return true;
        }
      },
      /*
      eventOverlap(stillEvent, movingEvent) {
        return stillEvent.allDay && movingEvent.allDay;
      },
      */
    };
  }

  // Afficher la liste de tous les horaires
  /*
  listEvent(): Observable<any> {
    let data: any = this.http.get('${this.baseUrl}');
    console.log(data);
    return data;
  }
  */

  // Enregistrer un horaire
  saveEvent(event: Object): Observable<Object> {
    const _ths = this;
    return this.http.post(`${this.baseUrl}` + `/create`, event);
  }

  // Supprimer un horaire
  deleteEvent(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text'});
  }

  // Mise à jour d'un horaire
  updateEvent(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  // @ header for calendar
  // @ we have added custom header
  // @ so passing blank empty
  getHeader() {
    const data = {
      left: '',
      center: '',
      right: ''
    };
    return data;
  }
}
