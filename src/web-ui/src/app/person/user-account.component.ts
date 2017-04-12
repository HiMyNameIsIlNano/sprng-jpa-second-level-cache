import { UserAccount } from './UserAccount';
import { UserAccountService } from './user-account.service';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user-account',
  templateUrl: './user-account.component.html',
  styleUrls: ['./user-account.component.css']
})
export class UserAccountComponent implements OnInit, OnDestroy {
  userAccount: UserAccount;
  errorMessage: string = '';
  sub: any;
  
  constructor(private userAccountService: UserAccountService,
    private route: ActivatedRoute,
    private router: Router) { }
  
  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      let id = Number.parseInt(params['id']);
      this.userAccountService
        .get(id)
        .subscribe(p => this.userAccount = p, 
        e => this.errorMessage = e._body); // error handling
    });
  }
  
  ngOnDestroy() {
    this.sub.unsubscribe();
  }
  
  gotoDetails() {
    this.router.navigate(['/details', this.userAccount.id]);
  }
}
