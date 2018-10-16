import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import {
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatDialogModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatCheckboxModule
} from '@angular/material';
import { CalendarModule } from 'primeng/primeng';
import { PlanningViewComponent } from './planning-view.component';
import { PlanningDialogComponent } from '../planning-dialog/planning-dialog.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatButtonModule,
    MatDialogModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatCheckboxModule,
    CalendarModule
  ],
  declarations: [
    PlanningViewComponent,
    PlanningDialogComponent
  ],
  entryComponents: [
    PlanningDialogComponent
  ]
})
export class PlanningViewModule {
}
