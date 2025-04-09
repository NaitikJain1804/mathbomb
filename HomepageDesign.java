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

public class HomepageDesign extends Activity {
    
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.homepage_layout);
       
    // Dashboard sound button
       Button sound = (Button) findViewById(R.id.sound);
        
       // Dashboard classic button
       Button classic = (Button) findViewById(R.id.classic);
        
       // Dashboard arcade button
       Button arcade = (Button) findViewById(R.id.arcade);
        
        
       // Dashboard wild button
       Button wild = (Button) findViewById(R.id.wild);
       
       //Dashboard highscores button
       Button highscores = (Button) findViewById(R.id.highscores);
       //Dashboard rules button
       Button rules = (Button) findViewById(R.id.rules);
       
       final MediaPlayer buttonsound = MediaPlayer.create(this, R.raw.buttonsound);
       // Listening to classic button click
       classic.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
        	   buttonsound.start();
        	   Intent classic = new Intent("com.example.mathbomb.CLASSIC");
   	           startActivity(classic);		
           }
       });
       
       
       // Listening to arcade button click
       arcade.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
        	   buttonsound.start();
        	   Intent arcade = new Intent("com.example.mathbomb.ARCADE");
   	           startActivity(arcade);		
           }
       });
       
       
       // Listening to wild button click
       wild.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
        	   buttonsound.start();
        	   Intent wild = new Intent("com.example.mathbomb.WILD");
   	           startActivity(wild);		
           }
       });
       
       
       // Listening to highscores button click
       highscores.setOnClickListener(new View.OnClickListener() {
            
           @Override
           public void onClick(View view) {
        	   buttonsound.start();
        	   Intent highscores = new Intent("com.example.mathbomb.HIGHSCORES");
   	           startActivity(highscores);		
           }
       });
       
       rules.setOnClickListener(new View.OnClickListener() {
           
           @Override
           public void onClick(View view) {
        	   buttonsound.start();
        	   Intent rules = new Intent("com.example.mathbomb.RULES");
   	           startActivity(rules);		
           }
       });
       
       
       // Listening to News Feed button click
       sound.setOnClickListener(new View.OnClickListener() {
           public void onClick(View view) {
        	   
        	   Log.i("onToggleClicked", "ToggleClick Event Started");
               //an AudioManager object, to change the volume settings  
               AudioManager amanager; 
               amanager = (AudioManager)getSystemService(AUDIO_SERVICE);

        	    // Is the toggle on?
        	    boolean on = ((ToggleButton) view).isChecked();
        	    
        	    if (on) {
        	    	Log.i("onToggleIsChecked", "ToggleClick Is Off");

                    //turn ringer silent
                    amanager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                    Log.i(".RINGER_MODE_NORMAL", "Set to true");
                    
                    buttonsound.start();

                    // turn on sound, enable notifications
                    amanager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
                    Log.i("STREAM_SYSTEM", "Set to False");
                    //notifications
                    amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
                    Log.i("STREAM_NOTIFICATION", "Set to False");
                    //alarm
                    amanager.setStreamMute(AudioManager.STREAM_ALARM, false);
                    Log.i("STREAM_ALARM", "Set to False");
                    //ringer
                    amanager.setStreamMute(AudioManager.STREAM_RING, false);
                    Log.i("STREAM_RING", "Set to False");
                    //media
                    amanager.setStreamMute(AudioManager.STREAM_MUSIC, false);
                    Log.i("STREAM_MUSIC", "Set to False");
        	    } else {
        	    	Log.i("onToggleIsChecked", "ToggleClick Is On");
                    //turn ringer silent
                    amanager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                    Log.i("RINGER_MODE_SILENT", "Set to true");

                    //turn off sound, disable notifications
                    amanager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
                    Log.i("STREAM_SYSTEM", "Set to true");
                    //notifications
                    amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
                    Log.i("STREAM_NOTIFICATION", "Set to true");
                    //alarm
                    amanager.setStreamMute(AudioManager.STREAM_ALARM, true);
                    Log.i("STREAM_ALARM", "Set to true");
                    //ringer
                    amanager.setStreamMute(AudioManager.STREAM_RING, true);
                    Log.i("STREAM_RING", "Set to true");
                    //media
                    amanager.setStreamMute(AudioManager.STREAM_MUSIC, true);
                    Log.i("STREAM_MUSIC", "Set to true");
        	    	 
        	    }
        	}

		
       });
   }
}