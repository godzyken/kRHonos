import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {SalarieService} from '../../../controllers/salarie.service';
import {Router} from '@angular/router';
import {Salarie} from '../../../modeles/salarie';
import * as moment from 'moment';
import {NirService} from '../../../controllers/nir.service';
import {Commune} from '../../../modeles/commune';
import {Subscription} from 'rxjs';
import {NominatimService} from '../../../controllers/nominatim.service';
import {Nominatim} from '../../../modeles/nominatim';
import {FamilySituation} from '../../../modeles/familySituation';
import {FamilySituationService} from '../../../controllers/family-situation.service';


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
  nominatimList: Nominatim[];
  familySituationList: FamilySituation[];

  cleSecu: string;


  myPatternName = '^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+[\'-]?)+$';
  myPatternSecu = new RegExp('^(/?[12])(/?[0-9]{2}(?:0[1-9]|1[0-2]))(/?2[AB]|[0-9]{2})(/?[0-9]{6})?$');
  myPatternPhone = new RegExp('^[0-9]{10}$');


  constructor(private _formBuilder: FormBuilder,
              private salarieService: SalarieService,
              private nirService: NirService,
              private router: Router,
              private nominatimService: NominatimService,
              private familySituationService: FamilySituationService
  ) {
  }

  ngOnInit() {
    this.onInit();
  }


  onInit() {

    this.familySituationService.getFamilySituationList().subscribe(data => this.familySituationList = data);

    this.firstFormGroup = this._formBuilder.group({
      nom: ['toto', [Validators.required, Validators.minLength(2), Validators.pattern(this.myPatternName)]],
      prenom: ['tata', [Validators.required, Validators.minLength(2), Validators.pattern(this.myPatternName)]],
      nomNaissance: ['', [Validators.minLength(2), Validators.pattern(this.myPatternName)]],
      email: ['toto@dqsd.ssd', [Validators.required, Validators.email]],
      numSecu: ['253072A004004', [Validators.required, Validators.pattern(this.myPatternSecu)]],
      situationFamiliale: [1, [Validators.required]],
      telephone: ['0456523548', [Validators.pattern(this.myPatternPhone), Validators.required]],
    });

    this.secondFormGroup = this._formBuilder.group({
      civilite: ['', Validators.required],
      dateNaissance: [moment(), Validators.required],
    });

    this.thirdFormGroup = this._formBuilder.group({
      addressSearch: [''],
      addressSelected: ['', [Validators.required]],
      number: ['', Validators.required],
      complement: [''],
    });
  }

  onClickDisplaySecondForm() {

    const nir = this.firstFormGroup.get(['numSecu']).value;
    console.log(this.familySituationList[0]);
    console.log(this.firstFormGroup.get(['situationFamiliale']).value);

    // const getFamily = JSON.parse(this.firstFormGroup.get(['familySituation']).value);
    // const familySit = {id: getFamily['id'], libelle: getFamily['libelle']} as FamilySituation;


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

  onClickSearch() {
    const addressSearch = this.thirdFormGroup.get('addressSearch').value;

    this.nominatimService.getAddressSearch(addressSearch).subscribe(nominatim => this.nominatimList = nominatim);

    this.thirdFormGroup.patchValue({
      'addressSearch': '',
      'addressSelected': '',
      'number': '',
      'complement': '',
    });

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
          name === 'téléphone' ? this.firstFormGroup.get(['telephone']) :
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
    let nameObject = null;
    let champs = null;

    if (name === 'number') {
      nameObject = this.thirdFormGroup.get('number');
      champs = 'Numéro';
    } else if (name === 'civilite') {
      nameObject = this.thirdFormGroup.get('civilite');
      champs = 'Civilité';
    } else if (name === 'familySituation') {
      nameObject = this.firstFormGroup.get('situationFamiliale');
      champs = 'situation familiale';
    }

    if (nameObject !== null) {
      return nameObject.hasError('required') ? 'Vous devez saisir le champs ' + champs : '';
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


  onClickSaveSalarie() {
    const salarie = {} as Salarie;

    salarie.nom = this.firstFormGroup.get(['nom']).value;
    salarie.nomNaissance = this.firstFormGroup.get(['nomNaissance']).value;
    salarie.prenom = this.firstFormGroup.get(['prenom']).value;
    salarie.cleSecu = this.firstFormGroup.get(['cleSecu']).value;
    salarie.mail = this.firstFormGroup.get(['email']).value;

    const getFamily = JSON.parse(this.firstFormGroup.get(['familySituation']).value);
    const familySit = {id: getFamily['id'], libelle: getFamily['libelle']} as FamilySituation;

    salarie.situationFam = familySit;

    salarie.telephone = this.firstFormGroup.get(['telephone']).value;

    salarie.civilite = this.secondFormGroup.get(['civilite']).value;
    salarie.dateNaissance = this.secondFormGroup.get(['dateNaissance']).value;
    salarie.villeNaissance = this.communeNaissance.nom;
    salarie.cleSecu = parseInt(this.cleSecu, 10);

    salarie.adresseLatitude = this.nominatimService.getLatitude(this.thirdFormGroup.get('addressSelected').value);
    salarie.adresseLongitude = this.nominatimService.getLongitude(this.thirdFormGroup.get('addressSelected').value);
    salarie.adresseNumero = this.thirdFormGroup.get('number').value;
    salarie.adresseComplement = this.thirdFormGroup.get('complement').value;

    // this.salarieService.createNewSalarie(salarie);

    // this.router.navigate(['/salarie']);

    console.log('FINI');


  }

}
