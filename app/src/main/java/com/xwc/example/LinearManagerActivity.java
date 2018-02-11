package com.xwc.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xwc.itemdecoration.DRecycleView;

public class LinearManagerActivity extends AppCompatActivity {


    DRecycleView recycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_maneger);

        recycleView = findViewById(R.id.recycle_view);
        recycleView.setAdapter(new RecycleViewAdapter(this));
    }
}
