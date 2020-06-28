package com.example.meserosapp.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.meserosapp.R;
import com.example.meserosapp.ui.login.LoginActivity;

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
