package com.example.fragment_lifecycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by user on 2017-03-24.
 */

public class ImageFragment extends Fragment {
    ImageView imageView;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.img_fragment,container,false);
        imageView =(ImageView)view.findViewById(R.id.iv);




        return view;
    }

    public  void setImageView(int Imgid){
        imageView.setImageResource(Imgid);
    }


}
