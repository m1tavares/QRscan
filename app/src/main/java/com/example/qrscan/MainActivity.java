package com.example.qrscan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    public static final int MY_PERMISSIONS_REQUEST_CAMERA = 1;
    private ZXingScannerView zXingScannerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void scan(View view) {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);

            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            zXingScannerView = new ZXingScannerView(getApplicationContext());
            setContentView(zXingScannerView);
            zXingScannerView.setResultHandler(this);
            zXingScannerView.startCamera();

        }




    }
    protected void OnPause() {
        super.onPause();
        zXingScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        String op;
        Toast.makeText(getApplicationContext(), result.getText(), Toast.LENGTH_SHORT).show();
       op=result.getText();

        if(op.equalsIgnoreCase("SBI"))
        {
            Intent intent=new Intent(this, SBI.class);
            startActivity(intent);
        }
        else if(op.equalsIgnoreCase("HDFC"))
        {
            Intent intent=new Intent(this,HDFC.class);
            startActivity(intent);
        }
        else if(op.equalsIgnoreCase("Canadian Tire"))
        {
            Intent intent=new Intent(this,CanadianTire.class);
            startActivity(intent);
        }
        setContentView(R.layout.activity_main);
        zXingScannerView.resumeCameraPreview(this);


    }
}
