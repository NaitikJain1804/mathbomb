package com.example.mathbomb;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

public class Splash2 extends Activity{
	
	ImageView gear;  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash2);
	
		final MediaPlayer splash = MediaPlayer.create(this, R.raw.gameover);
	initialisers();				
	
	Thread timer= new Thread()
	{
		public void run()
		{
			try
			{
				sleep(3000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			finally{
				splash.start();
				Intent openMenu= new Intent("com.example.mathbomb.HOME");
				startActivity(openMenu);
			}
		}
	};
	timer.start();
	}

	

private void initialisers() {
	// TODO Auto-generated method stub
	gear= (ImageView)findViewById(R.id.launch2);
}
}