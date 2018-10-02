import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {SalarieService} from "../../../controllers/salarie.service";
import {Router} from "@angular/router";
import {Salarie} from "../../../modeles/salarie";

@Component({
  selector: 'app-salarie-form',
  templateUrl: './salarie-form.component.html',
  styleUrls: ['./salarie-form.component.scss']
})
export class SalarieFormComponent implements OnInit {

  salarieForm: FormGroup;

  constructor(private formBuilder: FormBuilder,
              private salarieService: SalarieService,
              private router: Router,
  ) {
  }

  ngOnInit() {
    this.initForm();
  }

  initForm() {
    this.salarieForm = this.formBuilder.group({
      name: ['', Validators.required],
    });
  }

  onSaveSalarie() {
    const salarie = {} as Salarie;

    salarie.nom = this.salarieForm.get('nom').value;
    salarie.nomNaissance = 'nomNaissance';
    salarie.prenom = this.salarieForm.get('prenom').value;
    salarie.numSecu = this.salarieForm.get('numSecu').value;
    salarie.cleSecu = this.salarieForm.get('cleSecu').value;
    salarie.adresse = this.salarieForm.get('cleSecu').value;
    salarie.codePostal = this.salarieForm.get('codePostal').value;
    salarie.ville = this.salarieForm.get('ville').value;
    salarie.telephone = this.salarieForm.get('telephone').value;
    salarie.mail = this.salarieForm.get('mail').value;
    salarie.dateNaissance = this.salarieForm.get('dateNaissance').value;
    salarie.cpNaissance = this.salarieForm.get('cpNaissance').value;
    salarie.villeNaissance = this.salarieForm.get('villeNaissance').value;
    salarie.dateEntree = this.salarieForm.get('dateEntree').value;
    salarie.civilite = this.salarieForm.get('civilite').value;
    salarie.situationFam = this.salarieForm.get('situationFam').value;
    salarie.active = this.salarieForm.get('situationFam').value;


    this.salarieService.createNewSalarie(salarie);

    this.router.navigate(['/salarie'])


  }

}
