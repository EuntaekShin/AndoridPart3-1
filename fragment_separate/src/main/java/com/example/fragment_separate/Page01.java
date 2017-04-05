package com.example.fragment_separate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by user on 2017-03-24.
 */

//메뉴 프레그먼트 만든 다음 두번째로 만든 것
public class Page01 extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.menu01_fragment,container,false);

        Button btn = (Button)view.findViewById(R.id.btn01);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            MainActivity mainActivity =(MainActivity) getActivity();
                mainActivity.changeToast(0);

            }
        });
        return  view;
    }

}
