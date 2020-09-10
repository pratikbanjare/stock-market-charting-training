import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginPageComponent } from './component/login-page/login-page.component';
import { RegisterComponent } from './components/register/register.component';

import { RouterModule } from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { CompanySearchComponent } from './components/company-search/company-search.component';
import { HttpClientModule } from '@angular/common/http';
import { AllUsersComponent } from './components/all-users/all-users.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    RegisterComponent,
    CompanySearchComponent,
    AllUsersComponent,
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
