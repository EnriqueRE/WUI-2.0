package com.cita.wallet.app.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * App that lets save and modify preferences. Created by Enrique Ramirez on
 * 5/27/14.
 */
public class AppUtils {

	Context context;

	public AppUtils(Context context) {

		this.context = context;

	}

	public void clearPreferences() {

		SharedPreferences preferences = context.getSharedPreferences(
				"com.cita.wallet", 0);
		SharedPreferences.Editor editor = preferences.edit();
		editor.clear();
		editor.commit();

	}

	public void saveIntegerToStorage(String key, int value) {

		SharedPreferences preferences = context.getSharedPreferences(
				"com.cita.wallet", Context.MODE_PRIVATE);

		SharedPreferences.Editor editor = preferences.edit();

		editor.putInt(key, value);
		editor.commit();

	}

	public int getIntegerFromStorage(String key) {

		SharedPreferences preferences = context.getSharedPreferences(
				"com.cita.wallet", Context.MODE_PRIVATE);

		return preferences.getInt(key, 0);

	}

	public void saveBooleanToStorage(String key, boolean value) {

		SharedPreferences preferences = context.getSharedPreferences(
				"com.cita.wallet", Context.MODE_PRIVATE);

		SharedPreferences.Editor editor = preferences.edit();

		editor.putBoolean(key, value);
		editor.commit();

	}

	public boolean getBooleanFromStorage(String key) {

		SharedPreferences preferences = context.getSharedPreferences(
				"com.cita.wallet", Context.MODE_PRIVATE);

		return preferences.getBoolean(key, false);

	}

	public void saveStringToStorage(String key, String value) {

		SharedPreferences preferences = context.getSharedPreferences(
				"com.cita.wallet", Context.MODE_PRIVATE);

		SharedPreferences.Editor editor = preferences.edit();

		editor.putString(key, value);
		editor.commit();

	}

	public String getStringFromStorage(String key) {

		SharedPreferences preferences = context.getSharedPreferences(
				"com.cita.wallet", Context.MODE_PRIVATE);

		return preferences.getString(key, "");

	}

	public static String getFirstDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH,
				Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH));

		Date firstDay = cal.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return sdf.format(firstDay);

	}

	public static String getLastDayOfMonth(Calendar calendar) {

		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);

		Date lastDayOfMonth = calendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return sdf.format(lastDayOfMonth);
	}

	public static String changeDateFormatForWebService(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return sdf.format(date);

	}
	
	public boolean alreadyLoggedIn() {
		
		SharedPreferences settings = context.getSharedPreferences(
				"com.cita.wallet", Context.MODE_PRIVATE);

		return settings.getBoolean("logged", false);

	}

	public void setLoggedIn(boolean logged) {

		SharedPreferences settings = context.getSharedPreferences(
				"com.cita.wallet", Context.MODE_PRIVATE);
		
		SharedPreferences.Editor editor = settings.edit();
		editor.putBoolean("logged", logged);
		editor.commit();

	}

}
