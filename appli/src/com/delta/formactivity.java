package com.delta;


import com.delta.R;

import android.os.Bundle;
import android.preference.PreferenceActivity;


public class formactivity extends PreferenceActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.form);
	}

}
