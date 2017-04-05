package com.example.actionbar_search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.tv01);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);

        //커스텀 레이아웃 을 객체화 한 후 참조해야한다
        View findView  = menu.findItem(R.id.item02).getActionView();

        if(findView != null){
           editText = (EditText) findView.findViewById(R.id.et01);

            if(editText != null){
                editText.setOnEditorActionListener(findListener);
            }
        } else{
            Toast.makeText(getApplicationContext(),"액션뷰가 없다!",Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item01:
                textView.setText("메뉴1");
                return  true;
            case R.id.item02:

                String menu2=editText.getText().toString();
                textView.setText(menu2);
                return  true;
            case R.id.item03:
                textView.setText("메뉴3");
                return  true;

        }
        return super.onOptionsItemSelected(item);
    }

     TextView.OnEditorActionListener findListener = new TextView.OnEditorActionListener(){
         public boolean onEditorAction(TextView tv, int actionId, KeyEvent ke){
             if(ke == null || ke.getAction() == KeyEvent.ACTION_UP){
                 find();


                //키패드처리 객체(inputMethodManager 객체)
                 InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

                 //키패드 닫기
                 inputMethodManager.hideSoftInputFromWindow(tv.getWindowToken(),0);
                 String menu2=editText.getText().toString();
                 textView.setText(menu2);


             }

             return true;
         }

     };

     private void find(){
         String findString = editText.getEditableText().toString();
         Toast.makeText(this,"검색어"+findString,Toast.LENGTH_SHORT).show();
     }


}
