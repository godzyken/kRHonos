import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import { PlanningService } from '../../../controllers/planning.service';
import * as $ from 'jquery';

import { Planning } from '../../../models/planning';
import * as moment from 'moment';

@Component({
  selector: 'app-planning-dialog',
  templateUrl: './planning-dialog.component.html',
  styleUrls: ['./planning-dialog.component.scss']
})

export class PlanningDialogComponent implements OnInit {

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
      this.testEvent.range_start = new Date(moment(addEvent.startDate.getTime()).format('YYYY-MM-DD'));
      this.testEvent.recurrent = parseInt(moment(addEvent.startDate.getTime()).format('e'));
      this.testEvent.frequency = parseInt(this.selected);
      this.adMyEvent(this.testEvent);

    } else {
      // cas d'un update
      this.eventService.updateEvent(this.data.id, {
        start: moment(this.data.startDate).format('YYYY-MM-DD[T]HH:mm:ss'),
        end: moment(this.data.endDate).format('YYYY-MM-DD[T]HH:mm:ss'),})
        .subscribe();
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
    this.eventService.saveEvent(e).subscribe(data => this.addEvent(data), error => console.log(error));
  }

  updateEvent(e) {
    this.dltEvent(e.id);
    this.addEvent(e);
  }

  // affiche le nouvel élément dans le calendrier
  addEvent (e) {
    e.start = moment(e.range_start + ' ' + e.start);
    e.end = moment(e.range_start + ' ' + e.end);
    console.log(e);
    (<any>this.myCalendar).fullCalendar( 'renderEvent', e);
  }

  dltEvent(id) {
    (<any>this.myCalendar).fullCalendar('removeEvents', id);
  }

  semaines = [
    {value: '1', viewValue: 'toutes les semaines'},
    {value: '2', viewValue: 'toutes les 2 semaines'},
    {value: '3', viewValue: 'toutes les 3 semaines'},
    {value: '4', viewValue: 'toutes les 4 semaines'},
    {value: '5', viewValue: 'toutes les 5 semaines'},
  ];

  selected = '1';
}
