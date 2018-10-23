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
  etablissement: Etablissement;

  constructor(private route: ActivatedRoute,
              private salarieService: SalarieService,
              private etablissementService: EtablissementService,
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

    this.etablissement = new Etablissement();
    const etab_id = this.route.snapshot.params['id'];
    this.etablissementService.getEtablissement(+etab_id).toPromise().then(
      (etablissement: Etablissement) => {
        this.etablissement = etablissement;
      }
    );
  }

}
