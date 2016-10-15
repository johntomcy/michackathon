/* tslint:disable:no-unused-variable */

import {HeroAppComponent} from './hero-app.component';
import {HeroService} from '../hero.service';

describe('Component: App', () => {
  it('should create an instance', () => {
    let heroService = new HeroService();
    let component = new HeroAppComponent(heroService);
    expect(component).toBeTruthy();
  });
});
