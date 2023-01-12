import { Component, OnInit } from '@angular/core';
import { listData } from './shared/list';


@Component({
  selector: 'app-searchuser',
  templateUrl: './searchuser.component.html',
  styleUrls: ['./searchuser.component.css']
})
export class SearchuserComponent  {
 
  list = listData.reverse();
 
  searchText = '';

  toggleSearch: boolean = false;
  constructor() {

  }

  openSearch() {
    this.toggleSearch = true;
  }
  searchClose() {
    this.searchText = '';
    this.toggleSearch = false;
  }
}
