import { Routes, RouterModule }  from '@angular/router';
import { UserAccountComponent } from './user-account/user-account.component';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './shared/auth.guard';

// Route config let's you map routes to components
const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  // map 'account/details/:id' to person details component only if Authenticated
  {
    path: 'account/details/:id',
    component: UserAccountComponent, canActivate: [AuthGuard]
  },
  // map '/' to '/login' as our default route
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  }
];
 
export const routing = RouterModule.forRoot(routes);