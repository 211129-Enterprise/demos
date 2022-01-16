import { RegisterComponent } from './components/register/register.component';
import { MainComponent } from './components/main/main.component';
import { AllComponent } from './components/all/all.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [

  { path: '', component: MainComponent },
  { path: 'main', component: MainComponent }, // http:localhost:4200/main
  { path: 'all', component: AllComponent },
  { path: 'register', component: RegisterComponent },


  { path: '**', component: MainComponent } // this is a WildCard Route to handle unknown paths (must be last)
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
