package com.example.andres.newdementia;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
/**
 * Created by Andres on 2017-03-05.
 */

public class PatientAct extends Activity{
        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.patientact);
        }
   // MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.Pratice.m4a);
    //mediaPlayer.start()
    //mediaPlayer.stop()

    /*public void onButtonClick(View view) {
        if (view.getId() == R.id.yes1) { // need to add the user name
            Intent i = new Intent(PatientAct.this, PatientMain.class);
            startActivity(i);
        } else if (view.getId() == R.id.no1) {
            Intent i = new Intent(PatientAct.this, PatientMain.class);
            startActivity(i);
        }
    }*/

        /*
    public void audioPlayer(String path, String fileName){
        //set up MediaPlayer
        MediaPlayer mp = new MediaPlayer();

        try {
            mp.setDataSource(path+"/"+fileName);
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            mp.prepare();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mp.start();
    }*/
}


