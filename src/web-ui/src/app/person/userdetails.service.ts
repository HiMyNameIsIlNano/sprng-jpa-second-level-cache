import { UserDetails } from './UserDetails';
import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Injectable()
export class UserdetailsService {

  private baseUrl: string = 'http://localhost:8080/rest';
  constructor(private http: Http) { }

  get(id: number): Observable<UserDetails> {
    let user$ = this.http
      .get(`${this.baseUrl}/${id}`, { headers: this.getHeaders() })
      .map(mapUserDetails);
    return user$;
  }

  private getHeaders() {
    let headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');
    return headers;
  }
}

function mapUserDetails(response: Response): UserDetails {
    return toUserDetails(response.json());
}

function toUserDetails(r: any): UserDetails {
  return r;
}
