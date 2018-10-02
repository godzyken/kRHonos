import {RouterModule, Routes, Router } from '@angular/router';
import {SalarieListComponent} from './components/salarie/salarie-list/salarie-list.component';
import {NgModule} from '@angular/core';
import {AccueilComponent} from './components/accueil/accueil.component';
import {PlanningComponent} from './components/planning/planning.component';
import {AbsencesComponent} from './components/absences/absences.component';

const routes: Routes = [
  { path: '', component: AccueilComponent },
  { path: 'salarie', component: SalarieListComponent },
  { path: 'planning', component: PlanningComponent },
  { path: 'absences', component: AbsencesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
