package com.example.fragment_separate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by user on 2017-03-24.
 */

public class Page03 extends Fragment {

    EditText editText,editText2,editText3;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu03_fragment,container,false);

        Button button = (Button)view.findViewById(R.id.tv03);
        editText = (EditText)view.findViewById(R.id.edit1);
        editText2 = (EditText)view.findViewById(R.id.edit2);
        editText3 = (EditText)view.findViewById(R.id.edit3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String input1 = editText.getText().toString();
                    String input2 = editText2.getText().toString();
                    int input3 = Integer.parseInt(input1);
                    int input4 = Integer.parseInt(input2);
                    int sum = input3 + input4;
                    editText3.setText(String.valueOf(sum));
                } catch (Exception e) {
                    Toast.makeText(getContext(), "값을 입력하야죠", Toast.LENGTH_SHORT).show();
                }
            }
        });
        MainActivity mainActivity =(MainActivity) getActivity();
        mainActivity.changeToast(2);


        return view;



    }
}
