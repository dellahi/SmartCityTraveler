package com.example.smartcitytraveler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private Button log;
    private TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup=this.findViewById(R.id.signup);
        log = this.findViewById(R.id.buttonlogin);
        log.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),Home.class);
                startActivity(otherActivity);
                finish();
            }

        } );
        signup.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),SignUp.class);
                startActivity(otherActivity);
                finish();
            }
        });

    }
}
