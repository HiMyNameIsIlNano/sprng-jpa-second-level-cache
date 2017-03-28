import { UserDetails } from './UserDetails';
import { UserDetailsService } from './user-details.service';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit, OnDestroy {
  userDetails: UserDetails;
  sub: any;
  
  constructor(private userDetailsService: UserDetailsService,
    private route: ActivatedRoute,
    private router: Router) { }
  
  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      let id = Number.parseInt(params['id']);
      this.userDetailsService
        .get(id)
        .subscribe(p => this.userDetails = p);
    });
  }
  
  ngOnDestroy() {
    this.sub.unsubscribe();
  }
  
  gotoDetails() {
    this.router.navigate(['/details', this.userDetails.id]);
  }
}
