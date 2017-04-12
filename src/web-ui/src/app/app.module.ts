import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AuthGuard } from './shared/auth.guard';

import { AppComponent } from './app.component';
import { UserAccountComponent } from './person/user-account.component';
import { UserAccountService } from './person/user-account.service';
import { LoginService } from './login/login.service';
import { routing } from './app.route';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    UserAccountComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [UserAccountService, LoginService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
