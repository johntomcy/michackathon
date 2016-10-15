/* tslint:disable:no-unused-variable */

import {TestBed} from '@angular/core/testing';
import {AuthService} from '../shared/auth/auth.service';
import {RouterTestingModule} from '@angular/router/testing';
import {HomeComponent} from './home.component';
import {TitleService} from './shared/title.service';
import {COMMON_TESTING_MODULES, COMMON_TESING_PROVIDERS} from '../testing/testing.modules';

describe('Component: Home', () => {

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        ...COMMON_TESING_PROVIDERS,
        AuthService,
        TitleService
      ],
      imports: [
        ...COMMON_TESTING_MODULES,
        RouterTestingModule.withRoutes([{
          path: '',
          pathMatch: 'prefix',
          component: HomeComponent
        }]),
      ],
      declarations: [
        HomeComponent
      ],
    });
  });


  it('should create an instance', () => {
    let fixture = TestBed.createComponent(HomeComponent);
    expect(fixture).toBeTruthy();
  });

  it('should log ngOnInit', () => {

    let fixture = TestBed.createComponent(HomeComponent);
    let crud = fixture.debugElement.componentInstance;
    expect(crud).toBeTruthy();

    spyOn(console, 'log');
    expect(console.log).not.toHaveBeenCalled();

    crud.ngOnInit();

    expect(console.log).toHaveBeenCalled();
  });
});
