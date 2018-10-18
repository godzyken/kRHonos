import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
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
  MatCheckboxModule,
  MatFormFieldModule,
  MatInputModule,
  MatRadioModule,
  MatStepperModule,
  MatExpansionModule,
} from '@angular/material';
import { MainNavComponent } from './components/dashboard/main-nav/main-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MainDashComponent } from './components/dashboard/main-dash/main-dash.component';
<<<<<<< guillaume_dev
<<<<<<< guillaume_dev
import { PlanningViewComponent } from './components/planning/planning-view/planning-view.component';
=======
import { PlanningComponent } from './components/planning/planning.component';
>>>>>>> Auto stash before merge of "master" and "origin/master"
=======
import { PlanningViewComponent } from './components/planning/planning-view/planning-view.component';
>>>>>>> comit autogodzy form contrat
import { AbsencesComponent } from './components/absences/absences.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import {SalarieFormComponent} from './components/salarie/salarie-form/salarie-form.component';
import {SalarieTestComponent} from './components/salarie/salarie-test/salarie-test.component';
<<<<<<< guillaume_dev
<<<<<<< guillaume_dev
import { PlanningDialogComponent } from './components/planning/planning-dialog/planning-dialog.component';
import { ClockPickerDirective } from "./modeles/clockpicker.directive";
import { OwlDateTimeModule, OwlNativeDateTimeModule, OWL_DATE_TIME_LOCALE } from "ng-pick-datetime";
import {MAT_MOMENT_DATE_FORMATS, MomentDateAdapter} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import { ContratComponent } from './components/contrat/contrat.component';
=======
=======
import { PlanningDialogComponent } from './components/planning/planning-dialog/planning-dialog.component';
>>>>>>> comit autogodzy
import { ClockPickerDirective } from './modeles/clockpicker.directive';
import { OwlDateTimeModule, OwlNativeDateTimeModule, OWL_DATE_TIME_LOCALE } from 'ng-pick-datetime';
import {MAT_MOMENT_DATE_FORMATS, MomentDateAdapter} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
<<<<<<< guillaume_dev
<<<<<<< guillaume_dev
import { ContratComponent } from './components/contrat/contrat.component';
import {PlanningDialogComponent} from './components/planning/planning-dialog/planning-dialog.component';
>>>>>>> Auto stash before merge of "master" and "origin/master"

=======
import { ContratComponent} from './components/contrat/contrat.component';
>>>>>>> comit autogodzy
=======
import { ContratComponent } from './components/contrat/contrat.component';
<<<<<<< guillaume_dev
// import { ContratFormComponent } from './components/contrat/contrat-form/contrat-form.component';
// import { ContratFormQuestionComponent } from './components/contrat/contrat-form/contrat-form-question/contrat-form-question.component';

>>>>>>> comit autogodzy form contrat
=======
import { ContratFormComponent } from './components/contrat/contrat-form/contrat-form.component';
import { ContratFormQuestionComponent } from './components/contrat/contrat-form/contrat-form-question/contrat-form-question.component';
import { Etablissement} from './modeles/etablissement';
>>>>>>> conception de contrat-etablissement

@NgModule({
  declarations: [
    AppComponent,
    SalarieListComponent,
    SalarieFormComponent,
    MainNavComponent,
    MainDashComponent,
    PlanningViewComponent,
    AbsencesComponent,
    AccueilComponent,
    PlanningDialogComponent,
    ClockPickerDirective,
    SalarieTestComponent,
    ContratComponent,
    ContratFormComponent,
    ContratFormQuestionComponent,
    Etablissement
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
    MatFormFieldModule,
    MatInputModule,
    MatRadioModule,
    MatStepperModule,
    MatDatepickerModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatCheckboxModule,
    MatDatepickerModule,
    MatExpansionModule,
    OwlDateTimeModule,
    OwlNativeDateTimeModule,
    ReactiveFormsModule,
  ],
  providers: [
    {provide: MAT_DATE_LOCALE, useValue: 'fr-FR'},
    {provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},
    {provide: OWL_DATE_TIME_LOCALE, useValue: 'fr'},
  ],
  exports: [MatTableModule],
  entryComponents: [PlanningDialogComponent],
  bootstrap: [AppComponent]
})
export class AppModule {}
