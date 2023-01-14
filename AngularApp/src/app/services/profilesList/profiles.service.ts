import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProfilesService {

  private url = 'http://127.0.0.1:8091/api/zkybe/profiles';
    
  constructor(private httpClient: HttpClient) { }
   
  getProfiles(){
    return this.httpClient.get(this.url);
  }
}








