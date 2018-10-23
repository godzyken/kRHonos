import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs/internal/Observable';
import {SalarieService} from '../../../controllers/salarie.service';
import {Salarie} from '../../../models/salarie';
import {Router} from "@angular/router";
import {MatExpansionModule} from '@angular/material/expansion';
import {MatTableModule} from '@angular/material/table';
import {animate, state, style, transition, trigger} from '@angular/animations';

@Component({
  selector: 'app-salarie-list',
  templateUrl: './salarie-list.component.html',
  styleUrls: ['./salarie-list.component.scss'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0', display: 'none'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})

export class SalarieListComponent implements OnInit {

  salaries: Observable<Salarie[]>;
  columnsToDisplay = ['nom', 'nomNaissance', 'prenom', 'mail'];
  columnsTile = ['Nom', 'Nom de naissance', 'Prénom', 'Mail'];
  expandedElement: Salarie;

  constructor(private salarieService: SalarieService,
              private router: Router) {
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.salaries = this.salarieService.getSalarieList();
  }

  onNewSalarie() {
    this.router.navigate(['/salarie', 'new']);
  }

  onNewContrat(id: number) {
    this.router.navigate(['/contrat', id]);
  }

}
