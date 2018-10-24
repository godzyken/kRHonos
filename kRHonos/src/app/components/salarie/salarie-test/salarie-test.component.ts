import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-salarie-test',
  templateUrl: './salarie-test.component.html',
  styleUrls: ['./salarie-test.component.scss']
})
export class SalarieTestComponent implements OnInit {

  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  isOptional = false;

  myPatternName = new RegExp('^([a-z]+[,.]?[ ]?|[a-z]+[\'-]?)+$');

  constructor(private _formbuilder: FormBuilder) {
  }

  ngOnInit() {
    this.firstFormGroup = this._formbuilder.group({
      name: ['', [Validators.required, Validators.pattern(this.myPatternName)]]
    });
    this.secondFormGroup = this._formbuilder.group({
      secondCtrl: ''
    });
  }

  getErrorMessage() {
    const name = 'nom';
    const nameObject = this.firstFormGroup.get(['name']);

    return nameObject.hasError('required') ? 'Vous devez entrer un ' + name :
      nameObject.hasError('pattern') ? 'le ' + name + ' n\'est pas au bon format' :
          '';
  }

}
