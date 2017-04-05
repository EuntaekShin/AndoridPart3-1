package com.example.fragment_lifecycle;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/* 프래그먼트 수명주기
1.화면에 보이기전 호출되는 메서드
onAttach(Activity)->엑티비티에 연결되는것
onCreate(Bundle) ->액티비티를 초기화 하는것
-----------
onCreateView(LayoutInflaer, ViewGroup container, Bundle )
OnActivitycreated(Bundle)
OnStart()
OnResume()

2.프래그먼트 중지시 호출되는 메서드
Onpaused()
OnStop()
OnDestroyView()  ------>OnCreateView()
OnDestroy()
OnDetach()  <-------> OnAttach()


 */

public class MainActivity extends AppCompatActivity implements ListFragment.ImageSelection{

    ListFragment listFragment;
    ImageFragment imageFragment;

    int[] imgs ={android.R.drawable.btn_star_big_off,android.R.drawable.star_on,android.R.drawable.gallery_thumb};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        listFragment  = (ListFragment)fragmentManager.findFragmentById(R.id.list_fm);
        imageFragment = (ImageFragment)fragmentManager.findFragmentById(R.id.img_fm);

    }

    public void onImageSelect(int position) {
        imageFragment.setImageView(imgs[position]);
    }
}
