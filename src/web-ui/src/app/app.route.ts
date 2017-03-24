import { Routes, RouterModule }  from '@angular/router';
import { UserDetailsByIdComponent } from './person/userdetailsbyid.component';
  
// Route config let's you map routes to components
const routes: Routes = [
  // map '/persons/:id' to person details component
  {
    path: 'userdetails/details/:id',
    component: UserDetailsByIdComponent
  },
   // map '/' to '/persons' as our default route
  {
    path: '',
    redirectTo: 'userdetails/details/1',
    pathMatch: 'full'
  },
];
 
export const routing = RouterModule.forRoot(routes);