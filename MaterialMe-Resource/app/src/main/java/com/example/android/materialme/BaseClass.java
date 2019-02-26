package com.example.android.materialme;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

public class BaseClass extends AppCompatActivity {

    // Constants for shared element transitions.
    private static final String CARD_TRANSITION = "switchCardTransition";
    private static final String DETAIL_TRANSITION = "switchDetailTransition";
    private ImageView cardImage;
    private ImageView cardImageDetail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cardImage = findViewById(R.id.sportsImage);
        cardImageDetail = findViewById(R.id.sportsImageDetail);
    }

    /*protected void switchAnimation(final Intent intent,
                                   final Context context){
        cardImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Set the transition details and start the second activity.
                ActivityOptions options = ActivityOptions
                        .makeSceneTransitionAnimation((Activity)context,
                                Pair.create((View)cardImage,
                                        CARD_TRANSITION),
                                Pair.create((View)cardImageDetail,
                                        DETAIL_TRANSITION));

                startActivity(intent,options.toBundle());
            }
        });
    }*/

    protected void switchAnimation(
                                   final Intent intent,
                                   final Context context) {
        ActivityOptions options = ActivityOptions
                .makeSceneTransitionAnimation((Activity) context,
                        Pair.create((View) cardImage,
                                CARD_TRANSITION),
                        Pair.create((View) cardImageDetail,
                                DETAIL_TRANSITION));

        startActivity(intent, options.toBundle());
    }
}
