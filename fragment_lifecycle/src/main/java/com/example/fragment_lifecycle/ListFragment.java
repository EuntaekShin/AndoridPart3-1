package com.example.fragment_lifecycle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.fragment_lifecycle.R.id.parent;

/**
 * Created by user on 2017-03-24.
 */



public class ListFragment extends Fragment {
   String[] title = {"Image01","Image02","Image03"};

   //여러군데 사용하기 위해서 인터페이스 선언

    public static interface ImageSelection{
        public void onImageSelect(int position);

    }

    //
    public ImageSelection callback;


    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof ImageSelection){
            callback = (ImageSelection)context;
        }
    }



    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
       View view = (View)inflater.inflate(R.layout.list_fragment,container,false);
        ListView listView = (ListView)view.findViewById(R.id.lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,title);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(callback != null){
                    callback.onImageSelect(position);
                }
            }
        });




        return view;
    }
}
