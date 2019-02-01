package com.example.eloyvitorio.challente021;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private TextView textViewOne;
    private TextView textViewTwo;
    private TextView textViewThree;
    private Intent intent;
    private String optionSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        intent = getIntent();
        optionSelected = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Log.d(LOG_TAG, "OPCAO -> " + optionSelected);
    }

    public void displayText(View view) {
        switch (optionSelected) {
            case "one":
                //Log.d(LOG_TAG, "First conditional!");
                textViewOne = (TextView) findViewById(R.id.textViewOne);
                textViewOne.setText(R.string.article_text1);
                textViewOne.setVisibility(View.VISIBLE);
                break;
            case "two":
                //Log.d(LOG_TAG, "Second conditional!");
                textViewTwo = (TextView) findViewById(R.id.textViewTwo);
                textViewTwo.setText(R.string.article_text2);
                textViewTwo.setVisibility(View.VISIBLE);
                break;
            default:
                //Log.d(LOG_TAG, "Three conditional!");
                textViewThree = (TextView) findViewById(R.id.textViewThree);
                textViewThree.setText(R.string.article_text3);
                textViewThree.setVisibility(View.VISIBLE);
                break;
        }
    }
}
