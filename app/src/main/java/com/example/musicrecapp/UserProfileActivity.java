package com.example.musicrecapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserProfileActivity extends AppCompatActivity {

    Button logout ;
    TextView userEmailShow ;
    FirebaseAuth firebaseAuth ;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        logout = (Button)findViewById(R.id.logout);
        userEmailShow = (TextView)findViewById(R.id.user_email);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            Intent intent = new Intent(UserProfileActivity.this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(UserProfileActivity.this, "Please Log in to continue", Toast.LENGTH_LONG).show();

        }
        firebaseUser = firebaseAuth.getCurrentUser();
        userEmailShow.setText("Successfully Logged In, Your Email = " + firebaseUser.getEmail());
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                Intent intent = new Intent(UserProfileActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(UserProfileActivity.this, "Logged Out Successfully.", Toast.LENGTH_LONG).show();

            }
        });


    }
}