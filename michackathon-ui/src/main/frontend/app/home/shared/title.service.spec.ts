/* tslint:disable:no-unused-variable */

import {TestBed, inject} from '@angular/core/testing';
import {TitleService} from './title.service';
import {AuthService} from '../../shared/auth/auth.service';
import {COMMON_TESING_PROVIDERS, COMMON_TESTING_MODULES} from '../../testing/testing.modules';

describe('Service: Title', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        ...COMMON_TESING_PROVIDERS,
        TitleService,
        AuthService
      ],
      imports: [
        ...COMMON_TESTING_MODULES,
      ]
    });
  });

  it('should be created', inject([TitleService], (service: TitleService) => {
    expect(service).toBeTruthy();
  }));

});
