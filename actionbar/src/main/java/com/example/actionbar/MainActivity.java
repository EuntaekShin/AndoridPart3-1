package com.example.actionbar;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    android.support.v7.app.ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //1.액션바 참조하기
        actionBar = getSupportActionBar();
        //2,서브타이틀 설정
        actionBar.setSubtitle("서브타이틀");

        textView = (TextView)findViewById(R.id.tv01);

        // show와 hide를 통해서 보여줄수 있다

    }
    public void btnClicked (View v){
        //actionBar 셋팅
        actionBar.setLogo(android.R.drawable.ic_dialog_info);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_USE_LOGO);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);

        return true;
    }

    //메뉴를 선택했을때 처리하는 메서드
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item01:
                textView.setText("메뉴1");
                break;
            case R.id.item02:
                textView.setText("메뉴2");
                break;
            case  R.id.item03:
                textView.setText("메뉴3");
        }

        return false;
    }
}