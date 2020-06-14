package com.example.smartcitytraveler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("tag1","create");
        setContentView(R.layout.activity_main);
        play = this.findViewById(R.id.button);
        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),Login.class);
                startActivity(otherActivity);
                finish();
            }

        } );
    }
}
