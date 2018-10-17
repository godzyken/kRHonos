import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {SalarieService} from '../../../controllers/salarie.service';
import {Router} from '@angular/router';
import {Salarie} from '../../../modeles/salarie';
import * as moment from 'moment';
import {NirService} from '../../../controllers/nir.service';
import {Commune} from '../../../modeles/commune';
import {Subscription} from 'rxjs';


@Component({
  selector: 'app-salarie-form',
  templateUrl: './salarie-form.component.html',
  styleUrls: ['./salarie-form.component.scss'],
})
export class SalarieFormComponent implements OnInit {


  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;

  communeNaissance: Commune;


  cleSecu: string;

  myPatternName = '^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+[\'-]?)+$';
  myPatternSecu = new RegExp('^(/?[12])(/?[0-9]{2}(?:0[1-9]|1[0-2]))(/?2[AB]|[0-9]{2})(/?[0-9]{6})?$');

  // 253072A00400483

  constructor(private _formBuilder: FormBuilder,
              private salarieService: SalarieService,
              private nirService: NirService,
              private router: Router,
  ) {
  }

  ngOnInit() {
    this.onInit();
  }


  onInit() {
    this.firstFormGroup = this._formBuilder.group({
      nom: ['toto', [Validators.required, Validators.minLength(2), Validators.pattern(this.myPatternName)]],
      prenom: ['tata', [Validators.required, Validators.minLength(2), Validators.pattern(this.myPatternName)]],
      nomNaissance: ['', [Validators.minLength(2), Validators.pattern(this.myPatternName)]],
      email: ['toto@dqsd.ssd', [Validators.required, Validators.email]],
      numSecu: ['253072A004004', [Validators.required, Validators.pattern(this.myPatternSecu)]]
    });

    this.secondFormGroup = this._formBuilder.group({
      civilite: ['', Validators.required],
      dateNaissance: [moment(), Validators.required],
    });

    this.thirdFormGroup = this._formBuilder.group({
      adresse: ['', [Validators.required]]
    });
  }

  onClickDisplaySecondForm() {

    const nir = this.firstFormGroup.get(['numSecu']).value;

    this.getCommuneNaissance(nir);

    const dateNaissance = moment([
      this.nirService.getAnneeNaissance(nir),
      this.nirService.getMoisNaissance(nir) - 1
    ]);

    this.cleSecu = '' + this.nirService.getCodeSecuriteSocial(nir);

    this.secondFormGroup.patchValue({
      'civilite': this.nirService.getCivilite(nir),
      'dateNaissance': dateNaissance,
    });
  }


  onClickDisplayThirdForm() {
    console.log(this.communeNaissance);
  }

  getCommuneNaissance(nir: string) {
    this.nirService.getCommune(nir).subscribe(commune => this.communeNaissance = commune[0]);
  }

  getErrorNumSecu() {
    const numSecu = this.firstFormGroup.get(['numSecu']);
    return numSecu.hasError('required') ? 'Le numéro de sécurité social est obligatoire' :
      numSecu.hasError('pattern') ? 'Le format du numéro de sécurité social n\'est pas conforme' :
        '';
  }


  getErrorNameMessage(name: string) {
    const nameObject = (
      name === 'nom' ? this.firstFormGroup.get(['nom']) :
        name === 'prénom' ? this.firstFormGroup.get(['prenom']) :
            null);
    if (nameObject !== null) {
      return nameObject.hasError('required') ? 'Vous devez entrer un ' + name :
        nameObject.hasError('pattern') ? 'le ' + name + ' n\'est pas au bon format' :
          !nameObject.hasError('minLength') ? 'le ' + name + ' est trop court' :
            '';
    }
    return '';
  }

  getErrorNameOnlyRequired(name: String) {
    const nameObject = (name === 'civilite' ? this.secondFormGroup.get(['civilite']) : null);


    if (nameObject !== null) {
      return nameObject.hasError('required') ? 'Vous devez saisir le champs ' + name : '';
    }
  }


  getErrorNomNaissanceMessage() {
    const nameObject = this.firstFormGroup.get(['nomNaissance']);
    if (nameObject.value !== '') {
      return !nameObject.hasError('minLength') ? 'le nom de naissance est trop court' :
        '';
    }

  }

  getErrorMailMessage() {
    const nameObject = this.firstFormGroup.get(['email']);
    return nameObject.hasError('required') ? 'une adresse mail est requise' :
      nameObject.hasError('email') ? 'Vous devez entrer une adresse mail valide' :
        '';
  }


  onSaveSalarie() {
    const salarie = {} as Salarie;

    salarie.nom = this.firstFormGroup.get(['nom']).value;
    salarie.nomNaissance = this.firstFormGroup.get(['nomNaissance']).value;
    salarie.prenom = this.firstFormGroup.get(['prenom']).value;
    salarie.cleSecu = this.firstFormGroup.get(['cleSecu']).value;
    salarie.mail = this.firstFormGroup.get(['email']).value;

    salarie.civilite = this.secondFormGroup.get(['civilite']).value;
    salarie.dateNaissance = this.secondFormGroup.get(['dateNaissance']).value;
    salarie.villeNaissance = this.communeNaissance.nom;
    salarie.cleSecu = parseInt(this.cleSecu, 10);

    this.salarieService.createNewSalarie(salarie);

    this.router.navigate(['/salarie']);


  }

}
