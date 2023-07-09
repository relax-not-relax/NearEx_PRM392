package com.example.nearex_prm392;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Verify extends AppCompatActivity {

    AppCompatButton btnBack, btnNext, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        btnBack = (AppCompatButton) findViewById(R.id.buttonBack);
        btnNext = (AppCompatButton) findViewById(R.id.buttonNext);
        btnCancel = (AppCompatButton) findViewById(R.id.buttonCancel);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Verify.this, LoginActivity.class));
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Verify.this, DoneVerify.class));
            }
        });
    }
}