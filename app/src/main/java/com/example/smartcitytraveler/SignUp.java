package com.example.smartcitytraveler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {
    private Button sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        sign = this.findViewById(R.id.sign);
        sign.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),Home.class);
                startActivity(otherActivity);
                finish();
            }
    });
    }

}
