package com.example.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
/*
fragment
v.30(허니콤) 버전부터는 테블릿을 사용할 수 있는걸 제공하였다
하나의 액티비티에서 여러 기능을 사용할 수 있게 하는것
화면을 분할하기 위해서 분할 해서 사용하기 위함
엑티비티도 화면 분할을 할 수 있지만, 엑티비티를 사용하면 훨씬 더 복잡해 진다
프래그멘트도 액티비티 위에 올라와 있어야 한다.

액티비티는 액티비티 매니저가 Intent를 통해서 엑티비티간의 이동을한다
프레그먼트는 프레그먼트 매니저가 메소드를 통해서 프레그먼트를 관리한다.

프레그먼트 구현 방법(xml(프래그먼트만들기) ->fragment 클래스 ->액티비티 xml에 추가하기
1.xml레이아웃만들기 + java코드(inflatation)
2.<fragment>        <onCrateView>
                      fragment 상속 -> getActivity  (현재 가지고 있는 액티비를 리턴)
                                       getFragmentManager(프래그먼트 매니저를 리턴)
                                       getParentFragment(부모 프래그먼트가 있는경우 리턴)
                                       getId
3.java코드만을 가지고도 만들수있음(new 연산자를 이용-> Fragment매니저)
new -> Fragment ->add()액티비티에 추가

getFragmentManger를 통해서 만들수 있다.
FragmentManager .add(), replace(). remove();
문제가 발생시 기존으로 돌아오기 위해서 transaction 이 필요하다.

beginTransaction()
findFramentById()
findFragmentByTag()
*/

public class MainActivity extends AppCompatActivity {
    Fragment01 fragment01;
    Fragment02 fragment02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        getFragmentManager()
        getSupportFragmentManger() ->3.0이전버전도 쓸수 있도록 하기 위해서 이걸 쓰는게 좋다
         */

        //v4로 해야한다
        fragment01 = (Fragment01) getSupportFragmentManager().findFragmentById(R.id.frag01);
        fragment02 = new Fragment02();

    }
    public void onFragmentChanged(int index){
        if(index ==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.parentView,fragment02).commit();
        }else if(index ==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.parentView,fragment01).commit();
        }

    }
    public void changeToast(int index){
        LayoutInflater inflater = getLayoutInflater();
        View toastView = inflater.inflate(R.layout.toast_shape,(ViewGroup)findViewById(R.id.linear));
        if(index ==0){
        //토스트에 보여질 메세지
        TextView textView = (TextView) toastView.findViewById(R.id.tv_shape);
        textView.setText("첫번째 프래그먼트 입니다");

        //토스트 생성하기
        Toast toast = new Toast(this);
        toast.setGravity(Gravity.CENTER_VERTICAL,50,50);
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
        }
    }

}
