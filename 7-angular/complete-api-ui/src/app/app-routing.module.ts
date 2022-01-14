import { RegisterComponent } from './components/register/register.component';
import { AllComponent } from './components/all/all.component';
import { MainComponent } from './components/main/main.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [

  {path: '', component: MainComponent},
  {path: 'main', component: MainComponent}, // http:localhost:4200/main
  {path: 'all', component: AllComponent},
  { path: 'register', component: RegisterComponent},
  {path: '**', component: MainComponent}, // this is a WildCard Route to handle unknown paths (this MUST be last)
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
