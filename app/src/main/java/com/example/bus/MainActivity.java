package com.example.bus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인화면");

        // 자동완성텍스트뷰
        String[] items = { "광운대학교", "노원구민회관", "월계삼거리", "인덕삼거리", "중계역", "하계시영아파트", "하계역", "하계장미아파트" };
        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.search);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

    }
}