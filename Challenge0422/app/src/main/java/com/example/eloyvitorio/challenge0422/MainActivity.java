package com.example.eloyvitorio.challenge0422;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.edittext_main);
        if (editText != null) {
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                // If view is found, set the listener for editText.
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    boolean handled = false;
                    if (actionId == EditorInfo.IME_ACTION_SEND) {
                        dialNumber();
                        handled = true;
                    }
                    return handled;
                }
            });
        }
    }

    private void dialNumber() {
        // Find the editText_main in view
        EditText editText = findViewById(R.id.edittext_main);
        String phoneNum = null;
        // If the editText field is not null,
        // concatenate "Tell: " with the phone number string
        if (editText != null)
            phoneNum = "tel:" + editText.getText().toString();

        // Optional: log the concatenated phone number for dialing
        Log.d(LOG_TAG,"dialNumber: " + phoneNum);
        // Specify the intent
        Intent intent = new Intent(Intent.ACTION_DIAL);
        // Set the data for the intent as the phone number
        intent.setData(Uri.parse(phoneNum));
        // If the intent resolves to a package (app)
        // start the activity with the intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can`t handle this!");
        }
    }
}
