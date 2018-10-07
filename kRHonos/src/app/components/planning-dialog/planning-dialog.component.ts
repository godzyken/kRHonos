import { Component, OnInit, ViewChild, Inject,  ElementRef } from '@angular/core';
import {FormControl} from '@angular/forms';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import { PlanningService } from '../../controllers/planning.service';
import * as $ from 'jquery';

import { HttpClient } from '@angular/common/http';
import { Planning } from '../../modeles/planning';
import * as moment from 'moment';

@Component({
  selector: 'app-planning-dialog',
  templateUrl: './planning-dialog.component.html',
  styleUrls: ['./planning-dialog.component.scss']
})

export class PlanningDialogComponent implements OnInit {

  private baseUrl = 'http://localhost:9005/api/planning';

  edit: boolean;
  calendarOptions;
  time = {};
  myCalendar = $('#calendar');
  testEvent = new Planning();

  constructor(
    public dialogRef: MatDialogRef<PlanningDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    protected eventService: PlanningService,
    private http: HttpClient) {
  }

  ngOnInit() {

  }

  closeDialog(): void {
    this.dialogRef.close();
  }

  addUpdateEvent(addEvent) {
    let obj = {
      title: addEvent.title,
      start: addEvent.startDate.getTime(),
      end: addEvent.endDate ? addEvent.endDate.getTime() : null,
    };
    let obj2 = Object.assign({}, obj);
    this.testEvent.start = obj.start;
    this.testEvent.end = obj.end;
    this.adMyEvent2(this.testEvent);
    console.log(obj2);
    // this.eventService.listEvent();
  }

  addUpdateEvent2(addEvent) {

    let eventData = JSON.parse(localStorage.getItem('eventData'));

    if (addEvent) {
      let obj = {
        id: Date.now().toString(36) + '-' + Math.random().toString(36),
        title: addEvent.title,
        start: addEvent.startDate.getTime(),
        end: addEvent.endDate ? addEvent.endDate.getTime() : null,
        type: addEvent.type,
        color:  this.eventService.eventColor(addEvent.type)
      };

      //console.log(obj);
      let obj2 = Object.assign({}, obj);
      this.testEvent.start = obj.start;
      this.testEvent.end = obj.end;
      eventData.push(obj);
      this.adMyEvent2(this.testEvent);
      console.log(obj2);
    } else {
      eventData.forEach((obj) => {
        if (obj.id === this.data.id) {

          let startDate = this.data.startDate.value,
            endDate = this.data.endDate.value;
          obj.title = this.data.title;
          obj.color = this.eventService.eventColor(this.data.type);
          obj.start = this.data.startDate.getTime();
          obj.end = this.data.endDate ? this.data.endDate.getTime() : '';
          obj.type = this.data.type;
          obj.allDay = this.data.allDay;
          let obj2 = Object.assign({}, obj);
          this.updateEvent(obj2);
        }
      });
    }
    localStorage.setItem('eventData', JSON.stringify(eventData));
  }

  deleteEvent(id) {
    if(confirm('Are you sure to delete')) {
      let eventData = JSON.parse(localStorage.getItem('eventData'));
      eventData.forEach((o, i) => {
        if (o.id === this.data.id) {
          this.dltEvent(o.id);
          eventData.splice(i, 1);
        }
      });
      localStorage.setItem('eventData', JSON.stringify(eventData));
      this.closeDialog();
    }
  }

  addEvent (e) {
    (<any>this.myCalendar).fullCalendar( 'renderEvent', e);
  }

  adMyEvent(e) {
    e.start = moment(e.start).format('YYYY-MM-DD HH:mm:ss');
    e.end = moment(e.end).format('YYYY-MM-DD HH:mm:ss');
    this.addEvent(e);
  }

  adMyEvent2(e) {
    e.start = moment(e.start).format('YYYY-MM-DD[T]HH:mm:ss');
    e.end = moment(e.end).format('YYYY-MM-DD[T]HH:mm:ss');
    this.eventService.saveEvent(e).subscribe(data => console.log(data), error => console.log(error));
    // this.testEvent = new Planning();
  }

  dltEvent(id) {
    (<any>this.myCalendar).fullCalendar('removeEvents', id);
  }

  updateEvent(e) {
    this.dltEvent(e.id);
    this.adMyEvent(e);
  }
}
