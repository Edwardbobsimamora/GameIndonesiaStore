package com.example.gameindonesiastore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.bumptech.glide.Glide;

public class CartConfirmationActivity extends AppCompatActivity {
    public static final String EXTRA_PHOTO = "extra_photo";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_PRICE = "extra_price";

    ImageView ivImageReceived;
    TextView tvNameReceived;
    TextView tvPriceReceived;
    TextView tvCartPrice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_confirmation);

        String photo = getIntent().getStringExtra(EXTRA_PHOTO);
        ivImageReceived = findViewById(R.id.img_item_photo);
        Glide.with(this)
                .load(photo)
                .into(ivImageReceived);

        tvNameReceived = findViewById(R.id.tv_item_name);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        tvNameReceived.setText(name);

        tvPriceReceived = findViewById(R.id.tv_item_price);
        tvCartPrice = findViewById(R.id.cart_price);
        String price = getIntent().getStringExtra(EXTRA_PRICE);
        tvPriceReceived.setText(price);
        tvCartPrice.setText(price);


        Button buttonBuy = findViewById(R.id.buy_btn);
        buttonBuy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(CartConfirmationActivity.this, ReceiptActivity.class);
                i.putExtra(GamesDetailActivity.EXTRA_NAME, name);
                i.putExtra(GamesDetailActivity.EXTRA_PRICE, price);
                startActivity(i);
            }

        });

        ImageView buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                backToMenu();
            }

        });

    }

    public void backToMenu() {
        this.finish();
    }



}
