package com.example.gameindonesiastore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReceiptActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_PRICE = "extra_price";

    TextView tvNameReceived;
    TextView tvPriceReceived;
    TextView tvNominalReceived;

    TextView dateDisplay;
    TextView timeDisplay;
    Calendar calendar;
    SimpleDateFormat dateFormat;
    SimpleDateFormat timeFormat;
    String date, time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        tvNameReceived = findViewById(R.id.tv_game_name);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        tvNameReceived.setText(name);

        tvPriceReceived = findViewById(R.id.tv_game_price);
        tvNominalReceived = findViewById(R.id.tv_game_nominal);
        String price = getIntent().getStringExtra(EXTRA_PRICE);
        tvPriceReceived.setText(price);
        tvNominalReceived.setText(price);

        dateDisplay = findViewById(R.id.tv_date);
        timeDisplay = findViewById(R.id.tv_time);
        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        timeFormat = new SimpleDateFormat("h:mm a");
        date = dateFormat.format(calendar.getTime());
        time = timeFormat.format(calendar.getTime());
        dateDisplay.setText(date);
        timeDisplay.setText(time);

        Button buttonHome = findViewById(R.id.home_btn);
        buttonHome.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                backToHome();
            }

        });
    }

    public void backToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        this.finish();
        startActivity(intent);
    }
}
