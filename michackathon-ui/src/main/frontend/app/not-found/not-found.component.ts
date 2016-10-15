import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'michackathon-not-found',
  templateUrl: './not-found.component.html',
  styleUrls: ['./not-found.component.scss']
})
export class NotFoundComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
    console.log('route not found');
  }

}
