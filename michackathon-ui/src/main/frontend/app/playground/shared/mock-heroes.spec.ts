/* tslint:disable:no-unused-variable */

import {HEROES} from './mock-heroes';

describe('MockHeroes', () => {
  it('should have 10 heroes', () => {
    expect(HEROES.length).toBe(10);
  });
});
