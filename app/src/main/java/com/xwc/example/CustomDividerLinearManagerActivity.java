package com.xwc.example;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import com.xwc.itemdecoration.DRecycleViewDivider;
import com.xwc.itemdecoration.Divider;
import com.xwc.itemdecoration.DividerBuilder;

/**
 * Created by xwc on 2018/2/9.
 */

public class CustomDividerLinearManagerActivity extends AppCompatActivity {

    RecyclerView recycleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_divider_linear_manager);
        recycleView = findViewById(R.id.recycle_view);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        customDivider();
        recycleView.setAdapter(new RecycleViewAdapter(this));
    }

    private void customDivider() {
        recycleView.addItemDecoration(new DRecycleViewDivider(this) {
            @Nullable
            @Override
            public Divider getDivider(int itemPosition) {
                Divider divider = null;
                switch (itemPosition) {
                    case 0:
                        divider = new DividerBuilder()
                                .setLeftSideLine(true, 0xFF000000, dip2px(8), dip2px(5), dip2px(5))
                                .setRightSideLine(true, 0xFF000000, dip2px(16), dip2px(5), dip2px(5))
                                .setBottomSideLine(true, 0xFF000000, dip2px(8), dip2px(5), dip2px(5))
                                .setTopSideLine(true, 0xFF000000, dip2px(16), 0, 0)
                                .create();
                        break;
                    case 1:
                        divider = new DividerBuilder()
                                .setLeftSideLine(true, 0xFF0000FF, dip2px(10), dip2px(8), dip2px(8))
                                .setRightSideLine(true, 0xFF0000FF, dip2px(10), dip2px(8), dip2px(8))
                                .setBottomSideLine(true, 0xFF0000FF, dip2px(15), 0, 0)
                                .setTopSideLine(true, 0xFF0000FF, dip2px(15), 0, 0)
                                .create();
                        break;
                    case 2:
                        divider = new DividerBuilder()
                                .setLeftSideLine(true, 0xFFFF0000, dip2px(15), 0, 0)
                                .setRightSideLine(true, 0xFFFF0000, dip2px(15), 0, 0)
                                .setBottomSideLine(true, 0xFFFF0000, dip2px(10), 0, dip2px(30))
                                .setTopSideLine(true, 0xFFFF0000, dip2px(10), dip2px(8), 0)
                                .create();
                        break;
                    case 3:
                        divider = new DividerBuilder()
                                .setBottomSideLine(true, Color.DKGRAY, dip2px(5), dip2px(10), dip2px(5))
                                .create();
                        break;
                    default:
                        divider = new DividerBuilder()
                                .setBottomSideLine(true, Color.parseColor("#D8D8D8"), 1, 0, 0)
                                .create();
                        break;
                }
                return divider;
            }
        });

    }

    public int dip2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, getResources().getDisplayMetrics());
    }
}
