import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './components/nav/nav.component';
import { MainComponent } from './components/main/main.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AllComponent } from './components/all/all.component';
import { HttpClientModule } from '@angular/common/http';
import { RegisterComponent } from './components/register/register.component';
import { FormsModule } from '@angular/forms';
import { FindComponent } from './components/find/find.component';
import { RemoveComponent } from './components/remove/remove.component'; // built in library where we get ngModel directive from
<<<<<<< HEAD

=======
>>>>>>> main

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    MainComponent,
    AllComponent,
    RegisterComponent,
    FindComponent,
    RemoveComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
<<<<<<< HEAD
    FormsModule
=======
    FormsModule, // this is necessary for ([ngModel])
    NgbModule
>>>>>>> main
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
