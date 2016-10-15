/* tslint:disable:no-unused-variable */

import {AboutComponent} from './about.component';

describe('Component: About', () => {
  it('should create an instance', () => {
    let component = new AboutComponent();
    expect(component).toBeTruthy();
  });

  it('should log ngOnInit', () => {
    let component = new AboutComponent();
    expect(component).toBeTruthy();

    spyOn(console, 'log');
    expect(console.log).not.toHaveBeenCalled();

    component.ngOnInit();
    expect(console.log).toHaveBeenCalled();
  });
});
