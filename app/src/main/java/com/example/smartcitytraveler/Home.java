package com.example.smartcitytraveler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    private Button commencer;
    private Home activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity=this;
        setContentView(R.layout.activity_home);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        commencer=findViewById(R.id.visite);
        commencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                        Intent otheractivity = new Intent(getApplicationContext(), History.class);
                        startActivity(otheractivity);
                        finish();
                        popup.dismiss();
                    }
                });
                popup.build();
            }
        });
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //toolbar.setTitle("Home");
        //toolbar.inflateMenu(R.menu.menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.profil:
                Intent intent = new Intent(this, Profile.class);
                this.startActivity(intent);
                break;
            case R.id.logout:
                intent = new Intent(this, Login.class);
                this.startActivity(intent);
                break;
            case R.id.historique:
                intent = new Intent(this, History.class);
                this.startActivity(intent);
                break;
            case R.id.add: final Custompopup popup = new Custompopup(activity);
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
                    }
                });
                popup.build();
                break;
            default: return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
