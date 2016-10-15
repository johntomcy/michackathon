import {Routes, RouterModule} from '@angular/router';
import {NgModule} from '@angular/core/src/metadata/ng_module';
import {LoginComponent} from './login.component';


export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: LoginComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class LoginRoutingModule {
}



