package com.example.mathbomb;

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


public class TestApp extends Activity{
	
	void main() {
	}
	
	int score=0,randindex;
    

	public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.classic_easy);
	       
	    // Dashboard first option button
	       Button optone = (Button) findViewById(R.id.btnOne);
	        
	       // Dashboard second option button
	       Button opttwo = (Button) findViewById(R.id.btnTwo);
	        
	       // Dashboard third option button
	       Button optthree= (Button) findViewById(R.id.btnThree);
	       
	       TextView question = (TextView) findViewById(R.id.question); 
	     //  int a=5,b=4,c=20;
	       
	       question.setText("5 * 4" );
	       optone.setText(Integer.toString(5));
	       opttwo.setText(Integer.toString(20));
	       optthree.setText(Integer.toString(4));
	       
	       optone.setOnClickListener(new View.OnClickListener() {
               
	              @Override
	              public void onClick(View view) {
	            	  
	            	  Intent easy= new Intent("in.robotix.robotixapp.NOTICEBOARD");
        	           startActivity(easy);
	           	   
	              }
	          });
	       
	       optthree.setOnClickListener(new View.OnClickListener() {
               
	              @Override
	              public void onClick(View view) {
	            	  
	            	  Intent easy= new Intent("in.robotix.robotixapp.NOTICEBOARD");
     	           startActivity(easy);
	           	   
	              }
	          });
	       
	       opttwo.setOnClickListener(new View.OnClickListener() {
               
	              @Override
	              public void onClick(View view) {
	            	  
	            	  Intent easy= new Intent("com.example.mathbomb.CLASSICEASY");
     	           startActivity(easy);
	           	   
	              }
	          });
	       
	       
}
}