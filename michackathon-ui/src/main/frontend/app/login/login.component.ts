import {Component, OnInit} from '@angular/core';
import {AuthService} from '../shared/auth/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'michackathon-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {


  username = 'admin';
  password = 'xxxxxx';
  message = '';

  constructor(public authService: AuthService, public router: Router) {
  }

  logMeIn() {
    console.log('LogMeIn');
    this.authService
      .authenticate(this.username, this.password)
      .catch(errorMessage => this.message = errorMessage)
      .then(() => {
        if (this.authService.isAuthenticated()) {
          this.router.navigate(['']);
        }
      });

  }

  ngOnInit(): any {
    console.log('hello `Login` component');
  }
}
