package com.xwc.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xwc.itemdecoration.DRecycleView;

public class GridManagerActivity extends AppCompatActivity {

    DRecycleView recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_manager);

        recycleView = findViewById(R.id.recycle_view);
        recycleView.setAdapter(new RecycleViewAdapter(this));
    }
}
