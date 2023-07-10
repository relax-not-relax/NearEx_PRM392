package com.example.nearex_prm392;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PaymentMethod extends AppCompatActivity {

    AppCompatButton btnBack, btnVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        btnBack = (AppCompatButton) findViewById(R.id.buttonBack);
        btnVerify = (AppCompatButton) findViewById(R.id.btnVerify);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaymentMethod.this, CheckOut.class));
            }
        });

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaymentMethod.this, CheckOut.class));
            }
        });
    }
}