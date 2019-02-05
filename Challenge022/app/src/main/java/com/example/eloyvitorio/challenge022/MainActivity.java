package com.example.eloyvitorio.challenge022;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.eloyvitorio.challenge022.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textViewItem1);
        textView2 = findViewById(R.id.textViewItem2);
        textView3 = findViewById(R.id.textViewItem3);
        textView4 = findViewById(R.id.textViewItem4);
        textView5 = findViewById(R.id.textViewItem6);
        textView6 = findViewById(R.id.textViewItem7);
        textView8= findViewById(R.id.textViewItem8);
        textView9 = findViewById(R.id.textViewItem9);
        textView1 = findViewById(R.id.textViewItem10);

        if (savedInstanceState != null) {
            boolean text1isVisible = savedInstanceState.getBoolean("reply_visible_1");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (text1isVisible) {
                textView1.setText(savedInstanceState.getString("reply_text_1"));
                textView1.setVisibility(View.VISIBLE);
                // REPLICAR PARA OS OUTROS ITENS DA TELA
            }

        }

    }

    public void openProductsList(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                TextView element = checkNextTextViewAvailable();
                element.setVisibility(View.VISIBLE);
                element.setText(reply);
            }
        }
    }

    private TextView checkNextTextViewAvailable() {
        TextView result = null;
        for(int i = 1; i <= 10; i++) {
            String resourceName = "textViewItem" + i;
            int resourceID = getResources().getIdentifier(resourceName, "id",
                    getPackageName());
            if (resourceID != 0) {
                TextView viewElement = (TextView) findViewById(resourceID);
                if (viewElement != null) {
                    String text = viewElement.getText().toString();
                    if (text.isEmpty()) result = viewElement;
                }
            }

        }
        return result;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(textView1.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible_1", true);
            outState.putString("reply_text_1", textView1.getText().toString());
        }
    }
}
