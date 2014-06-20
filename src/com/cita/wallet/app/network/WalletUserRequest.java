package com.cita.wallet.app.network;

import com.cita.wallet.app.models.WalletUser;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import roboguice.util.temp.Ln;

/**
 * Created by admin on 5/26/14.
 */
public class WalletUserRequest extends RetrofitSpiceRequest<WalletUser , WalletApi> {

    private String studentId;

    public WalletUserRequest(String studentId) {
        super(WalletUser.class, WalletApi.class);
        this.studentId = studentId;

    }

    @Override
    public WalletUser loadDataFromNetwork() throws Exception {

        Ln.d("Call Web service");
         return getService().userInfo(studentId);
    }
}
