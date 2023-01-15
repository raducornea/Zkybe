import { Component, OnInit } from '@angular/core';
import { SearchUserService } from '../services/SearchUserService';


@Component({
  selector: 'app-searchuser',
  templateUrl: './searchuser.component.html',
  styleUrls: ['./searchuser.component.css']
})
export class SearchuserComponent implements OnInit {
 
  
  searchText = '';

  profiles: any;

  toggleSearch: boolean = false;
  constructor(private service: SearchUserService) {

  }

  openSearch() {
    this.toggleSearch = true;
  }
  
  searchClose() {
    this.searchText = '';
    this.toggleSearch = false;
  }
  ngOnInit(){
    this.service.getProfiles()
    .subscribe(response => {
      this.profiles = response;
    });
  }
  
  
}
