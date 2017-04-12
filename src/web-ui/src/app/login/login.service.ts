import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import { AuthResponse } from './AuthResponse';
import { contentHeaders } from '../shared/headers';
import { baseUrl } from '../shared/constants';

import 'rxjs/add/operator/map';

@Injectable()
export class LoginService {

  public token: string

  constructor(private http: Http) {
    // set token if saved in local storage
    var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.token = currentUser && currentUser.token;
  }

  login(email: string, password: string): Observable<number> { 
    /*var t = localStorage.getItem("accessToken");
    headers.append("Authorization", "Bearer " + t;*/

    return this.http.post(`${baseUrl}/login`, JSON.stringify({ email: email, password: password }), { headers: contentHeaders })
      .map((response: Response) => {
        // login successful if the response is 200
        if (response.ok) {
          var authResponse = mapAuthResponse(response);
          // set token property
          this.token = authResponse.token;
          // store username and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify({ email: email, token: this.token }));
          // return true to indicate successful login
          return authResponse.userId;
        } else {
          // return false to indicate failed login
          return -1;
        }
      });
  }
}

function mapAuthResponse(response: Response): AuthResponse {
  return toAuthResponse(response.json());
}

function toAuthResponse(r: any): AuthResponse {
  return r;
}
