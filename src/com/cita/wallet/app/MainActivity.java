package com.cita.wallet.app;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.cita.wallet.app.fragments.AppSectionsFragment;
import com.cita.wallet.app.models.WalletUser;

import butterknife.ButterKnife;
import butterknife.InjectView;
import roboguice.util.temp.Ln;

public class MainActivity extends BaseWalletActivity implements
		AppSectionsFragment.OnSectionClickListener {
	@InjectView(R.id.textview_welcome_message)
	TextView welcome_message;
	WalletUser mUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.inject(this);

		Bundle extras = getIntent().getExtras();

		if (extras != null) {
			mUser = extras.getParcelable("user");

			Resources res = getResources();
			String text = String.format(
					res.getString(R.string.welcome_messages),
					mUser.getStudent_name());

			welcome_message.setText(text);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void OnSectionClick(int position) {
		Ln.d("Section clicked");
		Intent mIntent = null;

		switch (position) {

		case 0: // Vending
			mIntent = new Intent(MainActivity.this, NfcActivity.class);
			mIntent.putExtra("title", "Vending");
			break;

		case 1: // Estado de Cuent
			mIntent = new Intent(MainActivity.this,
					AccountStatementActivity.class);
			mIntent.putExtra("user", mUser);

			break;

		case 2: // Accesos
			mIntent = new Intent(MainActivity.this, NfcActivity.class);
			mIntent.putExtra("title", "Accesos");
			break;

		}
		startActivity(mIntent);

	}
}
