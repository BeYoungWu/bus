package com.example.bus;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ReservationActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation);
        setTitle("하차예약");

        // 자동완성텍스트뷰
        String[] items = { "광운대학교", "노원구민회관", "월계삼거리", "인덕삼거리", "중계역", "하계시영아파트", "하계역", "하계장미아파트" };
        AutoCompleteTextView auto = (AutoCompleteTextView) findViewById(R.id.search);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

        // 하차 정류장 선택 TextView
        TextView arrive = (TextView) findViewById(R.id.arrive);

    }
}
