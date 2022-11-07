package com.example.tuan5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class bai1_goidien extends AppCompatActivity {
    private static final int MY_PERMISSION_REQUEST_CODE_CALL_PHONE = 555;
    private EditText bai1_goidien_input;
    private Button bai1_goidien_btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1_goidien);
        Init();
        Action();
    }

    private void Init() {
        bai1_goidien_input = (EditText) this.findViewById(R.id.bai1_goidien_input);
        bai1_goidien_btnCall = (Button) this.findViewById(R.id.bai1_goidien_btnCall);
    }

    private void Action() {
        bai1_goidien_input.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        bai1_goidien_btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askPermissionCall();
                if(bai1_goidien_input.getText().length()>0){
                    bai1_goidien_input.setText(PhoneNumberUtils.formatNumber(bai1_goidien_input.getText().toString()));
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+bai1_goidien_input.getText()));
                    try {
                        startActivity(callIntent);
                    } catch (Exception e){
                        Toast.makeText(bai1_goidien.this,"Your call failed..." + e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void askPermissionCall() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            int sendSmsPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if(sendSmsPermission!= PackageManager.PERMISSION_GRANTED){
                this.requestPermissions(
                        new String[]{ Manifest.permission.CALL_PHONE }, MY_PERMISSION_REQUEST_CODE_CALL_PHONE
                );
                return;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case MY_PERMISSION_REQUEST_CODE_CALL_PHONE:
            {
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(bai1_goidien.this,"Permission granted!",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(bai1_goidien.this,"Permission denied!",Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}