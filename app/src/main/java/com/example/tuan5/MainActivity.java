package com.example.tuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_bai1,btn_bai2,btn_bai3,btn_bai4,btn_bai5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
        Action();
    }

    private void Init() {
        btn_bai1 = (Button) this.findViewById(R.id.btn_bai1);
        btn_bai2 = (Button) this.findViewById(R.id.btn_bai2);
        btn_bai3 = (Button) this.findViewById(R.id.btn_bai3);
        btn_bai4 = (Button) this.findViewById(R.id.btn_bai4);
        btn_bai5 = (Button) this.findViewById(R.id.btn_bai5);
    }

    private void Action() {
        btn_bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,bai1.class);
                startActivity(intent);
            }
        });
        btn_bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,bai2.class);
                startActivity(intent);
            }
        });
    }
}