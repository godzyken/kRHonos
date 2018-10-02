import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs/internal/Observable';
import {SalarieService} from '../../../controllers/salarie.service';
import {Salarie} from '../../../modeles/salarie';

@Component({
  selector: 'app-salarie-list',
  templateUrl: './salarie-list.component.html',
  styleUrls: ['./salarie-list.component.scss']
})
export class SalarieListComponent implements OnInit {

  salaries: Observable<Salarie[]>;

  constructor(private salarieService: SalarieService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.salaries = this.salarieService.getSalarieList();
  }

}
