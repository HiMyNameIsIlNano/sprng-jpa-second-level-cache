import { Component, OnInit, OnDestroy } from '@angular/core';

import { UserAccount } from '../UserAccount';
import { UserAccountService } from '../user-account.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-user-account',
  templateUrl: './edit-user-account.component.html',
  styleUrls: ['./edit-user-account.component.css']
})
export class EditUserAccountComponent implements OnInit, OnDestroy {
  userAccount: UserAccount;
  sub: any;
  errorMessage: string = '';
  response: any;
 
  constructor(private personService: UserAccountService,
    private route: ActivatedRoute,
    private router: Router) { }
 
  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      let id = Number.parseInt(params['id']);
      this.personService
        .get(id)
        .subscribe(p => this.userAccount = p);
    });
  }
 
  ngOnDestroy() {
    this.sub.unsubscribe();
  }
 
  updatePersonDetails() {
    this.personService.save(this.userAccount)
      .subscribe(p => this.response = p, e => this.errorMessage = e._body,
        () => this.router.navigate(['/details/', this.userAccount.id]));
  }

  upload() {
    console.log('upload');
  }
}
