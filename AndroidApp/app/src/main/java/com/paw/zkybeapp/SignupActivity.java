package com.paw.zkybeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {
    EditText editTextFirstName, editTextLastName, editTextEmail, editTextPassword, editTextConfirmPassword, editTextBirthday;
    Button btnSubmitLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextFirstName = this. findViewById(R.id.editTextFirstName);
        editTextLastName = this. findViewById(R.id.editTextLastName);
        editTextEmail = this. findViewById(R.id.editTextEmail);
        editTextPassword = this. findViewById(R.id.editTextPassword);
        editTextConfirmPassword = this. findViewById(R.id.editTextConfirmPassword);
        btnSubmitLogIn = this. findViewById(R.id.btnSubmitLogIn);
        editTextBirthday = this.findViewById(R.id.editTextBirthday);

        btnSubmitLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateBirthday() || !validateEmail() || !validatePassword() || !validateFirstName() || !validateLastName()){
                    return;
                }
            }
        });
    }

    //VALIDATE PARAMETERS

    public boolean validateFirstName(){
        String firstName = editTextFirstName.getText().toString();
        if(firstName.isEmpty()){
            editTextFirstName.setError("First name connot be empty!");
            return false;
        }
        else{
            editTextFirstName.setError(null);
            return true;
        }
    }

    public boolean validateLastName(){
        String lastName = editTextLastName.getText().toString();
        if(lastName.isEmpty()){
            editTextLastName.setError("Last name connot be empty!");
            return false;
        }
        else{
            editTextLastName.setError(null);
            return true;
        }
    }

    public boolean validateEmail(){
        String email = editTextEmail.getText().toString();
        String checkEmail  = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
        if(email.isEmpty()){
            editTextEmail.setError("Email connot be empty!");
            return false;
        }
        else if(!email.matches(checkEmail )){
            editTextEmail.setError("Please enter a valid email!");
            return false;
        }
        else{
            editTextEmail.setError(null);
            return true;
        }
    }

    public boolean validatePassword(){
        String passwd = editTextPassword.getText().toString();
        String passwdConfirm = editTextConfirmPassword.getText().toString();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if(passwd.isEmpty()){
            editTextPassword.setError("Password connot be empty!");
            return false;
        }
        else if(passwd.matches(checkPassword)){
            editTextPassword.setError("Invalid password!");
            return false;
        }
        else if(!passwd.matches(passwdConfirm)){
            editTextConfirmPassword.setError("Password doesn't match!");
            return false;
        }
        else{
            editTextPassword.setError(null);
            return true;
        }
    }


    public boolean validateBirthday(){

        return true;
    }

}