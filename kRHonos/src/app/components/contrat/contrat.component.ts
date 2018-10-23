<<<<<<< HEAD
<<<<<<< guillaume_dev
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
=======
=======
>>>>>>> master
import {Component, OnInit} from '@angular/core';
import {Salarie} from '../../modeles/salarie';
import {ActivatedRoute, Router} from '@angular/router';
import {SalarieService} from '../../controllers/salarie.service';
import {Etablissement} from '../../modeles/etablissement';
import {EtablissementService} from '../../controllers/etablissement.service';
<<<<<<< HEAD
>>>>>>> conception de contrat-etablissement
=======

>>>>>>> master

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
  etablissement: Etablissement;

  etablissement: Etablissement;

  constructor(private route: ActivatedRoute,
              private salarieService: SalarieService,
<<<<<<< HEAD
<<<<<<< guillaume_dev
<<<<<<< guillaume_dev
=======
              private etablissementService: EtablissementService,
>>>>>>> master
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
<<<<<<< HEAD
=======
  constructor() {
  }

  ngOnInit() {
>>>>>>> comit autogodzy
=======
              private router: Router) { }
=======
              private etablissementService: EtablissementService,
              private router: Router) {
  }
>>>>>>> conception de contrat-etablissement

  ngOnInit() {
    this.salarie = new Salarie();
    const salarie_id = this.route.snapshot.params['id'];
    this.salarieService.getSalarie(+salarie_id).toPromise().then(
      (salarie: Salarie) => {
        this.salarie = salarie;
      }
    );
<<<<<<< guillaume_dev
>>>>>>> comit autogodzy form contrat
=======
=======

>>>>>>> master

    this.etablissement = new Etablissement();
    const etab_id = this.route.snapshot.params['id'];
    this.etablissementService.getEtablissement(+etab_id).toPromise().then(
      (etablissement: Etablissement) => {
        this.etablissement = etablissement;
      }
    );
<<<<<<< HEAD
>>>>>>> conception de contrat-etablissement
=======
>>>>>>> master
  }

}
