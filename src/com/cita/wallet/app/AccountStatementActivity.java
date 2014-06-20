package com.cita.wallet.app;

import roboguice.util.temp.Ln;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.cita.wallet.app.fragments.AccountStatementFragment;
import com.cita.wallet.app.models.WalletUser;

public class AccountStatementActivity extends Activity implements
		AccountStatementFragment.OnFragmentInteractionListener {

	WalletUser mUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account_statement);
		Bundle extras = getIntent().getExtras();

		if (extras != null) {
			mUser = extras.getParcelable("user");
			Ln.d(mUser.getStudent_name());
		}

		getFragmentManager()
				.beginTransaction()
				.add(R.id.container,
						AccountStatementFragment.newInstance(mUser
								.getStudent_id())).commit();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.account_statement, menu);
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
	public void onFragmentInteraction(Uri uri) {
		// TODO Auto-generated method stub

	}

}
