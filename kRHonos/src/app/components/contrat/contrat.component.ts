import {Etablissement} from '../../models/etablissement';
import {EtablissementService} from '../../services/etablissement.service';
import {Component, OnInit} from '@angular/core';
import {Salarie} from '../../models/salarie';
import {ActivatedRoute, Router} from '@angular/router';
import {SalarieService} from '../../services/salarie.service';


@Component({
  selector: 'app-contrat',
  templateUrl: './contrat.component.html',
  styleUrls: ['./contrat.component.scss']
})
export class ContratComponent implements OnInit {

  salarie: Salarie;
  emploi: Emploi;
  etablissement: Etablissement;

  constructor(private route: ActivatedRoute,
              private salarieService: SalarieService,
              private etablissementService: EtablissementService,
              private emploiService: EmploiServices,
              private router: Router) {
  }

  ngOnInit() {
    // initialiser les champs de données de la table salarié
    this.salarie = {} as Salarie;
    const id = this.route.snapshot.params['id'];
    this.salarieService.getSalarie(+id).toPromise().then(
      (salarie: Salarie) => {
        this.salarie = salarie;
      }
    );

    // initialiser les champs de données de la table Etablissement
    this.etablissement = new Etablissement();
    const etab_id = this.route.snapshot.params['id'];
    this.etablissementService.getEtablissement(+etab_id).toPromise().then(
      (etablissement: Etablissement) => {
        this.etablissement = etablissement;
      }
    );

    // initialiser les champs de données de la table Emploi
    this.emploi = new Emploi();
    const emploi_id = this.route.snapshot.params['id'];
    this.emploiService.getEmploi(+emploi_id).toPromise().then(
      (emploi: Emploi) => {
        this.emploi = emploi;
      }
    );
  }

}
