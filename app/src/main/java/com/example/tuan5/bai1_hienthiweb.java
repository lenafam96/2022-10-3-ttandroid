package com.example.tuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class bai1_hienthiweb extends AppCompatActivity {
    private EditText bai1_hienthiweb_input;
    private Button bai1_hienthiweb_btnGo;
    private WebView bai1_hienthiweb_webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1_hienthiweb);
        Init();
        Action();
    }

    private void Init() {
        bai1_hienthiweb_input = (EditText) this.findViewById(R.id.bai1_hienthiweb_input);
        bai1_hienthiweb_btnGo = (Button) this.findViewById(R.id.bai1_hienthiweb_btnGo);
        bai1_hienthiweb_webview = (WebView) this.findViewById(R.id.bai1_hienthiweb_webview);
        WebSettings webSettings = bai1_hienthiweb_webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    private void Action() {
        bai1_hienthiweb_btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = bai1_hienthiweb_input.getText().toString();
                if(!url.isEmpty()){
                    bai1_hienthiweb_webview.loadUrl(url);
                }
            }
        });
    }
}