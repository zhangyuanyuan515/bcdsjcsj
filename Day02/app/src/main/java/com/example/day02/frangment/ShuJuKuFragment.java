package com.example.day02.frangment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day02.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShuJuKuFragment extends Fragment {


    public ShuJuKuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shu_ju_ku, container, false);
    }

}
