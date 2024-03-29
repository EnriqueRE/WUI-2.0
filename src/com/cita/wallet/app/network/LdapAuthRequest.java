package com.cita.wallet.app.network;

import roboguice.util.temp.Ln;
import android.util.Base64;

import com.cita.wallet.app.models.LdapResponse;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

public class LdapAuthRequest extends
		RetrofitSpiceRequest<LdapResponse, WalletApi> {

	private String student_id;
	private String student_password;

	public LdapAuthRequest(String student_id, String student_password) {
		super(LdapResponse.class, WalletApi.class);
		this.student_id = student_id;
		this.student_password = student_password;
	}

	@Override
	public LdapResponse loadDataFromNetwork() throws Exception {
		Ln.d("Authenticating ldap service for " + student_id + " " + " "
				+ student_password);

		String userPass = student_id + ":" + student_password;

		final String basicAuth = "Basic "
				+ Base64.encodeToString(userPass.getBytes(), Base64.NO_WRAP);
		return getService().ldapResponse(basicAuth);
	}

}
