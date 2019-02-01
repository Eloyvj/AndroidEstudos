package com.example.eloyvitorio.challente021;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.eloyvitorio.challente021.extra.MESSAGE";
    private String optionSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tapButtonTextOne(View view) {
        Log.d(LOG_TAG, "Button text one clicked!");
        optionSelected = "one";
        Intent intent1 = new Intent(this, SecondActivity.class);
        intent1.putExtra(EXTRA_MESSAGE, optionSelected);
        startActivity(intent1);
    }

    public void tapButtonTextTwo(View view) {
        Log.d(LOG_TAG, "Button text two clicked!");
        optionSelected = "two";
        Intent intent2 = new Intent(this, SecondActivity.class);
        intent2.putExtra(EXTRA_MESSAGE, optionSelected);
        startActivity(intent2);
    }

    public void tapButtonTextThree(View view) {
        Log.d(LOG_TAG, "Button text three clicked!");
        optionSelected = "three";
        Intent intent3 = new Intent(this, SecondActivity.class);
        intent3.putExtra(EXTRA_MESSAGE, optionSelected);
        startActivity(intent3);
    }
}
