import { Component, OnInit, ViewChild, Inject,  ElementRef } from '@angular/core';
import {FormControl} from '@angular/forms';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import { PlanningService } from '../../controllers/planning.service';
import * as $ from 'jquery';

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
  myCalendar = $('#calendar');
  testEvent = new Planning();

  constructor(
    public dialogRef: MatDialogRef<PlanningDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    protected eventService: PlanningService) {
  }

  ngOnInit() { }

  closeDialog(): void {
    this.dialogRef.close();
  }

  addUpdateEvent(addEvent) {

    if (addEvent) {
      this.testEvent.start = addEvent.startDate.getTime();
      this.testEvent.end = addEvent.endDate.getTime();
      this.adMyEvent(this.testEvent);

    } else {
      // cas d'un update
      console.log('toto');
      this.eventService.updateEvent(this.data.id, {
        start: moment(this.data.startDate).format('YYYY-MM-DD[T]HH:mm:ss'),
        end: moment(this.data.endDate).format('YYYY-MM-DD[T]HH:mm:ss'),})
        .subscribe(data => {
          console.log(data);
          this.data = data as Planning;
        },
          error => console.log(error));
      this.data.start = this.data.startDate;
      this.data.end = this.data.endDate;
      this.updateEvent(this.data);
    }
  }

  deleteEvent(id) {
    if(confirm('Voulez-vous vraiment supprimer cet horaire ?')) {

      console.log(this.data.id + ' - test');
      this.eventService.deleteEvent(this.data.id).subscribe(
        data => console.log(data), error => console.log(error));

      this.closeDialog();
      this.dltEvent(this.data.id);
    }
  }

  adMyEvent(e) {
    e.start = moment(e.start).format('YYYY-MM-DD[T]HH:mm:ss');
    e.end = moment(e.end).format('YYYY-MM-DD[T]HH:mm:ss');
    this.eventService.saveEvent(e).subscribe(data => console.log(data), error => console.log(error));
    this.addEvent(e);
  }

  updateEvent(e) {
    this.dltEvent(e.id);
    this.addEvent(e);
  }

  // affiche le nouvel élément dans le calendrier
  addEvent (e) {
    console.log(e);
    (<any>this.myCalendar).fullCalendar( 'renderEvent', e);
  }

  dltEvent(id) {
    (<any>this.myCalendar).fullCalendar('removeEvents', id);
  }
}
