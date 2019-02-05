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
        textView5 = findViewById(R.id.textViewItem5);
        textView6 = findViewById(R.id.textViewItem6);
        textView7 = findViewById(R.id.textViewItem7);
        textView8 = findViewById(R.id.textViewItem8);
        textView9 = findViewById(R.id.textViewItem9);
        textView10 = findViewById(R.id.textViewItem10);

        if (savedInstanceState != null) {
            boolean text1isVisible = savedInstanceState.getBoolean("reply_visible_1");
            boolean text2isVisible = savedInstanceState.getBoolean("reply_visible_2");
            boolean text3isVisible = savedInstanceState.getBoolean("reply_visible_3");
            boolean text4isVisible = savedInstanceState.getBoolean("reply_visible_4");
            boolean text5isVisible = savedInstanceState.getBoolean("reply_visible_5");
            boolean text6isVisible = savedInstanceState.getBoolean("reply_visible_6");
            boolean text7isVisible = savedInstanceState.getBoolean("reply_visible_7");
            boolean text8isVisible = savedInstanceState.getBoolean("reply_visible_8");
            boolean text9isVisible = savedInstanceState.getBoolean("reply_visible_9");
            boolean text10isVisible = savedInstanceState.getBoolean("reply_visible_10");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (text1isVisible) {
                textView1.setText(savedInstanceState.getString("reply_text_1"));
                textView1.setVisibility(View.VISIBLE);
            }
            if (text2isVisible) {
                textView2.setText(savedInstanceState.getString("reply_text_2"));
                textView2.setVisibility(View.VISIBLE);
            }
            if (text3isVisible) {
                textView3.setText(savedInstanceState.getString("reply_text_3"));
                textView3.setVisibility(View.VISIBLE);
            }
            if (text4isVisible) {
                textView4.setText(savedInstanceState.getString("reply_text_4"));
                textView4.setVisibility(View.VISIBLE);
            }
            if (text5isVisible) {
                textView5.setText(savedInstanceState.getString("reply_text_5"));
                textView5.setVisibility(View.VISIBLE);
            }
            if (text6isVisible) {
                textView6.setText(savedInstanceState.getString("reply_text_6"));
                textView6.setVisibility(View.VISIBLE);
            }
            if (text7isVisible) {
                textView7.setText(savedInstanceState.getString("reply_text_7"));
                textView7.setVisibility(View.VISIBLE);
            }
            if (text8isVisible) {
                textView8.setText(savedInstanceState.getString("reply_text_8"));
                textView8.setVisibility(View.VISIBLE);
            }
            if (text9isVisible) {
                textView9.setText(savedInstanceState.getString("reply_text_9"));
                textView9.setVisibility(View.VISIBLE);
            }
            if (text10isVisible) {
                textView10.setText(savedInstanceState.getString("reply_text_10"));
                textView10.setVisibility(View.VISIBLE);
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
        for (int i = 1; i <= 10; i++) {
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
        if (textView1.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible_1", true);
            outState.putString("reply_text_1", textView1.getText().toString());
        }
        if (textView2.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible_2", true);
            outState.putString("reply_text_2", textView2.getText().toString());
        }
        if (textView3.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible_3", true);
            outState.putString("reply_text_3", textView3.getText().toString());
        }
        if (textView4.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible_4", true);
            outState.putString("reply_text_4", textView4.getText().toString());
        }
        if (textView5.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible_5", true);
            outState.putString("reply_text_5", textView5.getText().toString());
        }
        if (textView6.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible_6", true);
            outState.putString("reply_text_6", textView6.getText().toString());
        }
        if (textView7.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible_7", true);
            outState.putString("reply_text_7", textView7.getText().toString());
        }
        if (textView8.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible_8", true);
            outState.putString("reply_text_8", textView8.getText().toString());
        }
        if (textView9.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible_9", true);
            outState.putString("reply_text_9", textView9.getText().toString());
        }
        if (textView10.getVisibility() == View.VISIBLE) {
            outState.putBoolean("reply_visible_10", true);
            outState.putString("reply_text_10", textView10.getText().toString());
        }
    }
}
