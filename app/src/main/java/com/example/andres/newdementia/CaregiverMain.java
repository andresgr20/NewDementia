package com.example.andres.newdementia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Andres on 2017-03-05.
 */

public class CaregiverMain extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caregivermain);
    }

   /* public void onButtonClick(View view){
        if(view.getId() == R.id.Bathe){ // need to add the user name
            Intent i = new Intent(.this, CaregiverMain.class);
            startActivity(i);
        }
        else if(view.getId() == R.id.Cook){

        }
        else if(view.getId() == R.id.Walk){

        }else if(view.getId() == R.id.Dog){

        }
    }*/


}