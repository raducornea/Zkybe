import { Component, OnInit } from '@angular/core';
import { FriendsService } from '../services/friendList/friends.service';
import { ProfilesService } from '../services/profilesList/profiles.service';
import { UsersService } from '../services/usersList/users.service';
import { OidcSecurityService } from 'angular-auth-oidc-client';
import { AppComponent } from '../app.component';


@Component({
  selector: 'app-list-friends',
  templateUrl: './list-friends.component.html',
  styleUrls: ['./list-friends.component.css']
})
export class ListFriendsComponent  {


  friends:any
  users:any
  profiles: any
  currentUser: any

  listData = []
   constructor( private serviceFr:FriendsService, private serviceU: UsersService, private serviceP: ProfilesService, private app:AppComponent) {}

   

   list = this.listData.reverse();
 
   searchText = '';
 
   toggleSearch: boolean = false;
   

  ngOnInit() {
     
        this.serviceFr.getFriendsList()
        .subscribe(response => {
          this.friends = response;
        });

        this.serviceU.getUsers()
        .subscribe(response => {
          this.users = response;
        });

        this.serviceP.getProfiles()
        .subscribe(response => {
          this.profiles = response;
        });

        this.serviceP.getProfiles()
        .subscribe(response => {
          this.profiles = response;
        });

        this.currentUser = this.app.getCurrentUser()?.username
       
  }
  

  openSearch() {
    this.toggleSearch = true;
  }
  searchClose() {
    this.searchText = '';
    this.toggleSearch = false;
  }

}


