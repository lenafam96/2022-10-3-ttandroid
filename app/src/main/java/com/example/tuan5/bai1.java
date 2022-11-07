package com.example.tuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bai1 extends AppCompatActivity {
    private Button btn_goidien,btn_nhantin,btn_hienthiweb,btn_hienthitoado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        Init();
        Action();
    }

    private void Init() {
        btn_goidien = (Button) this.findViewById(R.id.btn_goidien);
        btn_nhantin = (Button) this.findViewById(R.id.btn_nhantin);
        btn_hienthiweb = (Button) this.findViewById(R.id.btn_hienthiweb);
        btn_hienthitoado = (Button) this.findViewById(R.id.btn_hienthitoado);
    }

    private void Action() {
        btn_goidien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bai1.this,bai1_goidien.class);
                startActivity(intent);
            }
        });
        btn_nhantin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bai1.this,bai1_nhantin.class);
                startActivity(intent);
            }
        });
        btn_hienthiweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bai1.this,bai1_hienthiweb.class);
                startActivity(intent);
            }
        });
    }
}