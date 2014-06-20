package com.cita.wallet.app.network;

import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;

/**
 * Created by admin on 5/26/14.
 */
public class WalletRetrofitSpiceService extends RetrofitGsonSpiceService {

    private final static String BASE_URL = "http://riego.chi.itesm.mx:8080";

    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(WalletApi.class);
        
        
    }

    @Override
    protected String getServerUrl() {
        return BASE_URL;
    }
}
