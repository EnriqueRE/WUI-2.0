package com.cita.wallet.app.fragments;

import com.cita.wallet.app.network.WalletRetrofitSpiceService;
import com.octo.android.robospice.SpiceManager;

import android.app.Fragment;

public class BaseFragment extends Fragment {

	private SpiceManager spiceManager = new SpiceManager(
			WalletRetrofitSpiceService.class);

	@Override
	public void onStart() {
		super.onStart();
		spiceManager.start(getActivity());
	}

	@Override
	public void onStop() {

		if (spiceManager.isStarted()) {
			spiceManager.shouldStop();
		}

		super.onStop();

	}

	protected SpiceManager getSpiceManager() {
		return spiceManager;

	}

}
