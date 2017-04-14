import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AuthGuard } from './shared/auth.guard';

import { AppComponent } from './app.component';
import { UserAccountComponent } from './user-account/user-account.component';
import { UserAccountService } from './user-account/user-account.service';
import { LoginService } from './login/login.service';
import { routing } from './app.route';
import { LoginComponent } from './login/login.component';
import { EditUserAccountComponent } from './user-account/user-account-edit/edit-user-account.component';
import { SignupComponent } from './signup/signup.component';
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    UserAccountComponent,
    LoginComponent,
    EditUserAccountComponent,
    SignupComponent,
    HeaderComponent
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
