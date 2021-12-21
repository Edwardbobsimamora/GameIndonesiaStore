package com.example.gameindonesiastore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;

import com.bumptech.glide.Glide;

public class GamesDetailActivity extends AppCompatActivity {
    public static final String EXTRA_PHOTO = "extra_photo";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_PRICE = "extra_price";
    public static final String EXTRA_DEVELOPER = "extra_developer";
    public static final String EXTRA_DETAIL = "extra_detail";

    ImageView ivImageReceived;
    TextView tvImageNameReceived;
    TextView tvNameReceived;
    TextView tvPriceReceived;
    TextView tvDeveloperReceived;
    TextView tvDetailReceived;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        String photo = getIntent().getStringExtra(EXTRA_PHOTO);
        ivImageReceived = findViewById(R.id.iv_image);
        Glide.with(this)
                .load(photo)
                .into(ivImageReceived);

        //ivImageReceived.setImageResource(photo);

        tvNameReceived = findViewById(R.id.tv_game_name);
        tvImageNameReceived = findViewById(R.id.tv_image_name);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        tvNameReceived.setText(name);
        tvImageNameReceived.setText(name);

        tvPriceReceived = findViewById(R.id.tv_game_price);
        String price = getIntent().getStringExtra(EXTRA_PRICE);
        tvPriceReceived.setText(price);

        tvDeveloperReceived = findViewById(R.id.tv_game_dev);
        String developer = getIntent().getStringExtra(EXTRA_DEVELOPER);
        tvDeveloperReceived.setText(developer);

        tvDetailReceived = findViewById(R.id.tv_game_detail);
        String detail = getIntent().getStringExtra(EXTRA_DETAIL);
        tvDetailReceived.setText(detail);

        ImageView buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                backToMenu();
            }

        });

        AppCompatImageButton buttonCart = findViewById(R.id.cart_btn);
        buttonCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(GamesDetailActivity.this, CartConfirmationActivity.class);
                i.putExtra(GamesDetailActivity.EXTRA_NAME, name);
                i.putExtra(GamesDetailActivity.EXTRA_PRICE, price);
                i.putExtra(GamesDetailActivity.EXTRA_PHOTO, photo);
                startActivity(i);
            }
        });
    }

    public void backToMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        this.finish();
        startActivity(intent);
    }
}
