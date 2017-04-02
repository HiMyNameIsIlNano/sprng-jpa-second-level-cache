import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { UserAccountComponent } from './person/user-account.component';
import { UserAccountService } from './person/user-account.service';
import { routing } from './app.route';

@NgModule({
  declarations: [
    AppComponent,
    UserAccountComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [UserAccountService],
  bootstrap: [AppComponent]
})
export class AppModule { }
