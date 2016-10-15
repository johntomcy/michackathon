import {CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import {AuthService} from '../auth/auth.service';
import {Injectable} from '@angular/core';


@Injectable()
export class AdminGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) {
  }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.authService.hasRole('ROLE_ADMIN')) {
      return true;
    }
    this.router.navigate(['accessDenied']);
    return false;
  }
}
