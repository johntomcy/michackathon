/* tslint:disable:no-unused-variable */

import {LargeDirective} from './large.directive';
import {Component} from '@angular/core';
import {TestBed, ComponentFixture} from '@angular/core/testing';
import {By} from '@angular/platform-browser';

@Component({
  template: `
  <h2 id="t1" michackathonLarge>Something Yellow</h2>
  <h2 id="t2">Something Yellow</h2>
`
})
class TestComponent {
}


describe('Directive: michackathonLarge', () => {

  let fixture: ComponentFixture<TestComponent> = null;

  beforeEach(() => {
    fixture = TestBed.configureTestingModule({
      declarations: [
        TestComponent, LargeDirective
      ]
    }).createComponent(TestComponent);
    fixture.detectChanges();
  });

  it('should make element yellow and large', () => {
    let t1 = fixture.debugElement.query(By.css('#t1'));
    expect(t1.styles['backgroundColor']).toBe('yellow');
    expect(t1.styles['font-size']).toBe('2em');
  });

  it('should not make all elements yellow', () => {
    let t2 = fixture.debugElement.query(By.css('#t2'));
    expect(t2.styles['backgroundColor']).not.toBe('yellow');
    expect(t2.styles['font-size']).not.toBe('2em');
  });
});
