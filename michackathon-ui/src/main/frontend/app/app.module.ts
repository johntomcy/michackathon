import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {AccessDeniedComponent} from './access-denied/access-denied.component';
import {AuthService} from './shared/auth/auth.service';
import {AdminGuard} from './shared/guards/admin.guard';
import {AuthenticatedGuard} from './shared/guards/authenticated.guard';
import {UnauthenticatedGuard} from './shared/guards/unauthenticated.guard';
import {TitleService} from './home/shared/title.service';
import {AppRoutingModule} from './app-routing.module';
import {COMMON_ROOT_MODULES} from './shared';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NotFoundComponent,
    AccessDeniedComponent
  ],
  imports: [
    ...COMMON_ROOT_MODULES,
    AppRoutingModule
  ],
  providers: [
    AuthService,
    AdminGuard,
    AuthenticatedGuard,
    UnauthenticatedGuard,
    TitleService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
