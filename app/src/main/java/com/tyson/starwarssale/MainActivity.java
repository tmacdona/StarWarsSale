package com.tyson.starwarssale;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * There's not a lot going on here yet
 *
 * Now that the adapter has been created, the next thing was to write the adapter into the
 * main activity and set the data from the sample JSON file.
 *
 * After that I would have implemented a call to the Star Wars API (​https://swapi.co/​)
 * using Volley.
 */
public class    MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    public void addToCart(View v){

        // run a quick vibrate to indicate the button is pressed

        Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 250 milliseconds
        vib.vibrate(250);
    }
}
