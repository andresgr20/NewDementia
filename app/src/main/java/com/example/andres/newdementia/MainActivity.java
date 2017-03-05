package com.example.andres.newdementia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View view){
        if(view.getId() == R.id.Blogin){ // need to add the user name
            Intent i = new Intent(MainActivity.this, PatientMain.class); // CaregiverMain
            startActivity(i);
        }
        else if(view.getId() == R.id.CareLogin){
            Intent i = new Intent(MainActivity.this, CaregiverMain.class);
            startActivity(i);
        }
    }
}
