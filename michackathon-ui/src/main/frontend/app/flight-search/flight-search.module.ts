import {NgModule} from '@angular/core';
import {FlightSearchComponent} from './flight-search.component';
import {FlightSearchRoutingModule} from './flight-search-routing.module';
import {COMMON_CHILD_MODULES} from '../shared/common/common.modules';

@NgModule({
  imports: [
    ...COMMON_CHILD_MODULES,
    FlightSearchRoutingModule
  ],
  declarations: [FlightSearchComponent]
})
export class FlightSearchModule {
}
