import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs/internal/Observable';
import {SalarieService} from '../../../controllers/salarie.service';
import {Salarie} from '../../../modeles/salarie';
import {Router} from "@angular/router";

@Component({
  selector: 'app-salarie-list',
  templateUrl: './salarie-list.component.html',
  styleUrls: ['./salarie-list.component.scss']
})
export class SalarieListComponent implements OnInit {

  salaries: Observable<Salarie[]>;

  constructor(private salarieService: SalarieService,
              private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.salaries = this.salarieService.getSalarieList();
  }

  onNewSalarie(){
    this.router.navigate(['/salarie', 'new']);
  }

}
