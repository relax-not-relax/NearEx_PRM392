package com.example.nearex_prm392;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProductDetail extends AppCompatActivity {

    AppCompatButton btnMinus, btnPlus, btnAdd;
    TextView txtAmount;

    private int numberOfOrder = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        txtAmount = (TextView) findViewById(R.id.txtAmount);
        btnMinus = (AppCompatButton) findViewById(R.id.btnMinus);
        btnPlus = (AppCompatButton) findViewById(R.id.btnPlus);
        btnAdd = (AppCompatButton) findViewById(R.id.btnAdd);

        txtAmount.setText(String.valueOf(numberOfOrder));

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfOrder = numberOfOrder + 1;
                txtAmount.setText(String.valueOf(numberOfOrder));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOfOrder > 1) {
                    numberOfOrder = numberOfOrder - 1;
                }
                txtAmount.setText(String.valueOf(numberOfOrder));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductDetail.this, CheckOut.class));
            }
        });
    }
}