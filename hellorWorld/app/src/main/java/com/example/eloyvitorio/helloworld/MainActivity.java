package com.example.eloyvitorio.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Hello World");
        Log.w("MainActivity", "Eloy warning");
        Log.e("MainActivity", "Eloy erro");
        Log.i("MainActivity", "Eloy informação");


    }
}
