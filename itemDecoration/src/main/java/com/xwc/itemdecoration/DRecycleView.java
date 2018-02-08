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
 * Created by xwc on 2018/2/8.
 */
public class DRecycleView extends RecyclerView {

    private int color ;
    private int width = 1;
    private int startPadding;
    private int endPadding;

    public int decorationType;

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
        decorationType = typedArray.getInt(R.styleable.DRecycleView_x_decoration_type, decorationType);
        if (decorationType == 0) {

            int spanCount = typedArray.getInt(R.styleable.DRecycleView_x_grid_layout, 0);
            color = typedArray.getColor(R.styleable.DRecycleView_x_decoration_color, color);
            width = typedArray.getDimensionPixelSize(R.styleable.DRecycleView_x_decoration_width, width);
            startPadding = typedArray.getDimensionPixelSize(R.styleable.DRecycleView_x_decoration_start_padding, startPadding);
            endPadding = typedArray.getDimensionPixelSize(R.styleable.DRecycleView_x_decoration_end_padding, endPadding);

            setLayoutManager(spanCount == 0 ? new LinearLayoutManager(context) : new GridLayoutManager(context, spanCount));
            addItemDecoration(new RecycleViewDivider(context) {
                @Nullable
                @Override
                public Divider getDivider(int itemPosition) {
                    return new DividerBuilder()
                            .setBottomSideLine(true, 0xffFF4081, 6, 0, 0)
                            .create();
                }
            });
        }

        typedArray.recycle();
    }
}
