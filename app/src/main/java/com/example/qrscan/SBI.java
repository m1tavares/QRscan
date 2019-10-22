package com.example.qrscan;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class SBI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sbi1);

    }
    public void OnClick(View v)
    {
        Toast.makeText(getApplicationContext(),"Thank You",Toast.LENGTH_LONG).show();
    }

}
