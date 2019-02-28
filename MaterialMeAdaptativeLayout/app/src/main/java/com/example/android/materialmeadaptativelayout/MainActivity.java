/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.materialmeadaptativelayout;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

/***
 * Main Activity for the Material Me app, a mock sports news application
 * with poor design choices.
 */
public class MainActivity extends AppCompatActivity {

    // Member variables.
    private RecyclerView mRecyclerView;
    private ArrayList<Sport> mSportsData;
    private SportsAdapter mAdapter;

    // Members variables for save the layout manager and arrayList of Sports
    // state
    private final String SAVED_LAYOUT_MANAGER = "recycler_state";
    private Parcelable layoutManagerSavedState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Member variable for get the integer from the integers.xml resource file
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        // Initialize the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerView);

        // Set the Layout Manager.
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        // Initialize the ArrayList that will contain the data.
        mSportsData = new ArrayList<>();

        // Initialize the adapter and set it to the RecyclerView.
        mAdapter = new SportsAdapter(this, mSportsData);
        mRecyclerView.setAdapter(mAdapter);

        // Restore the Recycler View state
        if (savedInstanceState != null) {
            ArrayList<Sport> data = savedInstanceState.getParcelableArrayList("SAVED_LIST");
            mSportsData.clear();
            mSportsData.addAll(data);
            mAdapter.notifyDataSetChanged();
            restoreLayoutManagerPosition();
            //setItems(mSportsData);
        }
        else {
            // Get the data.
            initializeData();
        }

        // Disable swipe action if there is more than one column in the grid
        int swipeDirs;
        if(gridColumnCount > 1) {
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }

        // Implements swipe and drag/drop actions in the cards
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper
                .SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                ItemTouchHelper.DOWN | ItemTouchHelper.UP, swipeDirs) {
            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                // Get the original and target index from secont and third parameters
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                // Swap the items in the dataset by calling Collections.swap passing the dataSet,
                // initial and final indexes
                Collections.swap(mSportsData, from, to);

                // Notify the adapter that the item was moved, passing the old and new indexes
                // change de return to true
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                // Remove item by get position of viewHolder
                mSportsData.remove(viewHolder.getAdapterPosition());
                // Notify remove item for adapter to able the RecyclerView to animate the deletion
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        // Add my RecyclerView to helper object
        helper.attachToRecyclerView(mRecyclerView);
    }

    /**
     * Initialize the sports data from resources.
     */
    private void initializeData() {
        // Get the resources from the XML file.
        String[] sportsList = getResources()
                .getStringArray(R.array.sports_titles);
        String[] sportsInfo = getResources()
                .getStringArray(R.array.sports_info);
        TypedArray sportsImageResources =
                getResources().obtainTypedArray(R.array.sports_images);
        String[] sportsNews = getResources()
                .getStringArray(R.array.sports_news);

        // Clear the existing data (to avoid duplication).
        mSportsData.clear();

        // Create the ArrayList of Sports objects with titles and
        // information about each sport.
        for (int i = 0; i < sportsList.length; i++) {
            mSportsData.add(new Sport(sportsList[i], sportsInfo[i],
                    sportsImageResources.getResourceId(i, 0),
                    sportsNews[i]));
        }

        // Clean up the sportsImageArray once time that has been create the mSportsData
        sportsImageResources.recycle();

        // Notify the adapter of the change.
        mAdapter.notifyDataSetChanged();
    }

    /**
     * Calls again the initializeData to restore the initial state of mSportsDataArray
     *
     * @param view
     */
    public void resetSports(View view) {
        // Call initializeData method for reset the cardViews list
        initializeData();
    }

    /**
     * Save the current state of RecyclerView
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SAVED_LAYOUT_MANAGER, mRecyclerView.getLayoutManager().onSaveInstanceState());
        outState.putParcelableArrayList("SAVED_LIST", mSportsData);
    }

    @Override
    protected void onRestoreInstanceState(Bundle state) {
        layoutManagerSavedState = state.getParcelable(SAVED_LAYOUT_MANAGER);
        super.onRestoreInstanceState(state);

    }

    private void restoreLayoutManagerPosition() {
        if (layoutManagerSavedState != null) {
            mRecyclerView.getLayoutManager().onRestoreInstanceState(layoutManagerSavedState);
        }
    }
}
