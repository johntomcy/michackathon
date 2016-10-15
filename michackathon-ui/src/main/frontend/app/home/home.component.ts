import {Component, OnInit} from '@angular/core';
import {AuthService} from '../shared/auth/auth.service';
import {TitleService} from './shared/title.service';

@Component({
  selector: 'michackathon-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  angularLogo = 'assets/img/angular-logo.png';

  data = {value: ''};

  constructor(public authService: AuthService, public titleService: TitleService) {

  }

  ngOnInit() {
    console.log('hello `Home` component');
    this.titleService.getData().subscribe(data => this.data = data);
  }
}
