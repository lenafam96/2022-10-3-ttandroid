package com.example.tuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class bai2 extends AppCompatActivity {
    private EditText bai2_inputNumber, bai2_inputMessage;
    private ImageView bai2_imageView;
    private Button bai2_btn_view, bai2_btn_replace, bai2_btn_remove, bai2_btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        Init();
        Action();
    }

    private void Init() {
        bai2_inputNumber = (EditText) this.findViewById(R.id.bai2_inputNumber);
        bai2_inputMessage = (EditText) this.findViewById(R.id.bai2_inputMessage);
        bai2_imageView = (ImageView) this.findViewById(R.id.bai2_imageView);
        bai2_btn_view = (Button) this.findViewById(R.id.bai2_btn_view);
        bai2_btn_replace = (Button) this.findViewById(R.id.bai2_btn_replace);
        bai2_btn_remove = (Button) this.findViewById(R.id.bai2_btn_remove);
        bai2_btn_send = (Button) this.findViewById(R.id.bai2_btn_send);
    }

    private void Action() {
        bai2_btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        bai2_btn_replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        bai2_btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bai2_imageView.setImageDrawable(null);
            }
        });
        bai2_btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}