import {FormsModule} from '@angular/forms';
import {BaseRequestOptions, Http} from '@angular/http';
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
  MdTooltipModule,
  MdButtonToggleModule,
  MdDialogModule,
  MdSelectModule,
  MdSnackBarModule
} from '@angular/material';
import {BrowserModule} from '@angular/platform-browser';
import {MockBackend} from '@angular/http/testing';

export const COMMON_TESTING_MODULES = [
  BrowserModule,
  FormsModule,
  MdButtonModule.forRoot(),
  MdButtonToggleModule.forRoot(),
  MdCardModule.forRoot(),
  MdCheckboxModule.forRoot(),
  MdCoreModule.forRoot(),
  MdDialogModule.forRoot(),
  MdGridListModule.forRoot(),
  MdIconModule.forRoot(),
  MdInputModule.forRoot(),
  MdListModule.forRoot(),
  MdMenuModule.forRoot(),
  MdProgressBarModule.forRoot(),
  MdProgressCircleModule.forRoot(),
  MdRadioModule.forRoot(),
  MdSelectModule.forRoot(),
  MdSidenavModule.forRoot(),
  MdSlideToggleModule.forRoot(),
  MdSliderModule.forRoot(),
  MdSnackBarModule.forRoot(),
  MdTabsModule.forRoot(),
  MdToolbarModule.forRoot(),
  MdTooltipModule.forRoot()
];

export const COMMON_TESING_PROVIDERS = [
  BaseRequestOptions,
  MockBackend,
  {
    provide: Http,
    useFactory: function (backend, defaultOptions) {
      return new Http(backend, defaultOptions);
    },
    deps: [MockBackend, BaseRequestOptions]
  },
];
