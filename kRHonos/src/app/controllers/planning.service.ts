import { Inject, Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Planning } from '../modeles/planning';
import * as moment from 'moment';
import * as $ from 'jquery';
import {Constants} from "./constants";
import {PlanningComponent} from "../components/planning/planning.component";

@Injectable({
  providedIn: 'root'
})
export class PlanningService {

  private baseUrl = 'http://localhost:9005/api/planning';

  constructor(private http: HttpClient) { }

  // @ calendar object
  calendarObject(_this) {

    let _ths = this;
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
      // events: this.localData(),
      /*
      eventSources: [
        {
          url: 'http://localhost:9005/api/planning',
          type: 'GET',
          dataType: 'json',
          data: {
            custom_param1: 'something',
            custom_param2: 'somethingelse'
          },
          error: function() {
            alert('there was an error while fetching events!');
          },
          // color: 'yellow',   // a non-ajax option
          textColor: 'white' // a non-ajax option
        }
        // any other sources...
      ],
      */
      select(start, end) {
        let testEvent = new Planning();
        testEvent.start = start;
        testEvent.end = end;
        _this.addEvent(start, end);
        // _ths.saveEvent(testEvent).subscribe(data => console.log(data), error => console.log(error));
      },
      events: [{
        title:"My repeating event",
        start: '10:00', // a start time (10am in this example)
        end: '14:00', // an end time (2pm in this example)
        dow: [ 1, 4 ], // Repeat monday and thursday
        ranges: [{start: "2018/10/10", end: "2018/11/30"},]
      }],
      eventClick(calEvent, jsEvent, view) {
        _this.eventClick(calEvent);
      },
      eventResize(event, delta, revertFunc) {
        _this.eventResize(event);
      },
      eventDrop(event, delta, revertFunc) {
        _this.eventDrop(event);
      },
      selectOverlap(event) {
        return event.rendering === 'background' ;
      },
      eventOverlap(stillEvent, movingEvent) {
        return stillEvent.allDay && movingEvent.allDay;
      },
      eventRender(event){
        return (event.ranges.filter(function(range){ // test event against all the ranges

          return (event.start.isBefore(range.end) &&
            event.end.isAfter(range.start));

        }).length)>0; //if it isn't in one of the ranges, don't render it (by returning false)
      },
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
    let _ths = this;
    return this.http.post(`${this.baseUrl}` + `/create`, event);
  }

  // Supprimer un horaire
  deleteEvent(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  // Mise à jour d'un horaire
  updateEvent(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  // @ header for calendar
  // @ we have added custom header
  // @ so passing blank empty
  getHeader() {
    let data = {
      left: '',
      center: '',
      right: ''
    };
    return data;
  }

  private localData(){
    return[{
      id: '10',
      start: '2018-10-10 08:00',
      end: '2018-10-10 10:00',
      dow: [3],
      recurstart: moment("2018-10-10").startOf("week"),
      ranges: [{
        start: moment('2018-10-10','YYYY-MM-DD'),
        end: moment('2018-11-01','YYYY-MM-DD').endOf('month'),
      },],
    }]
  }
}
