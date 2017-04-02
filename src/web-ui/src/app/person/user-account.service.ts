import { UserAccount } from './UserAccount';
import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class UserAccountService {

  private baseUrl: string = 'http://localhost:8080/rest';
  constructor(private http: Http) { }

  get(id: number): Observable<UserAccount> {
    let user$ = this.http
      .get(`${this.baseUrl}/${id}`, { headers: this.getHeaders() })
      .map(mapUserAccount);
    return user$;
  }


  private getHeaders() {
    let headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');
    return headers;
  }
}

function mapUserAccount(response: Response): UserAccount {
    return toUserAccount(response.json());
}

function toUserAccount(r: any): UserAccount {
  return r;
}
