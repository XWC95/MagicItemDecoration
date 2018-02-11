package com.xwc.itemdecoration;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by xwc on 2018/2/7.
 */
public class DRecycleView extends RecyclerView {

    private int color = Color.parseColor("#D8D8D8");
    private int width = 1;
    private int startPadding;
    private int endPadding;

    public int decorationMethod;

    public DRecycleView(Context context) {
        this(context, null);
    }

    public DRecycleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DRecycleView);

        final int spanCount = typedArray.getInt(R.styleable.DRecycleView_x_gridlayout_spanCount, 0);
        color = typedArray.getColor(R.styleable.DRecycleView_x_decoration_color, color);
        width = typedArray.getDimensionPixelSize(R.styleable.DRecycleView_x_decoration_width, width);
        startPadding = typedArray.getDimensionPixelSize(R.styleable.DRecycleView_x_decoration_start_padding, startPadding);
        endPadding = typedArray.getDimensionPixelSize(R.styleable.DRecycleView_x_decoration_end_padding, endPadding);

        setLayoutManager(spanCount == 0 ? new LinearLayoutManager(context) : new GridLayoutManager(context, spanCount));
        addItemDecoration(new DRecycleViewDivider(context) {
            @Nullable
            @Override
            public Divider getDivider(int itemPosition) {
                if (spanCount > 1) {
                    if (itemPosition % spanCount < spanCount && itemPosition % spanCount != spanCount - 1) {
                        return new DividerBuilder()
                                .setRightSideLine(true, color, width, startPadding, endPadding)
                                .setBottomSideLine(true, color, width, startPadding, endPadding)
                                .create();
                    } else {
                        return new DividerBuilder()
                                .setBottomSideLine(true, color, width, startPadding, endPadding)
                                .create();
                    }
                } else {
                    int itemCount = getAdapter().getItemCount();
                    if (itemPosition + 1 == itemCount) {
                        return new DividerBuilder()
                                .create();
                    } else {
                        return new DividerBuilder()
                                .setBottomSideLine(true, color, width, startPadding, endPadding)
                                .create();
                    }

                }
            }
        });
        typedArray.recycle();
    }
}
