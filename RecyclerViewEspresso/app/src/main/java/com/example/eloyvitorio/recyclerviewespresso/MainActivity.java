package com.example.eloyvitorio.recyclerviewespresso;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = mWordList.size();
                // Add a new word to the wordList
                mWordList.addLast("+ Word " + wordListSize);
                // Notify the adapter, that the data has changed
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                // Scroll to the bottom
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });

        // Put initial data info the word list
        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + i);
        }

        // Get a handle to the RecyclerView
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed
        mAdapter = new WordListAdapter(this, mWordList);
        // Connect the adapter with the RecyclerView
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_resetList:
                // Clear the list
                // Notify the adapter about this update
                // Restore list initial state
                mWordList.clear();
                mAdapter.notifyDataSetChanged();
                for (int i = 0; i < 20; i++) {
                    mWordList.addLast("Word " + i);
                }
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }
}