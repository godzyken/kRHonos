import {Component, OnInit} from '@angular/core';
import {FamilySituation} from '../../../models/familySituation';
import {FamilySituationService} from '../../../services/family-situation.service';

@Component({
  selector: 'app-salarie-test',
  templateUrl: './salarie-test.component.html',
  styleUrls: ['./salarie-test.component.scss']
})
export class SalarieTestComponent implements OnInit {

  familySituation: FamilySituation[];

  constructor(private familySituationService: FamilySituationService) {
  }

  ngOnInit() {
    this.familySituationService.getFamilySituationList().subscribe(familySituation => this.familySituation = familySituation);
  }


}
