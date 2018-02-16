import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';

import { AppCovalentModule } from './app.covalent.module';

import {DocmdComponentModule} from './component/component.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    AppCovalentModule,
    DocmdComponentModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
