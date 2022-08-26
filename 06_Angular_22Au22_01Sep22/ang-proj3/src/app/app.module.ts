import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccountHoldersListComponent } from './account-holders-list/account-holders-list.component';
import { AccountHolderFormComponent } from './account-holder-form/account-holder-form.component';

@NgModule({
  declarations: [
    AppComponent,
    AccountHoldersListComponent,
    AccountHolderFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
