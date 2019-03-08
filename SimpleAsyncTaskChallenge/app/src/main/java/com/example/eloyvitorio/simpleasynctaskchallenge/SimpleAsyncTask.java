package com.example.eloyvitorio.simpleasynctaskchallenge;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask <Integer, Integer, String> {

    private WeakReference<TextView> mTextView;
    private WeakReference<ProgressBar> mProgressBar;

    SimpleAsyncTask(TextView tv, ProgressBar pb) {
        mTextView = new WeakReference<>(tv);
        mProgressBar = new WeakReference<>(pb);
    }

    @Override
    protected String doInBackground(Integer... params) {
        for(int count = 0; count <= params[0]; count++) {
            // Sleep for the random amount of time
            try {
                Thread.sleep(params[0]);
                publishProgress(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Return a String result
        return "Awake at last after sleeping for " + params[0] + " milliseconds!";
    }

    @Override
    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
        mProgressBar.get().setVisibility(View.GONE);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mTextView.get().setText("Task starting ...");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mTextView.get().setText("Task running ---> " + values[0].toString());
        mProgressBar.get().setProgress(values[0]);
    }
}
