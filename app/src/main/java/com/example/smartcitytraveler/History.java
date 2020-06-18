package com.example.smartcitytraveler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class History extends AppCompatActivity {

    private  Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity=this;
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
            case R.id.add:
                final Custompopup popup = new Custompopup(activity);
                popup.getAnnuler().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popup.dismiss();
                    }
                });
                popup.getValider().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent tomap = new Intent(getApplicationContext(), History.class);
                        startActivity(tomap);
                        finish();
                        popup.dismiss();
                    }
                });
                popup.build();
                break;
            default: return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
