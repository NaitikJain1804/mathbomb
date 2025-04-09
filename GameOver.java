package com.example.mathbomb;

import android.os.Bundle;
import android.widget.Button;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class GameOver extends Activity {
	
	 public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.game_over);
	       
	       
		    // Dashboard first option button
		    //   final Button scores = (Button) findViewById(R.id.scores);
		       
		    // 1. get passed intent 
		        Intent easy = getIntent();
		 
		        // 2. get message value from intent
		        String message = easy.getStringExtra("score");
		 
		        // 3. show message on textView 
		        ((Button)findViewById(R.id.scores)).setText(message);
		       
		       

}
}
