<<<<<<< guillaume_dev
import {Component, OnInit} from '@angular/core';
<<<<<<< guillaume_dev
import {Salarie} from '../../modeles/salarie';
import {ActivatedRoute, Router} from '@angular/router';
import {SalarieService} from '../../controllers/salarie.service';
=======
>>>>>>> comit autogodzy
=======
import { Component, OnInit } from '@angular/core';
import {Salarie} from '../../modeles/salarie';
import {ActivatedRoute, Router} from '@angular/router';
import {SalarieService} from '../../controllers/salarie.service';
>>>>>>> comit autogodzy form contrat

@Component({
  selector: 'app-contrat',
  templateUrl: './contrat.component.html',
  styleUrls: ['./contrat.component.scss']
})
export class ContratComponent implements OnInit {

<<<<<<< guillaume_dev
<<<<<<< guillaume_dev
=======
>>>>>>> comit autogodzy form contrat
  salarie: Salarie;

  constructor(private route: ActivatedRoute,
              private salarieService: SalarieService,
<<<<<<< guillaume_dev
              private router: Router) {
  }

  ngOnInit() {
    this.salarie = {} as Salarie;
    const id = this.route.snapshot.params['id'];
    this.salarieService.getSalarie(+id).toPromise().then(
      (salarie: Salarie) => {
        this.salarie = salarie;
      }
    );
=======
  constructor() {
  }

  ngOnInit() {
>>>>>>> comit autogodzy
=======
              private router: Router) { }

  ngOnInit() {
    this.salarie = new Salarie();
    const id = this.route.snapshot.params['id'];
    this.salarieService.getSalarie(+id).toPromise().then(
      (salarie: Salarie) => {
        this.salarie = salarie;
      }
    );
>>>>>>> comit autogodzy form contrat
  }

}
