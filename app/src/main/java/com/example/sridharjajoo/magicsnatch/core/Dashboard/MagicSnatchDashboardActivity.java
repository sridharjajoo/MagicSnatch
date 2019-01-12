package com.example.sridharjajoo.magicsnatch.core.Dashboard;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sridharjajoo.magicsnatch.R;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MagicSnatchDashboardActivity extends AppCompatActivity implements HasSupportFragmentInjector{

    @BindView(R.id.furniture_rv)
    RecyclerView furnitureRv;

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    private MagicSnatchFurnitureAdapter magicSnatchFurnitureAdapter;
    private ArrayList<Drawable> furnitureItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_snatch_dashboard);
        ButterKnife.bind(this);
        setUpRv();
    }

    private void setUpRv() {
        furnitureItem = new ArrayList<>();
        loadImages();
        magicSnatchFurnitureAdapter = new MagicSnatchFurnitureAdapter(furnitureItem);
        furnitureRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        furnitureRv.setAdapter(magicSnatchFurnitureAdapter);
    }

    private void loadImages() {
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_0));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_1));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_2));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_3));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_4));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_5));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_6));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_7));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_8));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_9));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_10));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_11));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_12));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_13));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_14));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_15));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_16));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_17));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_18));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_19));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_20));
        furnitureItem.add(ContextCompat.getDrawable(this, R.drawable.furniture_21));
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
