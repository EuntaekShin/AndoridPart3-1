package com.example.tab_menu;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    /*
    롤리팝 버전 이후 Tool Bar를 이용
    FrameLayout을 이용해서 도 가능
     */
    Toolbar toolbar;

    Fragment01 fragment01;
    Fragment02 fragment02;
    Fragment03 fragment03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);


        fragment01 = new Fragment01();
        fragment02 = new Fragment02();
        fragment03 = new Fragment03();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment01).commit();

        TabLayout tabs =(TabLayout)findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("탭메뉴1"));
        tabs.addTab(tabs.newTab().setText("탭메뉴2"));
        tabs.addTab(tabs.newTab().setText("탭메뉴3"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                Fragment selected =null;

                if(position==0){
                    selected = fragment01;
                }else if(position ==1){
                    selected = fragment02;

                }else if(position==2){
                    selected = fragment03;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {



            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
