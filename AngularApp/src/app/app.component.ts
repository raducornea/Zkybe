import { Component } from '@angular/core';
import { OidcSecurityService } from 'angular-auth-oidc-client';
import { User } from './objects/User';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AngularApp';

  currentUser: User | null = null;

  constructor(public oidcSecurityService: OidcSecurityService) {

  }

  async ngOnInit() {
    this.oidcSecurityService.checkAuth().subscribe(async ({ isAuthenticated, userData, idToken, accessToken }) => {
      if (accessToken != null && accessToken != undefined) {
        this.currentUser = new User(userData.username, "userData.role");
        console.log(this.currentUser);
        console.log(accessToken);
      }
    });
  }

  login() {
    this.oidcSecurityService.authorize();
  }

  logout() {
    this.oidcSecurityService.logoff();
    this.currentUser = null;
  }

}
