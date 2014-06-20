package com.cita.wallet.app;

import roboguice.util.temp.Ln;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.cita.wallet.app.fragments.NativeNFCTransaction;
import com.cita.wallet.app.fragments.NoNFCFragment;
import com.cita.wallet.app.utils.NFCUtils;
import com.gemalto.android.microsd.exception.NoMicroSDException;


public class NfcActivity extends Activity implements NativeNFCTransaction.OnNativeNFCFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfcactivity);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            getActionBar().setTitle(extras.getString("title"));
        }

        if (NFCUtils.isNFCEnabled(this)) {
            // nfc is available and enabled
            Ln.d("has NFC and is enabled");
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, NativeNFCTransaction.newInstance("nfc", ""))
                    .commit();

        } else {

            // TODO: Notify the user that he doesn't have nfc enabled

            // Check if the user has Gemalto MicroSD Card
            Ln.d("has a micro sd");

            try {
                if (NFCUtils.hasMicroSD()) {
                    getFragmentManager()
                            .beginTransaction()
                            .replace(
                                    R.id.container,
                                    NativeNFCTransaction.newInstance("sd", ""))
                            .commit();
                }
            } catch (NoMicroSDException e) {
                e.printStackTrace();
            }

        }

        if (NFCUtils.hasNoNFC(this)) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container,
                            new NoNFCFragment()).commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nfcactivity, menu);
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
    public void onNFCFragmentInteraction(Uri uri) {

    }
}
