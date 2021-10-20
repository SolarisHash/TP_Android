package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.media.AudioManager;
import android.media.MediaPlayer;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    boolean flag;
    //Variables pour les button
    Button b1, b2, b3;
    //Variables pour l'image
    ImageView iv;

    //Tableau qui stocke nos images ainsi que l'index
    int images[] = {R.drawable.universe, R.drawable.star_universe};
    int i = 1;

    //Variable pour la musique
    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.image1);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        flag = true;

        mySong = MediaPlayer.create(getApplicationContext(), R.raw.adrift_chillstep);
        mySong.start();

        //Change l'image est le background color des buttons
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(flag == true) {
                    b1.setBackgroundColor(Color.RED);
                    b2.setBackgroundColor(Color.RED);
                    b3.setBackgroundColor(Color.RED);
                    flag = false;
                }
                else{
                    b1.setBackgroundColor(Color.BLUE);
                    b2.setBackgroundColor(Color.BLUE);
                    b3.setBackgroundColor(Color.BLUE);
                    flag = true;
                }
                iv.setImageResource(images[i]);
                i++;
                if(i == images.length)
                    i = 0;
            }
        });
        //Relance la musique
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mySong.start();
            }
        });
        //Change d'activity
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });

    }
}