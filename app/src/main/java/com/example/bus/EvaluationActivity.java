package com.example.bus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class EvaluationActivity extends Activity {

    private int rating = 0;
    private TextView textSelectedItems;
    private ImageView star1, star2, star3, star4, star5;
    private CheckBox checkItem1, checkItem2, checkItem3, checkItem4, checkItem5;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluation);
        setTitle("평가하기");

        textSelectedItems = findViewById(R.id.textSelectedItems);
        star1 = findViewById(R.id.star1);
        star2 = findViewById(R.id.star2);
        star3 = findViewById(R.id.star3);
        star4 = findViewById(R.id.star4);
        star5 = findViewById(R.id.star5);
        checkItem1 = findViewById(R.id.checkItem1);
        checkItem2 = findViewById(R.id.checkItem2);
        checkItem3 = findViewById(R.id.checkItem3);
        checkItem4 = findViewById(R.id.checkItem4);
        checkItem5 = findViewById(R.id.checkItem5);
        submit = findViewById(R.id.btnSubmit);

        //  첫번째 별 클릭 이벤트
        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rating = 1;
                updateStarRating();
            }
        });

        //  두번째 별 클릭 이벤트
        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rating = 2;
                updateStarRating();
            }
        });

        //  세번째 별 클릭 이벤트
        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rating = 3;
                updateStarRating();
            }
        });

        //  네번째 별 클릭 이벤트
        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rating = 4;
                updateStarRating();
            }
        });

        //  다섯번째 별 클릭 이벤트
        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rating = 5;
                updateStarRating();
            }
        });

        // 평가 사항 선택시 텍스트 띄우기
        checkItem1.setOnCheckedChangeListener((buttonView, isChecked) -> updateSelectedItems());
        checkItem2.setOnCheckedChangeListener((buttonView, isChecked) -> updateSelectedItems());
        checkItem3.setOnCheckedChangeListener((buttonView, isChecked) -> updateSelectedItems());
        checkItem4.setOnCheckedChangeListener((buttonView, isChecked) -> updateSelectedItems());
        checkItem5.setOnCheckedChangeListener((buttonView, isChecked) -> updateSelectedItems());

        // 제출 버튼 클릭 이벤트
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                System.out.println(rating);
                intent.putExtra("rating", rating);
                System.out.println(intent);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    // 별 클릭시 색칠되기 메서드
    private void updateStarRating() {
        star1.setImageResource(rating >= 1 ? R.drawable.star_filled : R.drawable.star_empty);
        star2.setImageResource(rating >= 2 ? R.drawable.star_filled : R.drawable.star_empty);
        star3.setImageResource(rating >= 3 ? R.drawable.star_filled : R.drawable.star_empty);
        star4.setImageResource(rating >= 4 ? R.drawable.star_filled : R.drawable.star_empty);
        star5.setImageResource(rating >= 5 ? R.drawable.star_filled : R.drawable.star_empty);
    }

    // 평가 사항 선택시 텍스트 띄우기 메서드
    private void updateSelectedItems() {
        StringBuilder items = new StringBuilder();
        if (checkItem1.isChecked()) {
            items.append("청결, ");
        }
        if (checkItem2.isChecked()) {
            items.append("친절, ");
        }
        if (checkItem3.isChecked()) {
            items.append("안전운행, ");
        }
        if (checkItem4.isChecked()) {
            items.append("신속, ");
        }
        if (checkItem5.isChecked()) {
            items.append("편리, ");
        }

        String selectedItems = items.toString();
        if (selectedItems.isEmpty()) {
            textSelectedItems.setText("선택된 항목: 없음");
        } else {
            selectedItems = selectedItems.substring(0, selectedItems.length() - 2); // Remove trailing comma and space
            textSelectedItems.setText("선택된 항목: " + selectedItems);
        }
    }

}
