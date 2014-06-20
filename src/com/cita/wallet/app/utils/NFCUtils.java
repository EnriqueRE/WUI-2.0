package com.cita.wallet.app.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.util.Log;

import com.gemalto.android.microsd.MicroSD;
import com.gemalto.android.microsd.MicroSDMode;
import com.gemalto.android.microsd.exception.NoMicroSDException;
import com.gemalto.android.microsd.field.IFieldState;

/**
 * Created by admin on 5/27/14.
 */
public class NFCUtils {

    private static MicroSD microSD;

    public static NdefRecord createTextRecord(String payload) {

        // byte[] textBytes = payload.getBytes(Charset.forName("US-ASCII"));

        byte[] textBytes = hexStringToByteArray(payload);

        Log.v("BYTES TO SEND", textBytes.toString() + "\n" + textBytes);

        NdefRecord record = new NdefRecord(NdefRecord.TNF_WELL_KNOWN,
                NdefRecord.RTD_TEXT, new byte[0], textBytes);

        return record;
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
                    .digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    /**
     * Checks if the NFC Feature of the phone is turned on.
     *
     * @param activity
     *            . Receives an activity to get the context, NFC Manager and NFC
     *            Adapters.
     *
     * */
    @SuppressLint("NewApi")
    public static boolean isNFCEnabled(Activity activity) {

        NfcManager manager = (NfcManager) activity.getBaseContext()
                .getSystemService(Context.NFC_SERVICE);

        NfcAdapter adapter = manager.getDefaultAdapter();

        if (adapter != null && adapter.isEnabled()) {
            // adapter exists and is enabled.
            return true;
        }

        return false;

    }

    public static boolean hasNoNFC(Activity activity){

        NfcManager manager = (NfcManager) activity.getBaseContext()
                .getSystemService(Context.NFC_SERVICE);

        NfcAdapter adapter = manager.getDefaultAdapter();

        if (adapter != null) {
            return false;
        }

        return true;

    }

    public static void enableTheMicroSD() {

        try {
            microSD = MicroSD.getInstance();

            microSD.selectMode(MicroSDMode.CONTACT);
            String atr = microSD.warmReset();

            microSD.selectMode(MicroSDMode.NO_MODE);

            microSD.selectMode(MicroSDMode.CONTACTLESS);

            microSD.registerFieldWatcher(new IFieldState() {

                @Override
                public void fieldStateChanged(int arg0) {

                    switch (arg0) {
                        case IFieldState.DETECTED:
                            Log.v("FIELD", "Field detected");

                            break;

                        case IFieldState.UNDETECTED:
                            Log.v("FIELD", "Field not detected");
                            break;

                        default:
                            break;
                    }

                }
            });

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void disableTheMicroSD() {

        try {
            microSD = MicroSD.getInstance();

            microSD.selectMode(MicroSDMode.NO_MODE);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static boolean hasMicroSD() throws NoMicroSDException {

        microSD = MicroSD.getInstance();

        if (microSD != null) {
            return true;
        }

        return false;
    }

}
