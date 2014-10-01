package com.cita.wallet.app.network;

import com.cita.wallet.app.models.WalletStatement;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import roboguice.util.temp.Ln;

/**
 * Class that retrieves all the transactions for a given user, start date and end date.
 * date in the format of yyyy-mm-dd
 * Created by Enrique Rammirez on 5/26/14.
 */
public class StatementsByDateRequest extends RetrofitSpiceRequest<WalletStatement.List, WalletApi> {

    private String studentId;
    private String startDate;
    private String endDate;

    public StatementsByDateRequest(String studentId, String startDate, String endDate) {
        super(WalletStatement.List.class, WalletApi.class);
        this.studentId = studentId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public WalletStatement.List loadDataFromNetwork() throws Exception {
        Ln.d("Calling web-service for "+studentId+" "+endDate+" "+startDate+" ");
        return getService().statementsByDate(studentId, endDate, startDate);
    }
}
