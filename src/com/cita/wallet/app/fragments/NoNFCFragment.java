package com.cita.wallet.app.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cita.wallet.app.R;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class NoNFCFragment extends Fragment {

    public NoNFCFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_no_nfc, container, false);
    }

}
