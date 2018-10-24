import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import {CalendarView} from "../calendar/calendar-view";
import * as $ from 'jquery';
import 'fullcalendar-scheduler';

@Component({
  selector: 'app-absences',
  templateUrl: './absence.component.html',
  styleUrls: ['./absence.component.scss']
})
export class AbsenceComponent implements OnInit {

  defaultView = 'month';
  public calendarTitle;

  constructor(
    protected calendarView: CalendarView) {
  }

  ngOnInit() {
    const calendar = (< any > $('#calendar'));
    calendar.fullCalendar(this.calendarView.calendarObject(this));
  }

  //@ Changer la date du calendrier
  nextPre(a) {
    let fullcalendar = ( < any > $('#calendar'));
    switch (a) {
      case "n":
        fullcalendar.fullCalendar('next');
        break;

      case "p":
        fullcalendar.fullCalendar('prev');
        break;

      default:
        alert("Please select next or previous")
        break;
    }
  }

}
