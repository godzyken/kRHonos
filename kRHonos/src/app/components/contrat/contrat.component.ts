<<<<<<< HEAD
import {Component, OnInit} from '@angular/core';
import {Salarie} from '../../modeles/salarie';
import {ActivatedRoute, Router} from '@angular/router';
import {SalarieService} from '../../controllers/salarie.service';
import {Etablissement} from '../../modeles/etablissement';
import {EtablissementService} from '../../controllers/etablissement.service';
=======
import { Component, OnInit } from '@angular/core';
import {Salarie} from "../../modeles/salarie";
import {ActivatedRoute, Router} from "@angular/router";
import {SalarieService} from "../../controllers/salarie.service";
>>>>>>> master

@Component({
  selector: 'app-contrat',
  templateUrl: './contrat.component.html',
  styleUrls: ['./contrat.component.scss']
})
export class ContratComponent implements OnInit {

  salarie: Salarie;
<<<<<<< HEAD
  etablissement: Etablissement;

  constructor(private route: ActivatedRoute,
              private salarieService: SalarieService,
              private etablissementService: EtablissementService,
              private router: Router) {
  }

  ngOnInit() {
    this.salarie = new Salarie();
    const salarie_id = this.route.snapshot.params['id'];
    this.salarieService.getSalarie(+salarie_id).toPromise().then(
=======

  constructor(private route: ActivatedRoute,
              private salarieService: SalarieService,
              private router: Router) { }

  ngOnInit() {
    this.salarie = new Salarie();
    const id = this.route.snapshot.params['id'];
    this.salarieService.getSalarie(+id).toPromise().then(
>>>>>>> master
      (salarie: Salarie) => {
        this.salarie = salarie;
      }
    );
<<<<<<< HEAD

    this.etablissement = new Etablissement();
    const etab_id = this.route.snapshot.params['id'];
    this.etablissementService.getEtablissement(+etab_id).toPromise().then(
      (etablissement: Etablissement) => {
        this.etablissement = etablissement;
      }
    );
=======
>>>>>>> master
  }

}
