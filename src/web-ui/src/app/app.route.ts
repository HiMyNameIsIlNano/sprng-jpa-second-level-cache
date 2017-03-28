import { Routes, RouterModule }  from '@angular/router';
import { UserDetailsComponent } from './person/user-details.component';
  
// Route config let's you map routes to components
const routes: Routes = [
  // map '/details/:id' to person details component
  {
    path: 'details/:id',
    component: UserDetailsComponent
  },
   // map '/' to '/details' as our default route
  {
    path: '',
    redirectTo: 'details/1',
    pathMatch: 'full'
  }
];
 
export const routing = RouterModule.forRoot(routes);