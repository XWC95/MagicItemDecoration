package com.xwc.example;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xwc.itemdecoration.DRecycleView;
import com.xwc.itemdecoration.Divider;
import com.xwc.itemdecoration.DRecycleViewDivider;
import com.xwc.itemdecoration.DividerBuilder;

/**
 * Created by xwc on 2018/2/9.
 */

public class CustomDividerGridManagerActivity extends AppCompatActivity {

    RecyclerView recycleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_divider_grid_manager);
        recycleView = findViewById(R.id.recycle_view);
        GridLayoutManager manager = new GridLayoutManager(this, 12);
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(new RecycleViewAdapter(this));
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

            @Override
            public int getSpanSize(int position) {
                if (position == 0 || position == 1) {
                    return 6;
                } else if (position == 6 || position == 10) {
                    return 12;
                } else if (position >= 7 && position <= 9) {
                    return 4;
                } else if (position >= 2 && position <= 5) {
                    return 3;
                }
                return 3;
            }
        });
        customDivider();
    }

    private void customDivider() {
        recycleView.addItemDecoration(new DRecycleViewDivider(this) {
            @Nullable
            @Override
            public Divider getDivider(int itemPosition) {
                Divider divider = null;
                if ((itemPosition >= 1 && itemPosition <= 6) || itemPosition == 9 || itemPosition == 10) {
                    divider = new DividerBuilder()
                            .setBottomSideLine(true, Color.BLACK, 6, 0, 0)
                            .create();
                } else if (itemPosition == 0 || itemPosition == 7 || itemPosition == 8) {
                    divider = new DividerBuilder()
                            .setRightSideLine(true, Color.BLACK, 6, 0, 0)
                            .setBottomSideLine(true, Color.BLACK, 6, 0, 0)
                            .create();
                } else if (itemPosition > 10 && itemPosition < 22) {

                    switch ((itemPosition - 10) % 4) {
                        case 1:
                        case 2:
                        case 3:
                            divider = new DividerBuilder()
                                    .setRightSideLine(true, Color.BLACK, 6, 0, 0)
                                    .setBottomSideLine(true, Color.BLACK, 6, 0, 0)
                                    .create();
                            break;
                        case 0:
                            divider = new DividerBuilder()
                                    .setBottomSideLine(true, Color.BLACK, 6, 0, 0)
                                    .create();
                            break;
                        default:
                            break;
                    }
                }
                return divider;
            }
        });

    }
}
