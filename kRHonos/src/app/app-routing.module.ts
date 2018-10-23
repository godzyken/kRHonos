import {RouterModule, Routes, Router} from '@angular/router';
import {SalarieListComponent} from './components/salarie/salarie-list/salarie-list.component';
import {NgModule} from '@angular/core';
import {AccueilComponent} from './components/accueil/accueil.component';
import {PlanningViewComponent} from './components/planning/planning-view/planning-view.component';
import {AbsencesComponent} from './components/absences/absences.component';
import {SalarieFormComponent} from './components/salarie/salarie-form/salarie-form.component';
import {SalarieTestComponent} from './components/salarie/salarie-test/salarie-test.component';
<<<<<<< HEAD
<<<<<<< guillaume_dev
import {ContratComponent} from "./components/contrat/contrat.component";
=======
import {ContratComponent} from './components/contrat/contrat.component';
>>>>>>> comit autogodzy form contrat
=======
import {ContratComponent} from './components/contrat/contrat.component';
>>>>>>> master

const routes: Routes = [
  {path: '', component: AccueilComponent},
  {path: 'salarie', component: SalarieListComponent},
  {path: 'salarie/new', component: SalarieFormComponent},
  {path: 'salarie/test', component: SalarieTestComponent},
  {path: 'planning', component: PlanningViewComponent},
  {path: 'absences', component: AbsencesComponent},
  {path: 'contrat/:id', component: ContratComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
