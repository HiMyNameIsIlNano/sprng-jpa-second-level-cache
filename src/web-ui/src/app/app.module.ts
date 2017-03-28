import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { UserDetailsComponent } from './person/user-details.component';
import { UserDetailsService } from './person/user-details.service';
import { routing } from './app.route';

@NgModule({
  declarations: [
    AppComponent,
    UserDetailsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [UserDetailsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
