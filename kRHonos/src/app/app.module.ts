import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
<<<<<<< Updated upstream
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
=======
import { FormsModule } from '@angular/forms';
>>>>>>> Stashed changes

import { AppComponent } from './app.component';
import { SalarieListComponent } from './components/salarie/salarie-list/salarie-list.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
<<<<<<< Updated upstream
  MatTableModule,
  MatPaginatorModule,
=======
  MatPaginatorModule,
  MatTableModule,
>>>>>>> Stashed changes
  MatSortModule,
  MatToolbarModule,
  MatButtonModule,
  MatSidenavModule,
<<<<<<< Updated upstream
  MatListModule,
  MatCardModule,
  MatGridListModule,
  MatMenuModule,
  MatFormFieldModule, MatInputModule, MatIconModule, MatRadioModule, MatStepperModule, MatDatepickerModule
=======
  MatIconModule,
  MatListModule,
  MatCardModule,
  MatGridListModule,
  MatMenuModule, MatDialogModule, MatDatepickerModule
>>>>>>> Stashed changes
} from '@angular/material';
import { MainNavComponent } from './components/dashboard/main-nav/main-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MainDashComponent } from './components/dashboard/main-dash/main-dash.component';
import { PlanningComponent } from './components/planning/planning.component';
import { AbsencesComponent } from './components/absences/absences.component';
import { AccueilComponent } from './components/accueil/accueil.component';
<<<<<<< Updated upstream
import {SalarieFormComponent} from './components/salarie/salarie-form/salarie-form.component';
import {SalarieTestComponent} from './components/salarie/salarie-test/salarie-test.component';

import {MAT_MOMENT_DATE_FORMATS, MomentDateAdapter} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
=======
import { PlanningDialogComponent } from './components/planning-dialog/planning-dialog.component';
import { CalendarModule } from "primeng/primeng";
>>>>>>> Stashed changes

@NgModule({
  declarations: [
    AppComponent,
    SalarieListComponent,
    SalarieFormComponent,
    MainNavComponent,
    MainDashComponent,
    PlanningComponent,
    AbsencesComponent,
    AccueilComponent,
<<<<<<< Updated upstream
    SalarieTestComponent,
=======
    PlanningDialogComponent
>>>>>>> Stashed changes
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatPaginatorModule,
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
<<<<<<< Updated upstream
    MatFormFieldModule,
    MatInputModule,
    MatRadioModule,
    MatStepperModule,
    MatDatepickerModule,
    ReactiveFormsModule
  ],
  providers: [
    {provide: MAT_DATE_LOCALE, useValue: 'fr-FR'},
    {provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE]},
    {provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS},
  ],
=======
    MatDialogModule,
    CalendarModule,
    MatDatepickerModule,
  ],
  providers: [],
  entryComponents: [PlanningDialogComponent],
>>>>>>> Stashed changes
  bootstrap: [AppComponent]
})
export class AppModule { }
