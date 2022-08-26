import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule,Routes} from '@angular/router';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { DirectiveDemoComponent } from './directive-demo/directive-demo.component';
import { ApplyColorDirective } from './apply-color.directive';
import { PipesDemoComponent } from './pipes-demo/pipes-demo.component';
import { IntoWordsPipe } from './into-words.pipe';
import { NumberSeriesComponent } from './number-series/number-series.component';
import { NumberSeriesGroupComponent } from './number-series-group/number-series-group.component';

const routes :Routes = [
  {path:'',pathMatch:'full',redirectTo:'/welcome'},
  {path:'welcome',component:WelcomeComponent},
  {path:'dd',component:DirectiveDemoComponent},
  {path:'pd',component:PipesDemoComponent},
  {path:'nsg',component:NumberSeriesGroupComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    DirectiveDemoComponent,
    ApplyColorDirective,
    PipesDemoComponent,
    IntoWordsPipe,
    NumberSeriesComponent,
    NumberSeriesGroupComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
