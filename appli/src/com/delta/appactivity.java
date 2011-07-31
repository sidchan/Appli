package com.delta;

import com.delta.*;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore.Images;

	
	public class appactivity extends Activity {	
	MediaPlayer mpSplash;

	Images myimage;
		
		
		public void onCreate(Bundle savedInstanceState) {
			
			super.onCreate(savedInstanceState);
			setContentView(R.layout.main);
			
			mpSplash = MediaPlayer.create(this, R.raw.logo_noise);
			mpSplash.start();
			
			
			
			
			Thread logoTimer = new Thread(){
				public void run(){
					try{
						int logoTimer =0;
						
						while(logoTimer <5000){
							sleep(100);
							logoTimer = logoTimer +100;
						}
						startActivity(new Intent("com.delta.CLEARSCREEN"));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					finally{
						finish();
					}
				}
				
			};
			logoTimer.start();
		}
		

		
		@Override
		protected void onDestroy() {
			// TODO Auto-generated method stub
			super.onDestroy();
		//	mpSplash.release();
			
		}

		@Override
		protected void onPause() {
			// TODO Auto-generated method stub
			super.onPause();
		//	mpSplash.pause();
		}

		@Override
		protected void onResume() {
			// TODO Auto-generated method stub
			super.onResume();
			//mpSplash.start();
		}

		@Override
		protected void onStart() {
			// TODO Auto-generated method stub
			super.onStart();
		}

		@Override
		protected void onStop() {
			// TODO Auto-generated method stub
			super.onStop();
		}
		
		
		
	}