package com.example.fragment_separate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 2017-03-24.
 */

public class Page02 extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.menu02_frament,container,false);
        MainActivity mainActivity =(MainActivity) getActivity();
        mainActivity.changeToast(1);
        return  view;
    }
}
