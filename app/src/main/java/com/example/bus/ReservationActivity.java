package com.example.bus;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class ReservationActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation);
        setTitle("하차예약");



    }
}
