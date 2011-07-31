package com.delta;

import winterwell.jtwitter.OAuthSignpostClient;
import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.TwitterException;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class status extends Activity implements OnClickListener{
     EditText status;
     Button update;
     ProgressDialog dialog;
     static final int DIALOG_ID=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.status);
		
		status = (EditText) findViewById(R.id.editText1);
		update = (Button) findViewById(R.id.button1);
		update.setOnClickListener(this);
	}
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		String ts = status.getText().toString();
		showDialog(DIALOG_ID);
		new posttwitter().execute(ts);
		
	}
	
	
	
	@Override
	protected Dialog onCreateDialog(int id) {
		
		switch(id)
		{ case DIALOG_ID: {
			ProgressDialog dialog=new ProgressDialog(this);
			dialog.setTitle("CONNECTING TO TWITTER");
			dialog.setMessage("PLEASE WAIT WHILE STATUS IS UPDATED");
			dialog.setIndeterminate(true);
			dialog.setCancelable(true);
			return dialog;
			
		}
		
		}
		return null;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId()){
		case R.id.itemPrefs:
			startActivity( new Intent(this,formactivity.class));
			break;
		}
		return true;
	}



	private class posttwitter extends AsyncTask<String,String,String>{

		

		@Override
		protected String doInBackground(String... status){
			// TODO Auto-generated method stub
			String result;
			try{
			myapp app =(myapp) (status.this.getApplication());
			
			app.getTwitter().setAPIRootUrl("http://api.twitter.com/1");
				app.getTwitter().setStatus(status[0]);
				result= "Status update succeeded";}
				catch(TwitterException e) {
					e.printStackTrace();
					result= "Status update failed";
					
				}
			return result;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Toast.makeText(status.this,result,Toast.LENGTH_LONG).show();
	        dismissDialog(DIALOG_ID);
		}
		
		
	}
		}
		
	


