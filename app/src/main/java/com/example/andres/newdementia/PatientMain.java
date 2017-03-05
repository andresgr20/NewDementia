package com.example.andres.newdementia;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
/**
 * Created by Andres on 2017-03-05.
 */


public class PatientMain extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientmain);
    }
    public void onButtonClick(View view){
        if(view.getId() == R.id.Bathe){ // need to add the user name
            Intent i = new Intent(PatientMain.this, PatientAct.class);
            startActivity(i);
        }
        else if(view.getId() == R.id.Cook){
            Intent i = new Intent(PatientMain.this, PatientAct.class);
            startActivity(i);
        }
        else if(view.getId() == R.id.Walk){
            Intent i = new Intent(PatientMain.this, PatientAct.class);
            startActivity(i);
        }else if(view.getId() == R.id.Dog){
            Intent i = new Intent(PatientMain.this, PatientAct.class);
            startActivity(i);
        }
    }
}
