package com.example.smartcitytraveler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class Home extends AppCompatActivity {

    private Button commencer;
    private Home activity;
    private static final String TAG = "Home";
    private static final int ERROR_DIALOG_REQUEST = 9001;


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
                init();
            }
        });
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //toolbar.setTitle("Home");
        //toolbar.inflateMenu(R.menu.menu);
    }
    private void init(){
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
                Intent otherActivity = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(otherActivity);
                finish();
                popup.dismiss();
            }
        });
        popup.build();
    }

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Home.this);

        if(available == ConnectionResult.SUCCESS){
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error occured but we can resolve it
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(Home.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
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
