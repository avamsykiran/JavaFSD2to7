import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccountHolderFormComponent } from './account-holder-form/account-holder-form.component';
import { AccountHoldersListComponent } from './account-holders-list/account-holders-list.component';

const routes: Routes = [
  {path:'',pathMatch:'full',redirectTo:'/list'},
  {path:"list",component:AccountHoldersListComponent},
  {path:"add",component:AccountHolderFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
