import {Routes, RouterModule} from '@angular/router';
import {CrudComponent} from './crud.component';
import {NgModule} from '@angular/core/src/metadata/ng_module';


export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: CrudComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class CrudRoutingModule {
}



