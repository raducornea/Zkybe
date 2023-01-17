import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})

export class UsersService {


  private url = 'http://127.0.0.1:8091/api/zkybe/users';
    
  constructor(private httpClient: HttpClient) { }
   
  getUsers(){
    return this.httpClient.get(this.url);
  }
}






