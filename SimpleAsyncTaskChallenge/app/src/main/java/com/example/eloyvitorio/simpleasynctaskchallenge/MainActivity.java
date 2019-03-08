package com.example.eloyvitorio.simpleasynctaskchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

/**
 * The SimpleAsyncTask app contains a button that launches an AsyncTask
 * which sleeps in the asynchronous thread for a random amount of time.
 */
public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private ProgressBar mProgressBar;
    private int randomNumber;
    private int threadTime;
    private static final String TEXT_STATE = "currentText";
    private static final String THREAD_TIME = "threadTime";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textview1);
        mProgressBar = findViewById(R.id.progressBar); //progress bar

        // Restore TextView and progress bar
        // if there is a savedInstanceState
        if(savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
            mProgressBar.setMax(savedInstanceState.getInt(THREAD_TIME));
            mProgressBar.setVisibility(View.VISIBLE);
            mProgressBar.setProgress(savedInstanceState.getInt(THREAD_TIME));

            // Restart the AsyncTask.
            new SimpleAsyncTask(mTextView, mProgressBar).execute(savedInstanceState.getInt(THREAD_TIME));
        }
    }

    /**`
     * Handles the onCLick for the "Start Task" button. Launches the AsyncTask
     * which performs work off of the UI thread.
     *
     * @param view The view (Button) that was clicked.
     */
    public void startTask(View view) {
        // Put a message in the text view
        mTextView.setText(R.string.napping);

        Random r = new Random();
        randomNumber = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        threadTime = randomNumber * 10;

        // Set max size of progress bar, initial progress and visibility
        mProgressBar.setMax(threadTime);
        mProgressBar.setVisibility(View.VISIBLE);
        mProgressBar.setProgress(0);


        // Start the AsyncTask.
        new SimpleAsyncTask(mTextView, mProgressBar).execute(threadTime);
    }

    // Saved the state of Text View message and the amount time of thread execution
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_STATE, mTextView.getText().toString());
        outState.putInt(THREAD_TIME, threadTime);
    }
}
