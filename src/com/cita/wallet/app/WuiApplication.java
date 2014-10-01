package com.cita.wallet.app;

/**
 * Created by Enrique Ramirez on 5/8/14.
 */

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


public class WuiApplication extends Application {

	SharedPreferences settings;

	@Override
	public void onCreate() {
		super.onCreate();

		Context mContext = this.getApplicationContext();
		settings = mContext.getSharedPreferences("com.cita.nfc",
				Context.MODE_PRIVATE);

	}
	
	public boolean alreadyLoggedIn() {

		return settings.getBoolean("logged", false);

	}

	public void setLoggedIn(boolean logged) {

		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean("logged", logged);
		editor.commit();

	}
	
	
	
}