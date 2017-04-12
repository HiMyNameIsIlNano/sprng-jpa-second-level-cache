import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';

import { UserAccount } from './UserAccount';
import { contentHeaders } from '../shared/headers';
import { baseUrl } from '../shared/constants';

import 'rxjs/add/operator/map';

@Injectable()
export class UserAccountService {

  constructor(private http: Http) { }

  get(id: number): Observable<UserAccount> {
    let user$ = this.http
      .get(`${baseUrl}/details/${id}`, { headers: contentHeaders })
      .map(mapUserAccount);
    return user$;
  }
}

function mapUserAccount(response: Response): UserAccount {
    return toUserAccount(response.json());
}

function toUserAccount(r: any): UserAccount {
  return r;
}
