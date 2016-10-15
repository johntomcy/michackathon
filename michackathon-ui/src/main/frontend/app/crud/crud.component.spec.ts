/* tslint:disable:no-unused-expression */

import {TestBed} from '@angular/core/testing';
import {CrudComponent, BlogPost} from './crud.component';
import {AuthService} from '../shared/auth/auth.service';
import {RouterTestingModule} from '@angular/router/testing';
import {COMMON_TESING_PROVIDERS, COMMON_TESTING_MODULES} from '../testing/testing.modules';

describe('Component: Crud', () => {

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
          component: CrudComponent
        }]),
      ],
      declarations: [
        CrudComponent
      ],
    });
  });


  it('should create an instance', () => {
    let fixture = TestBed.createComponent(CrudComponent);
    expect(fixture).toBeTruthy();
  });

  it('should log ngOnInit', () => {

    let fixture = TestBed.createComponent(CrudComponent);
    let crud = fixture.debugElement.componentInstance;
    expect(crud).toBeTruthy();

    spyOn(console, 'log');
    expect(console.log).not.toHaveBeenCalled();

    crud.ngOnInit();

    expect(console.log).toHaveBeenCalled();
  });

  it('should allow to edit and create posts', () => {

    let fixture = TestBed.createComponent(CrudComponent);
    let crud: CrudComponent = fixture.debugElement.componentInstance;

    let post: BlogPost = {
      id: 127,
      uuid: null,
      title: 'title',
      content: 'content',
      createdDate: new Date(),
      updatedDate: new Date(),
      version: 1,
      createdBy: null,
      updatedBy: null
    };

    crud.editing = false;
    crud.editPost(post);

    expect(crud.editing).toBeTruthy();

    crud.editing = false;

    expect(crud.editing).toBeFalsy();
    expect(crud.editedPost.id).toBe(127);

    crud.newPost();

    expect(crud.editing).toBeTruthy();
    expect(crud.editedPost.id).toBeNull();

  });

});
