/* tslint:disable:no-unused-variable */

import {AccessDeniedComponent} from './access-denied.component';

describe('Component: AccessDenied', () => {
  it('should create an instance', () => {
    let component = new AccessDeniedComponent();
    expect(component).toBeTruthy();
  });

  it('should log ngOnInit', () => {
    let component = new AccessDeniedComponent();
    expect(component).toBeTruthy();

    spyOn(console, 'log');
    expect(console.log).not.toHaveBeenCalled();

    component.ngOnInit();
    expect(console.log).toHaveBeenCalled();
  });

});
