package com.example.nearex_prm392;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CheckOut extends AppCompatActivity {

    AppCompatButton btnCheckOut, btnBack;
    TextView txtPaymentMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        btnCheckOut = (AppCompatButton) findViewById(R.id.btnCheckOut);
        btnBack = (AppCompatButton) findViewById(R.id.buttonBack);
        txtPaymentMethod = (TextView) findViewById(R.id.txtPaymentMethod);

        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckOut.this, DoneCheckOut.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        txtPaymentMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckOut.this, PaymentMethod.class));
            }
        });
    }
}