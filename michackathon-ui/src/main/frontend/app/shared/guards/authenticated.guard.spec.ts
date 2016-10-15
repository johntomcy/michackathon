/* tslint:disable:no-unused-variable */

import {TestBed, inject} from '@angular/core/testing';
import {BaseRequestOptions, Http} from '@angular/http';
import {MockBackend} from '@angular/http/testing';
import {AuthenticatedGuard} from './authenticated.guard';
import {AuthService} from '../auth/auth.service';
import {RouterTestingModule} from '@angular/router/testing';

describe('AuthenticatedGuard', () => {

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
        AuthService,
        AuthenticatedGuard
      ],
      imports: [
        RouterTestingModule.withRoutes([]),
      ]
    });
  });


  it('should exist', inject([AuthenticatedGuard], (guard: AuthenticatedGuard) => {
    expect(guard).toBeTruthy();
  }));


});
