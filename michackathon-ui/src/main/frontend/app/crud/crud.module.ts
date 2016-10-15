import {NgModule} from '@angular/core';
import {CrudComponent} from './crud.component';
import {CrudRoutingModule} from './crud-routing.module';
import {COMMON_CHILD_MODULES} from '../shared/common/common.modules';

@NgModule({
  imports: [
    ...COMMON_CHILD_MODULES,
    CrudRoutingModule
  ],
  declarations: [CrudComponent]
})
export class CrudModule {
}
