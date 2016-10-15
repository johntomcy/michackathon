/* tslint:disable:no-unused-variable */

import {TestBed} from '@angular/core/testing';
import {LoginComponent} from './login.component';
import {AuthService} from '../shared/auth/auth.service';
import {RouterTestingModule} from '@angular/router/testing';
import {COMMON_TESING_PROVIDERS, COMMON_TESTING_MODULES} from '../testing/testing.modules';


describe('Component: Login', () => {

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        ...COMMON_TESING_PROVIDERS,
        AuthService
      ],
      imports: [
        ...COMMON_TESTING_MODULES,
        RouterTestingModule.withRoutes([{
          path: '',
          pathMatch: 'prefix',
          component: LoginComponent
        }]),
      ],
      declarations: [
        LoginComponent
      ],
    });
  });


  it('should create an instance', () => {
    let fixture = TestBed.createComponent(LoginComponent);
    expect(fixture).toBeTruthy();
  });

  it('should log ngOnInit', () => {

    let fixture = TestBed.createComponent(LoginComponent);
    let crud = fixture.debugElement.componentInstance;
    expect(crud).toBeTruthy();

    spyOn(console, 'log');
    expect(console.log).not.toHaveBeenCalled();

    crud.ngOnInit();

    expect(console.log).toHaveBeenCalled();
  });

});
