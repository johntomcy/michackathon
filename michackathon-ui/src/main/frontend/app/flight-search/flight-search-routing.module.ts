import {Routes, RouterModule} from '@angular/router';
import {FlightSearchComponent} from './flight-search.component';
import {NgModule} from '@angular/core/src/metadata/ng_module';


export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: FlightSearchComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class FlightSearchRoutingModule {
}



