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

  constructor(private _oidcSecurityService: OidcSecurityService) {

  }

  async ngOnInit() {
    this._oidcSecurityService.checkAuth().subscribe(async ({ isAuthenticated, userData, idToken, accessToken }) => {
      if (accessToken != null && accessToken != undefined) {
        this.currentUser = new User(userData.username, "userData.role");
        console.log(this.currentUser);
        console.log(accessToken);
      }
    });
  }

  login() {
    this._oidcSecurityService.authorize();
  }

  logout() {
    this._oidcSecurityService.logoff().subscribe(result => {
      console.log(result);
    })
    this.currentUser = null;
    console.log("user logged out!");
  }

  getCurrentUser(){
    return this.currentUser;
  }
}
