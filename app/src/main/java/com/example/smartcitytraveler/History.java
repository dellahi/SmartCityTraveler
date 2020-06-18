package com.example.smartcitytraveler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // getSupportActionBar().setDisplayShowHomeEnabled(true);
        //toolbar.setTitle("Home");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.home:
                Intent intent = new Intent(this, Home.class);
                this.startActivity(intent);
                break;
            case R.id.logout:
                intent = new Intent(this, Login.class);
                this.startActivity(intent);
                break;
            case R.id.profil:
                intent = new Intent(this, Profile.class);
                this.startActivity(intent);
                break;
            default: return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
