package com.example.smartcitytraveler;

import android.app.Activity;
import android.app.Dialog;
import android.widget.Button;

import androidx.annotation.NonNull;

public class Custompopup extends Dialog {

    private Button valider, annuler;

    public Custompopup( @NonNull  Activity context) {
        super(context);
        setContentView(R.layout.mypopup);
        valider=findViewById(R.id.valider);
        annuler=findViewById(R.id.annuler);
    }
    public Button getValider() { return valider;}
    public Button getAnnuler(){ return annuler;}
    public void build(){
        show();

    }
}
