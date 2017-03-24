import { UserDetails } from './UserDetails';
import { UserdetailsService } from './userdetails.service';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-personbyid',
  templateUrl: './userdetailsbyid.component.html',
  styleUrls: ['./userdetailsbyid.component.css']
})
export class UserDetailsByIdComponent implements OnInit, OnDestroy {
  userDetails: UserDetails;
  sub: any;
  
  constructor(private userDetailsService: UserdetailsService,
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
    this.router.navigate(['/userdetails/details', this.userDetails.id]);
  }
}
