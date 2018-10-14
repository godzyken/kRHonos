import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { SalarieListComponent } from './components/salarie/salarie-list/salarie-list.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatPaginatorModule,
  MatTableModule,
  MatSortModule,
  MatToolbarModule,
  MatButtonModule,
  MatSidenavModule,
  MatIconModule,
  MatListModule,
  MatCardModule,
  MatGridListModule,
  MatMenuModule,
  MatDialogModule,
  MatDatepickerModule,
  MatSelectModule,
  MatCheckboxModule
} from '@angular/material';
import { MainNavComponent } from './components/dashboard/main-nav/main-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MainDashComponent } from './components/dashboard/main-dash/main-dash.component';
import { PlanningComponent } from './components/planning/planning.component';
import { AbsencesComponent } from './components/absences/absences.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import { PlanningDialogComponent } from './components/planning-dialog/planning-dialog.component';
import { ClockPickerDirective } from "./modeles/clockpicker.directive";
import { OwlDateTimeModule, OwlNativeDateTimeModule, OWL_DATE_TIME_LOCALE } from "ng-pick-datetime";

@NgModule({
  declarations: [
    AppComponent,
    SalarieListComponent,
    MainNavComponent,
    MainDashComponent,
    PlanningComponent,
    AbsencesComponent,
    AccueilComponent,
    PlanningDialogComponent,
    ClockPickerDirective
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatPaginatorModule,
    MatSelectModule,
    MatSortModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    MatGridListModule,
    MatMenuModule,
    MatDialogModule,
    MatCheckboxModule,
    MatDatepickerModule,
    OwlDateTimeModule,
    OwlNativeDateTimeModule,
  ],
  exports: [],
  providers: [
    {provide: OWL_DATE_TIME_LOCALE, useValue: 'fr'},
  ],
  entryComponents: [PlanningDialogComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
