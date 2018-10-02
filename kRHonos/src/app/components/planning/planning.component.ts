import {Component, OnInit, ViewChild} from '@angular/core';
import {Options} from 'fullcalendar';
import {Planning} from '../../modeles/planning';
import {Observable} from 'rxjs';
import {CalendarComponent} from 'ng-fullcalendar';
import {PlanningService} from '../../controllers/planning.service';
import * as moment from 'moment';

@Component({
  selector: 'app-planning',
  templateUrl: './planning.component.html',
  styleUrls: ['./planning.component.scss']
})
export class PlanningComponent implements OnInit {
  calendarOptions: Options;
  displayEvent: any;
  events: any;
  plannings: Observable<Planning[]>;
  tests: any[];
  @ViewChild(CalendarComponent) ucCalendar: CalendarComponent;

  constructor(protected planningService: PlanningService) {}

  ngOnInit() {
    this.reloadData();
    this.planningService.getPlanningList().subscribe(data => {
      this.calendarOptions = {
        editable: true,
        eventLimit: false,
        selectable: true,
        selectHelper: true,
        locale: 'fr',
        defaultView: 'agendaWeek',
        allDaySlot: false,
        timeFormat: 'H:mm',
        slotLabelFormat: 'H:mm',
        header: {
          left: 'prev, next, today',
          center: 'title',
          right: '',
          // right: 'month, agendaWeek, agendaDay, listMonth'
        },
        events: data
      };
    });
  }
  reloadData() {

  }
  clickButton(model: any) {
    this.displayEvent = model;
  }
  eventClick(model: any) {
    model = {
      event: {
        id: model.event.id,
        start: model.event.start,
        end: model.event.end,
        title: model.event.title,
        allDay: model.event.allDay
        // other params
      },
      duration: {}
    };
    this.displayEvent = model;
  }
  updateEvent(model: any) {
    model = {
      event: {
        id: model.event.id,
        start: model.event.start,
        end: model.event.end,
        title: model.event.title
        // other params
      },
      duration: {
        _data: model.duration._data
      }
    };
    this.displayEvent = model;
  }
  dayClick(model: any) {
    // console.log(model);
  }
  selectPeriode(model: any) {
    console.log(model.id + ' - ' + moment(model.start).format());
    /*
    this.tests.push(model.start);
    for(let test of this.tests) {
      console.log(test + ' - test');
    }
    */
  }
  eventRender(model: any) {
    // this.events = model;
    console.log(model.start + ' - ' + model.end);
  }
}
