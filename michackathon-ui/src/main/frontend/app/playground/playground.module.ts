import {NgModule} from '@angular/core';
import {PlaygroundComponent} from './playground.component';
import {HeroAppComponent} from './shared/hero-app/hero-app.component';
import {HeroDetailComponent} from './shared/hero-detail/hero-detail.component';
import {HeroService} from './shared/hero.service';
import {PlaygroundRoutingModule} from './playground-routing.module';
import {COMMON_CHILD_MODULES} from '../shared/common/common.modules';


@NgModule({
  imports: [
    ...COMMON_CHILD_MODULES,
    PlaygroundRoutingModule
  ],
  providers: [
    HeroService
  ],
  declarations: [PlaygroundComponent, HeroAppComponent, HeroDetailComponent]
})
export class PlaygroundModule {
}
