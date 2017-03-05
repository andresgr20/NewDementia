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
        private String taskName = "";
        @Override
        public void run() {
            Intent i = new Intent(PatientMain.this, PatientAct.class);
            i.putExtra("task", taskName);
            startActivity(i);
        }

        public void setTaskName(String task) {
            taskName = task;
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
            ptt.setTaskName("bathing");
            timer.schedule(ptt, 2500);
        } else if(view.getId() == R.id.Cook){
            ptt.setTaskName("cooking");
            timer.schedule(ptt, 2500);
        } else if(view.getId() == R.id.Walk){
            ptt.setTaskName("walking");
            timer.schedule(ptt, 2500);
        } else if(view.getId() == R.id.Dog){
            ptt.setTaskName("petting a dog");
            timer.schedule(ptt, 2500);
        }
    }
}
