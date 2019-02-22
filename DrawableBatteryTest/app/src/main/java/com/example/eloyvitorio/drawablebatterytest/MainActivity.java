package com.example.eloyvitorio.drawablebatterytest;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private int currentImageIndex = 1;
    static final String IMAGE_INDEX = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Restore image index if the device has changed the configuration/orientation
        if (savedInstanceState != null) {
            currentImageIndex = savedInstanceState.getInt(IMAGE_INDEX);
        }

        // Creates image view and set the first image of LevelListImage
        imageView = findViewById(R.id.imageViewBattery);
        imageView.setImageLevel(currentImageIndex);
    }

    public void changeNextTopImage(View view) {
        currentImageIndex ++;
        boolean exitChangeImageAction = restartListImage();
        if (exitChangeImageAction == true) {
            return;
        } else {
            imageView.setImageLevel(currentImageIndex);
        }
    }

    public void changePreviousTopImage(View view) {
        currentImageIndex --;
        boolean exitChangeImageAction = restartListImage();
        if (exitChangeImageAction == true) {
            return;
        } else {
            imageView.setImageLevel(currentImageIndex);
        }
    }

    /**
     * Sets up first image if the maximum limit has been reached
     * sets up last image if the mimimum limit has been reached
     * @return
     */
    public boolean restartListImage(){
        boolean lessThanOne;
        boolean greaterThanSeven;
        boolean exitChangeImageAction = false;
        lessThanOne = checkMinLimitOfIndex();
        greaterThanSeven = checkMaxLimitOfIndex();
        if(lessThanOne == true) {
            currentImageIndex = 7;
            imageView.setImageLevel(currentImageIndex);
            exitChangeImageAction = true;
        } else if (greaterThanSeven == true) {
            currentImageIndex = 1;
            imageView.setImageLevel(currentImageIndex);
            exitChangeImageAction = true;
        }
        return exitChangeImageAction;
    }

    /**
     * Check if the minimum limite of index has been reached
     * @return
     */
    public boolean checkMinLimitOfIndex() {
        boolean indicator = false;
        if (currentImageIndex < 1) {
            return true;
        }
        return indicator;
    }

    /**
     * Check if the maximum limite of index has been reached
     * @return
     */
    public boolean checkMaxLimitOfIndex() {
        boolean indicator = false;
        if (currentImageIndex > 7) {
            return true;
        }
        return indicator;
    }

    // Save image index state
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(IMAGE_INDEX, currentImageIndex);
    }
}
