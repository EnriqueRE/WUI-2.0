package com.cita.wallet.app;

import android.app.Activity;

import com.cita.wallet.app.network.WalletRetrofitSpiceService;
import com.octo.android.robospice.SpiceManager;

/**
 * This class is the base class of all activities of the project. This class offers all
 * subclasses an easy access to a {@link SpiceManager} that is linked to the {@link Activity}
 * lifecycle.
 * <p/>
 * Created by Enrique Ramirez on 5/26/14.
 */
public abstract class BaseWalletActivity extends Activity {

    private SpiceManager spiceManager = new SpiceManager(WalletRetrofitSpiceService.class);

    @Override
    protected void onStart() {
        spiceManager.start(this);
        super.onStart();
    }

    @Override
    protected void onStop() {
        spiceManager.shouldStop();
        super.onStop();
    }

    protected SpiceManager getSpiceManager() {
        return spiceManager;
    }

}
