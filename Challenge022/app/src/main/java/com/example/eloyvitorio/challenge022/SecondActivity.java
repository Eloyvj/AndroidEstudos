package com.example.eloyvitorio.challenge022;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.eloyvitorio.challenge022.extra.REPLY";
    private Button buttonOrange;
    private Button buttonMango;
    private Button buttonApple;
    private Button buttonPineaple;
    private Button buttonRice;
    private Button buttonBanana;
    private Button buttonTomato;
    private Button buttonPotato;
    private Button buttonBean;
    private Button buttonCheese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();

        buttonOrange = findViewById(R.id.orangeButton);
        buttonMango = findViewById(R.id.mangoButton);
        buttonApple = findViewById(R.id.appleButton);
        buttonPineaple = findViewById(R.id.pineapleButton);
        buttonRice = findViewById(R.id.riceButton);
        buttonBanana = findViewById(R.id.bananaButton);
        buttonTomato = findViewById(R.id.tomatoButton);
        buttonPotato = findViewById(R.id.potatoButton);
        buttonBean = findViewById(R.id.beanButton);
        buttonCheese = findViewById(R.id.cheeseButton);

    }

    public void addOrange(View view) {
        String text = buttonOrange.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, text);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void addMango(View view) {
        String text = buttonMango.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, text);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void addApple(View view) {
        String text = buttonApple.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, text);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void addPineaple(View view) {
        String text = buttonPineaple.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, text);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void addRice(View view) {
        String text = buttonRice.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, text);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void addBanana(View view) {
        String text = buttonBanana.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, text);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void addTomato(View view) {
        String text = buttonTomato.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, text);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void addPotato(View view) {
        String text = buttonPotato.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, text);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void addBean(View view) {
        String text = buttonBean.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, text);
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    public void addCheese(View view) {
        String text = buttonCheese.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, text);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
