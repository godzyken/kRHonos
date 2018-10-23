import {Component} from '@angular/core';
import {QuestionService} from './controllers/question.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [QuestionService]
})

export class AppComponent {
  title = 'kRHonos';
  description = 'Angular-SpringBoot';

  questions: any[];

  constructor(service: QuestionService) {
    this.questions = service.getQuestions();
  }
}
