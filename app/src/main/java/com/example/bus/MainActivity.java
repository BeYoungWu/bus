package com.example.bus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        // 하차예약 이동
        Button btnRes = (Button) findViewById(R.id.reservation);
        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView arrive = (TextView) findViewById(R.id.arrive);
                Intent intent = new Intent(getApplicationContext(), ReservationActivity.class);
                intent.putExtra("arrive", arrive.getText().toString());
                startActivityForResult(intent, 0);
            }
        });

        // 평가하기 이동
        Button btnEval = (Button) findViewById(R.id.evaluation);
        btnEval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EvaluationActivity.class);
                startActivity(intent);
            }
        });

    }

    // 하차예약 데이터 받아오기
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            String hap = data.getStringExtra("arrive");
            Toast.makeText(getApplicationContext(), "하차 : " + hap, Toast.LENGTH_SHORT).show();
            // TextView arrive에 "하차 : " + hap 전달하기
        }
    }
}