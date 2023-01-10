import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";
import { UserViewModel } from "../objects/viewmodels/UserViewModel";

@Injectable({
    providedIn: 'root'
})
export class AuthenticationService {
    
    private registerUri = "/api/zkybe/users/add_user";

    constructor (private httpClient: HttpClient) { }

    async registerUser(username: string, password: string, 
        firstName: string, lastName: string, email: string)
        : Promise<string> {
        
        let url = environment.apiUrl + this.registerUri; // ne construim url-ul complet pentru accesarea resursei de pe server-ul de backend

        let userToRegister = new UserViewModel(username, password); // ne cream un obiect care sa reprezinte body-ul cererii http (doar pentru POST si PUT)

        // aici e putin mai complicat de explicat, dar aici asteptam cererea http
        let response = await new Promise<any>( resolve => {
            // aici facem cererea, cu httpClient si post/get/put/delete
            // atentie la parametri, toate au nevoie de url, dar unele nu au nevoie de body, iar campul options e pentru headere si query parameters
            // in afara de register, celelalte rute ar trebui securizate si cer un token
            // token-ul se da ca la POS, in header la campul Authorization punem Bearer + token
            // las mai jos codul comentat pentru asta:
            
            // adaugati la constructor: private tokenService: TokenService
            // la inceputul functiei luati token-ul si formati parametrul options, care o sa il dati la functia de cerere http
            // let token = await this.tokenService.getToken();
            // let options = { headers: new HttpHeaders({'Authorization': 'Bearer ' + token}) }

            // daca faceti un get e mai simplu, o sa arate cam asa:
            // return this.httpClient.get<Interfata[]>(url, options).pipe(
            //     tap(data => console.log(data))
            // );
            // trebuie sa va definiti voi o Interfata care sa arate ca un raspuns de la server, iar mai departe va folositi de el
            // iar functia nu mai returneaza any, ci un array de acea interfata

            // pentru post/put/delete faceti asa:
            this.httpClient.post(url, userToRegister).subscribe({

                next: data => {
                    // console.log("next data");
                    // console.log(data);
                    resolve(data);
                },
                
                error: err => {
                    // console.log("error");
                    // console.log(err);
                    resolve(err);
                }
                
            })
        });

        // la final tratam raspunsul: eu asa am facut, dar voi puteti face oricum vreti si va vine mai usor
        if(response.error == null) {
            return "ok";
        }
        else {
            return response.message;
        }
    }
}