package com.example.andres.newdementia;

import java.io.IOException;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.Menu;
import android.media.AudioManager;
import android.widget.Toast;
/**
 * Created by Andres on 2017-03-05.
 */

public class PatientAct extends Activity{
        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.patientact);
            audioPlayer("/Users/Andres/Music/iTunes/iTunes Media/Music/Zedd & Alessia Cara/Stay - Single","01 Stay.m4a");
            play();
        }
   /* public class Main extends Activity {
        public String url = "http://69.64.48.96:9880";
        public MediaPlayer player = new MediaPlayer();


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        public void stop(){
            Toast.makeText(getApplicationContext(), "Finalizando...", Toast.LENGTH_SHORT).show();
            if(player.isPlaying()){
                player.stop();
            }
        }

        public void play(){
            if(player.isPlaying()){
                Toast.makeText(getApplicationContext(), "Já está em execução!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Preparando...", Toast.LENGTH_SHORT).show();
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                player.setAudioStreamType(AudioManager.STREAM_NOTIFICATION);
                try {
                    player.setDataSource(url);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    player.prepare();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void onClick(View v) {
            final int id = v.getId();
            switch (id) {
                case R.id.btnPlay:
                    play();
                    break;
                case R.id.btnStop:
                    stop();
                    break;
            }
        }
    }
*/
    public void onButtonClick(View view) {
        if (view.getId() == R.id.yes1) {
            Intent i = new Intent(PatientAct.this, PatientMain.class);
            startActivity(i);
        } else if (view.getId() == R.id.no1) {
            Intent i = new Intent(PatientAct.this, PatientMain.class);
            startActivity(i);
        }
    }

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
    }



}


