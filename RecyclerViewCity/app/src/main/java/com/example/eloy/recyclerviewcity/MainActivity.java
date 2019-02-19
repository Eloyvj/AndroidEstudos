package com.example.eloy.recyclerviewcity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView cities;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<City> cities = initCities();

        this.cities = (RecyclerView) findViewById(R.id.cities);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        this.cities.setLayoutManager(mLayoutManager);

        adapter = new CityAdapter(cities);
        this.cities.setAdapter(adapter);
    }

    private ArrayList<City> initCities() {
        ArrayList<City> list = new ArrayList<>();

        list.add(new City("Cinque Terre", "The coastline, the five villages in Italy.", "http:/bit.ly/CBImageCinque"));
        list.add(new City("Paris", "Paris is the capital city of France.", "http:/bit.ly/CBImageParis"));
        list.add(new City("Rio de Janeiro", "Rio was been one of Brazil's most popular destinations.", "http:/bit.ly/CBImageRio"));
        list.add(new City("Sydney", "Sydney is the state capital of New South Wales.", "http:/bit.ly/CBImageRio"));

        return list;
    }


}
