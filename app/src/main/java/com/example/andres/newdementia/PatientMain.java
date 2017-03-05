package com.example.andres.newdementia;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Andres on 2017-03-05.
 */


public class PatientMain extends Activity {

    private class PatientTimerTask extends TimerTask {
        @Override
        public void run() {
            Intent i = new Intent(PatientMain.this, PatientAct.class);
            startActivity(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientmain);
    }
    public void onButtonClick(View view){
        Timer timer = new Timer();
        PatientTimerTask ptt = new PatientTimerTask();
        if(view.getId() == R.id.Bathe){ // need to add the user name
            Intent i = new Intent(PatientMain.this, PatientAct.class);
            startActivity(i);
            timer.schedule(ptt, 5000);
        }
        else if(view.getId() == R.id.Cook){
            timer.schedule(ptt, 5000);
        }
        else if(view.getId() == R.id.Walk){
            Intent i = new Intent(PatientMain.this, PatientAct.class);
            startActivity(i);
            timer.schedule(ptt, 5000);
        }else if(view.getId() == R.id.Dog){
            Intent i = new Intent(PatientMain.this, PatientAct.class);
            startActivity(i);
            timer.schedule(ptt, 5000);
        }
    }
}
