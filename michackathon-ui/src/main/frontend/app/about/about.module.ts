import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AboutComponent} from './about.component';
import {
  MdInputModule,
  MdIconModule,
  MdSidenavModule,
  MdCardModule,
  MdButtonModule,
  MdCheckboxModule,
  MdCoreModule,
  MdGridListModule,
  MdListModule,
  MdMenuModule,
  MdProgressBarModule,
  MdProgressCircleModule,
  MdRadioModule,
  MdSlideToggleModule,
  MdSliderModule,
  MdTabsModule,
  MdToolbarModule,
  MdTooltipModule
} from '@angular/material';
import {AboutRoutingModule} from './about-routing.module';

@NgModule({
  imports: [
    CommonModule,
    MdButtonModule,
    MdCardModule,
    MdCheckboxModule,
    MdCoreModule,
    MdGridListModule,
    MdIconModule,
    MdInputModule,
    MdListModule,
    MdMenuModule,
    MdProgressBarModule,
    MdProgressCircleModule,
    MdRadioModule,
    MdSidenavModule,
    MdSlideToggleModule,
    MdSliderModule,
    MdTabsModule,
    MdToolbarModule,
    MdTooltipModule,
    AboutRoutingModule
  ],
  declarations: [AboutComponent]
})
export class AboutModule {
}
