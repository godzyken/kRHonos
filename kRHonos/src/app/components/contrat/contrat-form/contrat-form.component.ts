import {Component, Input, OnInit} from '@angular/core';
import {FormGroup} from '@angular/forms';
import {QuestionBase} from '../../../modeles/question-base';
import {QuestionControlService} from '../../../modeles/question-control.service';

@Component({
  selector: 'app-contrat-form',
  templateUrl: './contrat-form.component.html',
  providers: [QuestionControlService]
})
export class ContratFormComponent implements OnInit {

  @Input() questions: QuestionBase<any>[] = [];
  form: FormGroup;
  payLoad = '';

  constructor(private qcs: QuestionControlService) {
  }

  ngOnInit() {
    this.form = this.qcs.toFormGroup(this.questions);
  }

  onSubmit() {
    this.payLoad = JSON.stringify(this.form.value);
  }
}
