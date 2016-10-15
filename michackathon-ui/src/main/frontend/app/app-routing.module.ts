import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {AuthenticatedGuard} from './shared/guards/authenticated.guard';
import {AdminGuard} from './shared/guards/admin.guard';
import {UnauthenticatedGuard} from './shared/guards/unauthenticated.guard';
import {AccessDeniedComponent} from './access-denied/access-denied.component';
import {NotFoundComponent} from './not-found/not-found.component';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'prefix',
    redirectTo: 'home'
  },
  {
    path: 'home',
    pathMatch: 'prefix',
    component: HomeComponent
  },
  {
    path: 'about',
    pathMatch: 'prefix',
    loadChildren: 'app/about/about.module#AboutModule'
  },
  {
    path: 'crud',
    pathMatch: 'prefix',
    loadChildren: 'app/crud/crud.module#CrudModule',
    canActivate: [AuthenticatedGuard, AdminGuard]
  },
  {
    path: 'playground',
    pathMatch: 'prefix',
    loadChildren: 'app/playground/playground.module#PlaygroundModule'
  },
  {
    path: 'login',
    pathMatch: 'prefix',
    loadChildren: 'app/login/login.module#LoginModule',
    canActivate: [UnauthenticatedGuard]
  },
  {
    path: 'accessDenied',
    pathMatch: 'prefix',
    component: AccessDeniedComponent
  },
  {
    path: '404',
    pathMatch: 'prefix',
    component: NotFoundComponent
  },
  {
    path: '**',
    pathMatch: 'prefix',
    redirectTo: '404'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule {
}
