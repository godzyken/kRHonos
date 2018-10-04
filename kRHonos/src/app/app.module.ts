import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { SalarieListComponent } from './components/salarie/salarie-list/salarie-list.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatTableModule,
  MatPaginatorModule,
  MatSortModule,
  MatToolbarModule,
  MatButtonModule,
  MatSidenavModule,
  MatListModule,
  MatCardModule,
  MatGridListModule,
  MatMenuModule,
  MatFormFieldModule, MatInputModule, MatIconModule
} from '@angular/material';
import { MainNavComponent } from './components/dashboard/main-nav/main-nav.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MainDashComponent } from './components/dashboard/main-dash/main-dash.component';
import { PlanningComponent } from './components/planning/planning.component';
import { AbsencesComponent } from './components/absences/absences.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import {SalarieFormComponent} from './components/salarie/salarie-form/salarie-form.component';

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
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
