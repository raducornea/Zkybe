package com.paw.zkybeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserProfile extends AppCompatActivity {
    Button btnEditUserProfile;
    EditText editTextUpUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        btnEditUserProfile = this.findViewById(R.id.buttonEditUserProfile);
        editTextUpUsername = this.findViewById(R.id.editTextUpUsername);

        btnEditUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextUpUsername.setInputType(InputType.TYPE_CLASS_TEXT);
                editTextUpUsername.refreshDrawableState();
            }
        });
    }
}