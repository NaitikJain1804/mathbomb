package com.example.mathbomb;



import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class ClassicMedium extends Activity {
	
	int score=0,randindex;
	
	void equationgenerator(Button optone,Button opttwo,Button optthree, Button optfour, Button optfive, TextView question)
	{
	
		int a=0,b=0,nextSym=0,answer=0,randopt=0,k;
		int printOptions[]=new int [5];
		int closeOptions[]=new int [10];
		char symbols[]={'+','-','X','/'};
		char sym=' ';
		
		for(int i=0;i<10;i++)
		{
			closeOptions[i]= 0;
		}
   
		Random r = new Random();
		nextSym=r.nextInt(4);
		sym=symbols[nextSym];
		a = r.nextInt(20 - 10) + 10;
		b=r.nextInt(20 - 10) + 10;
		if(nextSym==3)
		{
			answer=r.nextInt(15 - 5) + 5;
			a=b*answer;
		}
		switch(sym)
		{
			case '+':
				{
					answer = a + b;
					closeOptions[0]=a-b;
					closeOptions[1]=a*b;
					closeOptions[2]=a/b;
				}
				break;
			case '-':
				{
			 	   answer = a - b;
			 	   closeOptions[0]=a+b;
			 	   closeOptions[1]=a*b;
			 	   closeOptions[2]=a/b;
				}
			    break;
			case 'X':
			    {
			 	   answer = a * b;
			 	   closeOptions[0]=a+b;
			 	   closeOptions[1]=a-b;
			 	   closeOptions[2]=a/b;
			    }
			    break;
			case '/':
			    {
			 	   answer = a / b;
			 	   closeOptions[0]=a+b;
			 	   closeOptions[1]=a*b;
			 	   closeOptions[2]=a-b;
			    }
			    break;
   
			}
   
		    closeOptions[3]=a;
		    closeOptions[4]=b;
		    closeOptions[5]=a+b+1;
		    closeOptions[6]=a*b+5;
		    closeOptions[7]=(a+b)*2;
		    closeOptions[8]=a%b;
		    closeOptions[9]=a-b-1;
		    
		    printOptions[0]=printOptions[1]=printOptions[2]=printOptions[3]=printOptions[4]=0;
		    
		    
		    randindex=r.nextInt(5);
		    printOptions[randindex]=answer;
		    for(int i=0;i<5;i++)
		    {
		 	   if(i!=randindex)  //randindex contains answer
		 	   {
		 		   k=5;
		 		   
		 		   while(k>1)
		 		   {
		 			   k=0;
		 		   randopt=r.nextInt(9);
		 		  printOptions[i]=closeOptions[randopt];
		 		   for(int j=0;j<5;j++)
		 			   if(printOptions[i]==printOptions[j])
		 				   k++;
		 		   }
		 			 
		 			   
		 		   }
		 	   }
		    
		 		
		    int randindex1, randindex2;
		    randindex1=r.nextInt(5);
		    while(randindex1==randindex)
		    	randindex1=r.nextInt(5);
		    printOptions[randindex1]=answer +( r.nextInt(5 - 1) + 1); 
		    randindex2=r.nextInt(5);
		    while((randindex2==randindex)||(randindex2==randindex1))
		    	randindex2=r.nextInt(5);
		    printOptions[randindex2]=answer -( r.nextInt(5 - 1) + 1); 
		    
		    
		 	   
		    
			 
		       question.setText(Integer.toString(a) + ""  + Character.toString(sym) + "" + Integer.toString(b) );
		       optone.setText(Integer.toString(printOptions[0]));
		       opttwo.setText(Integer.toString(printOptions[1]));
		       optthree.setText(Integer.toString(printOptions[2]));
		       optfour.setText(Integer.toString(printOptions[3]));
		       optfive.setText(Integer.toString(printOptions[4]));
		       
	}
   
 
	

	
	
			
	@Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.classic_easy);
       
       
	    // Dashboard first option button
	       final Button optone = (Button) findViewById(R.id.btnOne);
	        
	       // Dashboard second option button
	       final Button opttwo = (Button) findViewById(R.id.btnTwo);
	        
	       // Dashboard third option button
	       final Button optthree= (Button) findViewById(R.id.btnThree);
	       
	       final Button optfour= (Button) findViewById(R.id.btnFour);
	       
	       final Button optfive= (Button) findViewById(R.id.btnFive);
	       
	       
	       final TextView question = (TextView) findViewById(R.id.question); 
	       
	       final MediaPlayer rightanswer = MediaPlayer.create(this, R.raw.rightanswer);
	       final MediaPlayer gameover = MediaPlayer.create(this, R.raw.gameover);
	
	
	       equationgenerator(optone,opttwo,optthree,optfour,optfive,question);
          
          // Listening to first option button click
          optone.setOnClickListener(new View.OnClickListener() {
               
              @Override
              public void onClick(View view) {
            	  
            	 if(randindex==0)
            	 {
            		 score++;
            		 rightanswer.start();
            		 equationgenerator(optone,opttwo,optthree,optfour,optfive,question);
      
            	 }
            	 else
            	 {
            		 //Game over
            		 //Game over
            		 gameover.start();
              		Intent easy= new Intent("com.example.mathbomb.GAMEOVER");
              		easy.putExtra("score", Integer.toString(score));
         	           startActivity(easy);		
            	 }
           	   
              }
          });
          
          // Listening to second option button click
          opttwo.setOnClickListener(new View.OnClickListener() {
               
              @Override
              public void onClick(View view) {
            	  if(randindex==1)
             	 {
            		  score++;
            		  rightanswer.start();
            		  equationgenerator(optone,opttwo,optthree,optfour,optfive,question);
       
             	 }
             	 else
             	 {
             		 //Game over
             		 //Game over
             		gameover.start();
              		Intent easy= new Intent("com.example.mathbomb.GAMEOVER");
              		easy.putExtra("score", Integer.toString(score));
         	           startActivity(easy);		
             	 }	
              }
          });
          
          // Listening to third option button click
          optthree.setOnClickListener(new View.OnClickListener() {
               
              @Override
              public void onClick(View view) {
            	  if(randindex==2)
             	 {
            		  score++;
            		  rightanswer.start();
            		  equationgenerator(optone,opttwo,optthree,optfour,optfive,question);
       
             	 }
             	 else
             	 {
             		 //Game over
             		 //Game over
             		gameover.start();
              		Intent easy= new Intent("com.example.mathbomb.GAMEOVER");
              		easy.putExtra("score", Integer.toString(score));
         	           startActivity(easy);	
             	 }
              }
          });
          
          optfour.setOnClickListener(new View.OnClickListener() {
              
              @Override
              public void onClick(View view) {
            	  if(randindex==3)
             	 {
            		  score++;
            		  rightanswer.start();
            		  equationgenerator(optone,opttwo,optthree,optfour,optfive,question);
       
             	 }
             	 else
             	 {
             		 //Game over
             		 //Game over
             		gameover.start();
              		Intent easy= new Intent("com.example.mathbomb.GAMEOVER");
              		easy.putExtra("score", Integer.toString(score));
         	           startActivity(easy);		
             	 }
              }
          });
          
          optfive.setOnClickListener(new View.OnClickListener() {
              
              @Override
              public void onClick(View view) {
            	  if(randindex==4)
             	 {
            		  score++;
            		  rightanswer.start();
            		  equationgenerator(optone,opttwo,optthree,optfour,optfive,question);
       
             	 }
             	 else
             	 {
             		 //Game over
             		 //Game over
             		 gameover.start();
              		Intent easy= new Intent("com.example.mathbomb.GAMEOVER");
              		easy.putExtra("score", Integer.toString(score));
         	           startActivity(easy);		
             	 }
              }
          });
	}
      
}
       



