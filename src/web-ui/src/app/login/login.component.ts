import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Http } from '@angular/http';
import { LoginService } from './login.service';

import { UserAccount } from '../person/UserAccount';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @Input() email: string = '';
  @Input() password: string = '';
  public userAccount: UserAccount;
  public errorMessage: string = '';

  constructor(private router: Router, private loginService: LoginService) { }

  ngOnInit() {
  }

  onLogin(event: Event) { 
    this.loginService.login(this.email, this.password)
      .subscribe(userId => {
        if (userId !== -1) {
          console.log('login successful');
          // login successful
          this.router.navigate(['/details/' + userId]);
        } else {
          // login failed
          this.errorMessage = 'Username or password is incorrect';
        }
      });
  }
}

