import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'michackathon-access-denied',
  templateUrl: './access-denied.component.html',
  styleUrls: ['./access-denied.component.scss']
})
export class AccessDeniedComponent implements OnInit {

  constructor() {
  }

  ngOnInit(): any {
    console.log('access denied');
  }


}
