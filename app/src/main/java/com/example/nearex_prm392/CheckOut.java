package com.example.nearex_prm392;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CheckOut extends AppCompatActivity {

    AppCompatButton btnCheckOut;
    TextView txtPaymentMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        btnCheckOut = (AppCompatButton) findViewById(R.id.btnCheckOut);
        txtPaymentMethod = (TextView) findViewById(R.id.txtPaymentMethod);

        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckOut.this, DoneCheckOut.class));
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