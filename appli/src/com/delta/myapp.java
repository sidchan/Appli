package com.delta;

import winterwell.jtwitter.OAuthSignpostClient;
import winterwell.jtwitter.Twitter;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;

public class myapp extends Application implements OnSharedPreferenceChangeListener{
    SharedPreferences pre;
    Twitter twit=null;
	@Override
	public void onCreate() {
		pre=PreferenceManager.getDefaultSharedPreferences(this);
		pre.registerOnSharedPreferenceChangeListener(this);
	}
	
	public Twitter getTwitter(){
		if(twit==null)
		{
			String accesstoken=pre.getString("access token","");
		String accesstokensecret=pre.getString("access token secret","");
		OAuthSignpostClient oauthClient = new OAuthSignpostClient("kmVEnZvHN3W2R6dj4NriPQ","cMveEXVteXPlBxjsImMEzisWZEFgEs6kUgjgmZY0Do",accesstoken,accesstokensecret);
		oauthClient.authorizeDesktop();

		Twitter twit = new Twitter("chansiddharth", oauthClient);
		
		}
		return twit;
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		twit=null;
		
	}

}
