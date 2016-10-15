import {Injectable} from '@angular/core';
import {Http, Headers} from '@angular/http';
import {AppMenuItem} from '../../app.menu';

@Injectable()
export class AuthService {

  private authenticated: boolean = false;
  private tokenExpirationDate: Date = null;
  private userData: any = null;

  // @LocalStorage()
  private tokenData: Oauth2TokenData;

  public static decodeAccessToken(access_token: string) {
    return JSON.parse(window.atob(access_token.split('.')[1]));
  }

  constructor(public http: Http) {
    this.tokenData = JSON.parse(localStorage.getItem('tokenData'));
    if (this.tokenData && this.tokenData.access_token) {
      this.authenticated = true;
      this.userData = AuthService.decodeAccessToken(this.tokenData.access_token);
      this.tokenExpirationDate = new Date(this.userData.exp * 1000);
      if (this.authenticated && this.tokenExpirationDate < new Date()) {
        console.log('Session timeout');
        this.logout();
      }
    }
  }

  public isAuthenticated(): boolean {
    this.checkTokenExpirationDate();
    return this.authenticated;
  }

  public authenticate(username: string, password: string): Promise<string> {

    console.log('Authentication pending...');

    return new Promise<string>((resolve, reject) => {

      if (!username.trim()) {
        reject('Username cannot be blank');
      }
      if (!password.trim()) {
        reject('Password cannot be blank');
      }

      let basicAuthHeader = btoa(`acme:acmesecret`);

      let headers = new Headers();
      headers.append('Authorization', `Basic  ${basicAuthHeader}`);
      headers.append('Accept', `application/json`);
      headers.append('Content-Type', `application/x-www-form-urlencoded`);

      let payload = 'username=' + encodeURIComponent(username) + '&password='
        + encodeURIComponent(password) + '&grant_type=password';

      this.http
        .post('/api/oauth/token', payload, {headers: headers})
        .subscribe(
          data => {
            this.tokenData = data.json();
            this.authenticated = true;
            this.userData = AuthService.decodeAccessToken(this.tokenData.access_token);
            this.tokenExpirationDate = new Date(this.userData.exp * 1000);
            resolve('OK');
            localStorage.setItem('tokenData', JSON.stringify(this.tokenData));
          },
          err => {
            console.log(err);
            reject('Username and password doesn\'t match');
          }
        );

    });
  }

  public refreshToken() {
    if (this.isAuthenticated()) {

      let basicAuthHeader = btoa(`acme:acmesecret`);

      let headers = new Headers();
      headers.append('Authorization', `Basic  ${basicAuthHeader}`);
      headers.append('Accept', `application/json`);
      headers.append('Content-Type', `application/x-www-form-urlencoded`);

      let data = 'grant_type=refresh_token&refresh_token=' + encodeURIComponent(this.tokenData.refresh_token);

      this.http
        .post('/api/oauth/token', data, {headers: headers})
        .subscribe(
          data => {
            this.tokenData = data.json();
            this.authenticated = true;
            this.userData = AuthService.decodeAccessToken(this.tokenData.access_token);
            this.tokenExpirationDate = new Date(this.userData.exp * 1000);
          },
          err => {
            console.log(err);
          }
        );
    }
  }

  public logout(): any {
    this.tokenData = new Oauth2TokenData();
    this.userData = null;
    this.authenticated = false;
    this.tokenExpirationDate = null;
  }

  public getUserData(): any {
    return this.userData;
  }

  public getTokenExpirationDate(): Date {
    return this.tokenExpirationDate;
  }

  public hasRole(role: string): boolean {
    if (this.isAuthenticated()) {
      return this.getUserData()['authorities'].indexOf(role) >= 0;
    }
    return false;
  }

  public hasAnyRole(roles: string[]): boolean {
    let ok = false;
    roles.forEach(role => {
      if (this.hasRole(role)) {
        ok = true;
      }
    });
    return ok;
  }

  public canView(view: AppMenuItem): boolean {
    let ok = false;
    if (!view.roles) {
      ok = true;
    } else {
      ok = this.hasAnyRole(view.roles);
    }
    return ok;
  }

  public getAuthorizationHeaders(): Headers {
    let authorizationHeaders = new Headers();
    if (this.authenticated) {
      authorizationHeaders.append('Authorization', `Bearer ${this.tokenData.access_token}`);
    }
    return authorizationHeaders;
  }

  private checkTokenExpirationDate() {
    if (this.authenticated && this.tokenExpirationDate < new Date()) {
      console.log('Session timeout');
      this.logout();
    }
  }

  // private fetchUserData() {
  //   this.http.get('/api/user', {headers: this.getAuthorizationHeaders()})
  //       .subscribe(
  //           data => {
  //             this.userData = data.json();
  //           },
  //           err => this.authenticated = false
  //       );
  // }

}

class Oauth2TokenData {
  access_token: string = null;
  token_type: string = null;
  expires_in: number = null;
  scope: string = null;
  jti: string = null;
  refresh_token: string = null;

  constructor() {
  }
}
