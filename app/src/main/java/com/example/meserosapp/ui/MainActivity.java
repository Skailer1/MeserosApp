package com.example.meserosapp.ui;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.meserosapp.R;
import com.example.meserosapp.data.singleton.Singleton;
import com.example.meserosapp.ui.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get Singleton instance
       // Singleton singleton = Singleton.obtenerInstancia();

        //show the string value defined by the private constructor of Singleton class
       // Toast.makeText(getApplicationContext(), singleton.getUsuarioId().toString(), Toast.LENGTH_LONG).show();



       /* FirebaseMessaging.getInstance().subscribeToTopic("mesas").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(MainActivity.this,"Suscrito a mesas",Toast.LENGTH_SHORT).show();
            }
        });*/



    }

    public void btnIngresarIdClick(View view){

        Intent intent1  = new Intent (MainActivity.this, LoginActivity.class  );

        startActivity(intent1);


    }

    public static class EstadoActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_estado);
        }
    }
}
