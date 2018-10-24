import {Component, Input} from '@angular/core';
import {FormGroup} from '@angular/forms';

import {QuestionBase} from '../../../../models/contrat-question/question-base';

@Component({
  selector: 'app-question',
  templateUrl: './contrat-form-question.component.html'
})
export class ContratFormQuestionComponent {
  @Input() question: QuestionBase<any>;
  @Input() form: FormGroup;

  get isValid() {
    return this.form.controls[this.question.key].valid;
  }
}
