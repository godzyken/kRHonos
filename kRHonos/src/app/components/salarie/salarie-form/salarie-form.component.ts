import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {SalarieService} from '../../../controllers/salarie.service';
import {Router} from '@angular/router';
import {Salarie} from '../../../modeles/salarie';
import * as moment from 'moment';


@Component({
  selector: 'app-salarie-form',
  templateUrl: './salarie-form.component.html',
  styleUrls: ['./salarie-form.component.scss'],
})
export class SalarieFormComponent implements OnInit {


  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;



  myPatternName = '^([a-z]+[,.]?[ ]?|[a-z]+[\'-]?)+$';
  myPatternSecu = new RegExp('^(/?[12])(/?[0-9]{2}(?:0[1-9]|1[0-2]))(/?2[AB]|[0-9]{2})(/?[0-9]{6})(/?[0-9]{2})?$');
  // 253072A07300483

  constructor(private _formBuilder: FormBuilder,
              private salarieService: SalarieService,
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
      numSecu: ['253072A07300483', [Validators.required, Validators.pattern(this.myPatternSecu)]]
    });

    this.secondFormGroup = this._formBuilder.group({
      civilite: ['', Validators.required],
      dateNaissance: [moment(), Validators.required],

    });
  }

  onClickDisplaySecondForm(){
    const dateNaissance =  this.secondFormGroup.get(['dateNaissance']).value;
    dateNaissance.year(1986);
    this.secondFormGroup.setValue(dateNaissance);
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
    const nameObject = (name === 'civilite' ? this.firstFormGroup.get(['civilite']) : null);

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

  onCheckedCivilite(value: number) {
    const numSecu = this.firstFormGroup.get(['numSecu']).value;
    if (numSecu !== '') {
      return value === parseInt(numSecu.charAt(0), 10);
    }
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

    this.salarieService.createNewSalarie(salarie);

    this.router.navigate(['/salarie']);


  }

}
