import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {NominatimService} from '../../../controllers/nominatim.service';
import {Nominatim} from '../../../modeles/nominatim';

@Component({
  selector: 'app-salarie-test',
  templateUrl: './salarie-test.component.html',
  styleUrls: ['./salarie-test.component.scss']
})
export class SalarieTestComponent implements OnInit {

  firstFormGroup: FormGroup;
  nominatimList: Nominatim[];

  constructor(private _formbuilder: FormBuilder,
              private nominatimService: NominatimService) {
  }

  ngOnInit() {
    this.firstFormGroup = this._formbuilder.group({
      addressSearch: [''],
      addressSelected: ['', [Validators.required]],
    });
  }

  onClickSearch() {
    const addressSearch = this.firstFormGroup.get('addressSearch').value;

    this.nominatimService.getAddressSearch(addressSearch).subscribe(nominatim => this.nominatimList = nominatim);

    this.firstFormGroup.patchValue({
      'addressSearch': '',
      'addressSelected': '',
    });

  }

}
