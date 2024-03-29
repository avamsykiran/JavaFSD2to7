import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { DirectiveDemoComponent } from './directive-demo/directive-demo.component';
import { ApplyColorDirective } from './apply-color.directive';
import { PipesDemoComponent } from './pipes-demo/pipes-demo.component';
import { IntoWordsPipe } from './into-words.pipe';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    DirectiveDemoComponent,
    ApplyColorDirective,
    PipesDemoComponent,
    IntoWordsPipe
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
