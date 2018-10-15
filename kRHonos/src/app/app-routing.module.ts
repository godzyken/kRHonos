import {RouterModule, Routes, Router} from '@angular/router';
import {SalarieListComponent} from './components/salarie/salarie-list/salarie-list.component';
import {NgModule} from '@angular/core';
import {AccueilComponent} from './components/accueil/accueil.component';
import {PlanningComponent} from './components/planning/planning.component';
import {AbsencesComponent} from './components/absences/absences.component';
import {SalarieFormComponent} from "./components/salarie/salarie-form/salarie-form.component";
import {SalarieTestComponent} from './components/salarie/salarie-test/salarie-test.component';
import {ContratComponent} from "./components/contrat/contrat.component";

const routes: Routes = [
  {path: '', component: AccueilComponent},
  {path: 'salarie', component: SalarieListComponent},
  {path: 'salarie/new', component: SalarieFormComponent},
  {path: 'salarie/test', component: SalarieTestComponent},
  {path: 'planning', component: PlanningComponent},
  {path: 'absences', component: AbsencesComponent},
  {path: 'contrat/:id', component: ContratComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
