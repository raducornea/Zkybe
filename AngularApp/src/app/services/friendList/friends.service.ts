import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FriendsService {

  // private url = 'http://127.0.0.1:8091/api/zkybe/friendlists';
  private url = 'http://127.0.0.1:8091/api/zkybe/friendlists';
    
  constructor(private httpClient: HttpClient) { }
   
  getFriendsList(){
    return this.httpClient.get(this.url) ;
  } 
 
   

}