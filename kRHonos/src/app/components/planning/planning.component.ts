import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material';
import {PlanningDialogComponent} from '../planning-dialog/planning-dialog.component';
import {PlanningService} from '../../controllers/planning.service';
import * as $ from 'jquery';
import 'fullcalendar-scheduler';
import * as moment from 'moment';
import {Planning} from "../../modeles/planning";

@Component({
  selector: 'app-planning',
  templateUrl: './planning.component.html',
  styleUrls: ['./planning.component.scss']
})
export class PlanningComponent implements OnInit {
  data = {};
  public calendarTitle: string;

  constructor(
    protected eventService: PlanningService,
    public dialog: MatDialog) {
  }

  ngOnInit() {
    const calendar = (< any > $('#calendar'));
    calendar.fullCalendar(this.eventService.calendarObject(this));
  }

  // @ move calendar to next and previous date
  nextPre(a) {
    let fullcalendar = (< any > $('#calendar'));
    switch (a) {
      case 'n':
        fullcalendar.fullCalendar('next');
        break;

      case 'p':
        fullcalendar.fullCalendar('prev');
        break;

      default:
        alert('Please select next or previous');
        break;
    }
  }

  update() {
    let fullcalendar = (< any > $('#calendar'));
    fullcalendar.fullCalendar('refetchEvents');
  }

  // @ edit event
  eventClick(model: any) {

      let _startDate = moment(model.start).format('YYYY-MM-DD[T]HH:mm:ss');
      let _startClock = moment(model.start).format('HH:mm');
      let _endDate = moment(model.end).format('YYYY-MM-DD[T]HH:mm:ss');
      let _endClock = moment(model.end).format('HH:mm');

    model = {
      id: model.id,
      start: model.start,
      startDate: _startDate,
      startClock: _startClock,
      end: model.end,
      endDate: _endDate,
      endClock: _endClock,
      title: model.title,
      allDay: model.allDay,
      type: model.type
    };
    this.openDialog(model);
  }

  // @ resize event
  eventResize(model) {
    model = this.initModel(model);
    this.eventService.updateEvent(model.event.id, {
      start: moment(model.event.start).format('YYYY-MM-DD[T]HH:mm:ss'),
      end: moment(model.event.end).format('YYYY-MM-DD[T]HH:mm:ss'),})
      .subscribe(data => {
        console.log(data);
        this.data = data as Planning;
      },);
  }

  // @ drag and drop event
  eventDrop(e) {
    this.eventService.updateEvent(e.id, {
      start: moment(e.start).format('YYYY-MM-DD[T]HH:mm:ss'),
      end: moment(e.end).format('YYYY-MM-DD[T]HH:mm:ss'),})
      .subscribe(data => {
        console.log(data);
        this.data = data as Planning;
      },);
  }

  initModel(model) {
    model = {
      event: {
        id: model.id,
        start: model.start,
        end: model.end,
        title: model.title
      }
    };
    return model;
  }

  // @ open dialog and pass object
  openDialog(model) {
    this.dialog.open(PlanningDialogComponent, {
      data: model
    });
  }

  // @ add new event
  addEvent(start, end) {
    let isOpened = document.getElementsByClassName('mat-dialog-container');
    if (isOpened.length === 0) {
      let data = {
        title: '',
        new: true,
        startDate: new Date(start.format()),
        endDate: new Date(end.format()),
        allDay: false
      };
      this.openDialog(data);
    }
  }
}
