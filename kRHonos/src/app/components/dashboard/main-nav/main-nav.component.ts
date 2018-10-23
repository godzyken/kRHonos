import {Component, OnInit} from '@angular/core';
import {BreakpointObserver, Breakpoints, BreakpointState} from '@angular/cdk/layout';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {MatSidenavModule, MatButtonModule, MatIconModule} from '@angular/material';

@Component({
  selector: 'app-components/dashboard/main-nav',
  templateUrl: './main-nav.component.html',
  styleUrls: ['./main-nav.component.css']
})
export class MainNavComponent implements OnInit {
  sidenavWidth = 4;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

  constructor(private breakpointObserver: BreakpointObserver) {
  }

  ngOnInit() {
  }

  increase() {
    this.sidenavWidth = 15;
  }

  decrease() {
    this.sidenavWidth = 4;
  }

}
