package com.example.android.materialmeadaptativelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView sportsTitle = findViewById(R.id.titleDetail);
        ImageView sportsImage = findViewById(R.id.sportsImageDetail);
        TextView sportNews = findViewById(R.id.subTitleDetail);

        sportsTitle.setText(getIntent().getStringExtra("title"));
        Glide.with(this).load(getIntent()
                .getIntExtra("image_resource", 0)).into(sportsImage);
        sportNews.setText(getIntent().getStringExtra("sportNews"));
    }
}
