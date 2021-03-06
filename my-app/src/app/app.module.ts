import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { HeaderModule } from './header/header.module';
import { BodyModule } from './body/body.module';
import { LoginModule } from './login/login.module';



@NgModule({
  declarations: [
    AppComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    HeaderModule,
    BodyModule,
    LoginModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
