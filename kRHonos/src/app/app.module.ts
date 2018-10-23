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
  MatExpansionModule, MAT_DATE_LOCALE, DateAdapter, MAT_DATE_FORMATS,
} from '@angular/material';
import { MainNavComponent } from './components/dashboard/main-nav/main-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MainDashComponent } from './components/dashboard/main-dash/main-dash.component';
import { AbsencesComponent } from './components/absences/absences.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import {SalarieFormComponent} from './components/salarie/salarie-form/salarie-form.component';
import {SalarieTestComponent} from './components/salarie/salarie-test/salarie-test.component';
import {ClockPickerDirective} from './models/clockpicker.directive';
import {ContratComponent} from './components/contrat/contrat.component';
import {ContratFormComponent} from './components/contrat/contrat-form/contrat-form.component';
import {ContratFormQuestionComponent} from './components/contrat/contrat-form/contrat-form-question/contrat-form-question.component';
import {OWL_DATE_TIME_LOCALE, OwlDateTimeModule, OwlNativeDateTimeModule} from 'ng-pick-datetime';
import {MAT_MOMENT_DATE_FORMATS, MomentDateAdapter} from '@angular/material-moment-adapter';
import {PlanningViewComponent} from './components/planning/planning-view/planning-view.component';



@NgModule({
  declarations: [
    AppComponent,
    SalarieListComponent,
    SalarieFormComponent,
    MainNavComponent,
    MainDashComponent,
    AbsencesComponent,
    AccueilComponent,
    PlanningViewComponent,
    ClockPickerDirective,
    SalarieTestComponent,
    ContratComponent,
    ContratFormComponent,
    ContratFormQuestionComponent,
    ContratFormQuestionComponent
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
    OwlNativeDateTimeModule
  ],
  providers: [
    {provide: MAT_DATE_LOCALE, useValue: 'fr-FR'},
    {provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},
    {provide: OWL_DATE_TIME_LOCALE, useValue: 'fr'},
  ],
  exports: [MatTableModule],
  entryComponents: [PlanningViewComponent],
  bootstrap: [AppComponent]
})
export class AppModule {}
