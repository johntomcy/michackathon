/* tslint:disable:no-unused-variable */

import {TestBed, inject} from '@angular/core/testing';
import {AuthService} from './auth.service';
import {Http, BaseRequestOptions} from '@angular/http';
import {MockBackend} from '@angular/http/testing';

describe('Service: Auth', () => {

  let sampleAccessToken = 'eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9' +
    '.eyJleHAiOjE0NzQ3OTUwNTAsInVzZXJfbmFtZSI6ImFkbWluIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiIsIlJPTEVfVVNFUiJdLCJqdGki' +
    'OiIzYmYwNzQ5MC1jMjc2LTRlMWItYjYzYi0wYzg0MTIxNTkwOWQiLCJjbGllbnRfaWQiOiJhY21lIiwic2NvcGUiOlsib3BlbmlkIl19' +
    '.PQ83zuGT9yFJnPvqPOpXkhDrOY60UHFCdXEAF1VzJvVKn6l3_1aNfaG4fKP5mVJJZiSsIKMs_2_m9B0_5gzu9mrz_OwG-bg4RN3Dr51e0uqnokQ-Jq' +
    'hHr3uI8eWxE3vUJJVHc6DrT2IvVGPa76Q39lfRGDr8SEIbW6uquU1g9gFKN8-kz00fpWGSJ-W6UOllbuqJx_SxMC7AfOZRG_6GPJbRxBLqzZG4QbW5b' +
    'm72lCshv9KspxkQyUqH6PQWKhRsjTJdwQYOnljyP-QwaKOm3PyYwX9aF2VB5GWXxvUHRDdQnMCqbPDCYyHR1bYDVNC_85MrUK7gb17yMJVnSZB9NA';

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        BaseRequestOptions,
        MockBackend,
        {
          provide: Http,
          useFactory: function (backend, defaultOptions) {
            return new Http(backend, defaultOptions);
          },
          deps: [MockBackend, BaseRequestOptions]
        },
        AuthService
      ]
    });
  });

  it('should exist', inject([AuthService], (service: AuthService) => {
    expect(service).toBeTruthy();
  }));

  it('should decode access token', inject([AuthService], (service: AuthService) => {
    let decodedToken = AuthService.decodeAccessToken(sampleAccessToken);
    expect(decodedToken).toBeTruthy();
    expect(decodedToken['user_name']).toBe('admin');
  }));


});
