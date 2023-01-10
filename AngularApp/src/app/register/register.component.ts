import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { AuthenticationService } from '../services/authentication.service';
import { MatSnackBar } from '@angular/material';
import { OidcSecurityService } from 'angular-auth-oidc-client';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  hide: boolean = true;
  hide2: boolean = true;

  nickname: string  = "";
  firstName: string = "";
  lastName: string = "";
  email: string = "";
  password: string  = "";
  repeatPassword : string = "";

  registerErrorMessage: string | null = null;

  register ={
    image: 'assets/img/register.jpg'
  }
  
  nicknameControl = new FormControl('', [Validators.required, Validators.minLength(6)])
  passwordControl = new FormControl('', [Validators.required, Validators.minLength(4)])
  emailControl = new FormControl('', [Validators.required, Validators.email]);
  firstNameControl = new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]);
  lastNameControl = new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z]+$')]);

  constructor(private _authenticationService: AuthenticationService, public _oidcSecurityService: OidcSecurityService) { }

  ngOnInit() {
    
  }

  onLogin() {
    this._oidcSecurityService.authorize();
  }

  async onRegister() {
    let errMessage = this.getEmailErrorMessage();
    if(errMessage != '') {
      this.registerErrorMessage = errMessage;
    }

    if(this.nickname.length <= 0 || this.password.length <= 0 || this.repeatPassword.length <= 0) {
      this.registerErrorMessage = "Please complete all the fields";
      return;
    }

    if(this.password != this.repeatPassword) {
      this.registerErrorMessage = "Passwords do not match";
      return;
    }

    console.log("username: " + this.nickname);
    console.log("password: " + this.password);

    let response = await this._authenticationService.registerUser(this.nickname, this.password, this.firstName, this.lastName, this.email);

    if(response == 'ok') {
      this.registerErrorMessage = null;

      this.password = "";
      this.repeatPassword = "";
      
      this._oidcSecurityService.authorize();
    }
    else {
      this.registerErrorMessage = response;
    }
  }

  getEmailErrorMessage() {
    if (this.emailControl.hasError('required')) {
      return 'You must enter a value';
    }

    return this.emailControl.hasError('email') ? 'Not a valid email' : '';
  }

  getFirstNameErrorMessage() {
    if (this.firstNameControl.hasError('required')) {
      return 'You must enter a value';
    }

    return this.firstNameControl.hasError('pattern') ? 'Not a valid name' : '';
  }

  getLastNameErrorMessage() {
    if (this.lastNameControl.hasError('required')) {
      return 'You must enter a value';
    }

    return this.lastNameControl.hasError('pattern') ? 'Not a valid name' : '';
  }

  getNicknameErrorMessage() {
    if (this.nicknameControl.hasError('required')) {
      return 'You must enter a value';
    }

    return this.nicknameControl.hasError('minlength') ? 'Nickname too short' : '';
  }

  getPasswordErrorMessage() {
    if (this.passwordControl.hasError('required')) {
      return 'You must enter a value';
    }

    return this.passwordControl.hasError('minlength') ? 'Password too short' : '';
  }

}
