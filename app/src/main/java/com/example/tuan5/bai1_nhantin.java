package com.example.tuan5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class bai1_nhantin extends AppCompatActivity {
    private static final int MY_PERMISSION_REQUEST_CODE_SEND_SMS = 1;
    private EditText bai1_nhantin_inputNumber, bai1_nhantin_inputMessage;
    private Button bai1_nhantin_btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1_nhantin);
        Init();
        Action();
    }

    private void Init() {
        bai1_nhantin_inputNumber = (EditText) this.findViewById(R.id.bai1_nhantin_inputNumber);
        bai1_nhantin_inputMessage = (EditText) this.findViewById(R.id.bai1_nhantin_inputMessage);
        bai1_nhantin_btnSend = (Button) this.findViewById(R.id.bai1_nhantin_btnSend);
    }

    private void Action() {
        bai1_nhantin_btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askPermission();
                if(bai1_nhantin_inputNumber.getText().length()>0 && bai1_nhantin_inputMessage.getText().length()>0){
                    try {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(bai1_nhantin_inputNumber.getText().toString(),null,bai1_nhantin_inputMessage.getText().toString(),null,null);
                        Toast.makeText(bai1_nhantin.this,"Your sms has successfully sent!",Toast.LENGTH_SHORT).show();
                        Intent back = new Intent(bai1_nhantin.this,bai1.class);
                        startActivity(back);
                    } catch (Exception e) {
                        Toast.makeText(bai1_nhantin.this,"Your sms has failed..."+e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void askPermission() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            int sendSmsPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
            if(sendSmsPermission!= PackageManager.PERMISSION_GRANTED){
                this.requestPermissions(
                        new String[]{ Manifest.permission.SEND_SMS }, MY_PERMISSION_REQUEST_CODE_SEND_SMS
                );
                return;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case MY_PERMISSION_REQUEST_CODE_SEND_SMS:
            {
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(bai1_nhantin.this,"Permission granted!",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(bai1_nhantin.this,"Permission denied!",Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}