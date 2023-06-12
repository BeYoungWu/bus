package com.example.bus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnRes, btnEval, dialogBtnRes, dialogBtnReturn, btnCard;
    TextView arrive, dialogArrive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인화면");

        btnRes = (Button) findViewById(R.id.btnRes);
        btnEval = (Button) findViewById(R.id.btnEval);
        btnRes = (Button) findViewById(R.id.btnRes);
        arrive = (TextView) findViewById(R.id.arrive);

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 대화상자
                View dialogView = getLayoutInflater().inflate(R.layout.reservation, null);

                // 자동완성텍스트뷰
                final String[] items = { "광운대학교", "노원구민회관", "월계삼거리", "인덕삼거리", "중계역", "하계시영아파트", "하계역", "하계장미아파트" };
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, items);
                AutoCompleteTextView auto = (AutoCompleteTextView) dialogView.findViewById(R.id.dialogSearch);
                auto.setAdapter(adapter);

                // 대화상자
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setView(dialogView);
                dlg.setNegativeButton("취소", null);
                dlg.setPositiveButton("예약하기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        arrive.setText("하차 : " + dialogArrive.getText().toString());
                    }
                });
                dlg.show();

                // 하차예약 (자동완성텍스트뷰에 값을 지정하면 TextView에도 값 넘기기)
                auto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String selectedValue = (String) adapterView.getItemAtPosition(i);
                        dialogArrive = (TextView) dialogView.findViewById(R.id.dialogArrive);
                        dialogArrive.setText(selectedValue);
                    }
                });
            }
        });

        // 평가하기 이동
        Button btnEval = (Button) findViewById(R.id.btnEval);
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