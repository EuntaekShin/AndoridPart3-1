package com.example.fragment_separate;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnmenu01, btnmenu02,btnmenu03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnmenu01=(Button)findViewById(R.id.btn_menu01);
        btnmenu02=(Button)findViewById(R.id.btn_menu02);
        btnmenu03=(Button)findViewById(R.id.btn_menu03);

        btnmenu01.setOnClickListener(onClickListener);
        btnmenu02.setOnClickListener(onClickListener);
        btnmenu03.setOnClickListener(onClickListener);


    }



    private  void addPage01(){
        Page01 page01 = new Page01();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rigth_linear,page01);
        fragmentTransaction.commit();
    }

    private  void addPage02(){
        Page02 page02 = new Page02();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rigth_linear,page02);
        fragmentTransaction.commit();

    }

    private  void addPage03(){
        Page03 page03 = new Page03();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rigth_linear,page03);
        fragmentTransaction.commit();

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_menu01:
                    addPage01();
                    break;
                case R.id.btn_menu02:
                    addPage02();
                    break;
                case R.id.btn_menu03:
                    addPage03();
                    break;


            }
        }
    };

    public void changeToast(int index){
        LayoutInflater inflater = getLayoutInflater();
        View toastView = inflater.inflate(R.layout.toast_shape,(ViewGroup)findViewById(R.id.linear));
        if(index ==0){
            //토스트에 보여질 메세지
            TextView textView = (TextView) toastView.findViewById(R.id.tv_shape);
            textView.setText("첫번째 프래그먼트 입니다");

            //토스트 생성하기
            Toast toast = new Toast(this);
            //toast.setGravity(Gravity.CENTER_VERTICAL,50,50);
            toast.setDuration(Toast.LENGTH_LONG);

            toast.setView(toastView);
            toast.show();

        }else if(index ==1){
            //토스트에 보여질 메세지
            TextView textView = (TextView) toastView.findViewById(R.id.tv_shape);
            textView.setText("두번째 프래그먼트 입니다");

            //토스트 생성하기
            Toast toast = new Toast(this);
            //toast.setGravity(Gravity.CENTER,50,50);
            toast.setDuration(Toast.LENGTH_LONG);

            toast.setView(toastView);
            toast.show();
        }else if(index ==2) {
            //토스트에 보여질 메세지
            TextView textView = (TextView) toastView.findViewById(R.id.tv_shape);
            textView.setText("세번째 프래그먼트 입니다");

            //토스트 생성하기
            Toast toast = new Toast(this);
            //toast.setGravity(Gravity.CENTER,50,50);
            toast.setDuration(Toast.LENGTH_LONG);

            toast.setView(toastView);
            toast.show();
        }
    }
}
