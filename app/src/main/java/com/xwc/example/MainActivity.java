package com.xwc.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xwc.itemdecoration.DRecycleView;

public class MainActivity extends AppCompatActivity {

    DRecycleView recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleView = findViewById(R.id.recycle_view);
        recycleView.setAdapter(new RecycleViewAdapter(this));

    }




}
