package com.example.meserosapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void btnIngresarIdClick(View view){

        Intent intent1  = new Intent (MainActivity.this, LoginActivity.class  );

        startActivity(intent1);


    }
}
