import {NgModule} from '@angular/core';
import {LoginComponent} from './login.component';
import {LoginRoutingModule} from './login-routing.module';
import {COMMON_CHILD_MODULES} from '../shared/common/common.modules';

@NgModule({
  imports: [
    ...COMMON_CHILD_MODULES,
    LoginRoutingModule
  ],
  declarations: [LoginComponent]
})
export class LoginModule {
}
