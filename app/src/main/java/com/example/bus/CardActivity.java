package com.example.bus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;

public class CardActivity extends Activity {

    RadioGroup rdo;
    RadioButton card1, card2, card3;
    ImageView selectedCard;
    Button btnReg;

    // 등록된 카드
    private int cardId = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card);
        setTitle("카드등록");

        rdo = (RadioGroup) findViewById(R.id.rdo);
        card1 = (RadioButton) findViewById(R.id.card1);
        card2 = (RadioButton) findViewById(R.id.card2);
        card3 = (RadioButton) findViewById(R.id.card3);
        selectedCard = (ImageView) findViewById(R.id.selectedCard);
        btnReg = (Button) findViewById(R.id.btnReg);

        rdo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch(rdo.getCheckedRadioButtonId()) {
                    case R.id.card1:
                        selectedCard.setImageResource(R.drawable.card);
                        cardId = R.drawable.card;
                        break;
                    case R.id.card2:
                        selectedCard.setImageResource(R.drawable.card2);
                        cardId = R.drawable.card2;
                        break;
                    case R.id.card3:
                        selectedCard.setImageResource(R.drawable.card3);
                        cardId = R.drawable.card3;
                        break;
                }
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("cardId", cardId);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });


    }
}
