package com.example.mathbomb;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class DifficultyArcade extends Activity {
    
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.difficulty_classic);
       
    // Dashboard sound button
       Button easy = (Button) findViewById(R.id.easy);
        
       // Dashboard classic button
       Button medium = (Button) findViewById(R.id.medium);
        
       // Dashboard arcade button
       Button hard= (Button) findViewById(R.id.hard);
       
       final MediaPlayer buttonsound = MediaPlayer.create(this, R.raw.buttonsound);
       
       // Listening to easy button click
       easy.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
        	   buttonsound.start();
        	   Intent easy= new Intent("com.example.mathbomb.ARCADEEASY");
   	           startActivity(easy);		
           }
       });
       
       // Listening to classic button click
       medium.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
        	   buttonsound.start();
        	   Intent medium = new Intent("com.example.mathbomb.ARCADEMEDIUM");
   	           startActivity(medium);		
           }
       });
       
       // Listening to classic button click
       hard.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
        	   buttonsound.start();
        	   Intent hard = new Intent("com.example.mathbomb.ARCADEHARD");
   	           startActivity(hard);		
           }
       });
   }
}