package com.example.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by user on 2017-03-24.
 */
                                //import를 v4로 만들어야한다
public class Fragment01 extends Fragment {


    public View onCreateView(LayoutInflater inflater,  ViewGroup parentView, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment01,parentView,false);

        Button button =(Button)rootView.findViewById(R.id.btn01);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity =(MainActivity)getActivity();
                mainActivity.onFragmentChanged(0);
                mainActivity.changeToast(0);
            }
        });


        return  rootView;
    }
}
