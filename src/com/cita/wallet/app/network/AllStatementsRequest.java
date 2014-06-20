package com.cita.wallet.app.network;

import com.cita.wallet.app.models.WalletStatement;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import roboguice.util.temp.Ln;

/**
 * Class that retrieves all the transactions for a given user, since the beginning of time.
 * Created by Enrique Ramirez on 5/26/14.
 */
public class AllStatementsRequest extends RetrofitSpiceRequest<WalletStatement.List, WalletApi> {

    private String studentId;

    public AllStatementsRequest(String studentId) {
        super(WalletStatement.List.class, WalletApi.class);
        this.studentId = studentId;
    }

    @Override
    public WalletStatement.List loadDataFromNetwork() throws Exception {
        Ln.d("Call web service");
        return getService().allStatements(studentId);
    }
}
