import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';
import { tokenNotExpired } from 'angular2-jwt';


@Injectable()
export class AuthGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate() {
    // Check to see if a user has a valid JWT
    /* TODO check why this does not seem to work
    if (tokenNotExpired()) {
      console.log('token not expired');
      // If they do, return true and allow the user to load the home component
      return true;
    }
    */
  
    if (localStorage.getItem('currentUser')) {
      // If they do, return true and allow the user to load the home component
      return true;
    }

    console.log('token expired');
    // If not, they redirect them to the login page
    this.router.navigate(['/login']);
    return false;
  }
}