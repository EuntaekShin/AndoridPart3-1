package com.example.fragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by user on 2017-03-24.
 */

public class Fragment02 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parentView, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment02,parentView,false);



        Button btn = (Button)rootView.findViewById(R.id.btn02);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.onFragmentChanged(1);
                mainActivity.changeToast(1);
            }
        });
        return rootView;
    }
}
