import { Injectable} from '@angular/core'
import { HttpClient } from '@angular/common/http'

@Injectable({
    providedIn: 'root'
})

export class SearchUserService{
   
    private url ='http://localhost:8091//api/zkybe//profiles';
    
    constructor(private httpClient: HttpClient){ }

    getProfiles(){
        return this.httpClient.get(this.url);
    }
}