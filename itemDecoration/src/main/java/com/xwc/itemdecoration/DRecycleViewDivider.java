package com.xwc.itemdecoration;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
/**
 * Created by xwc on 2018/2/7.
 */
public abstract class DRecycleViewDivider extends RecyclerView.ItemDecoration {

    private Paint mPaint;

    private Context context;

    public DRecycleViewDivider(Context context) {
        this.context = context;
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        //left, top, right, bottom
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            int itemPosition = ((RecyclerView.LayoutParams) child.getLayoutParams()).getViewLayoutPosition();

            Divider divider = getDivider(itemPosition);

            if (divider.getLeftSideLine().isHave()) {
                int lineWidthPx = divider.getLeftSideLine().getWidth();
                int startPaddingPx = divider.getLeftSideLine().getStartPadding();
                int endPaddingPx = divider.getLeftSideLine().getEndPadding();


                drawChildLeftVertical(child, c, parent, divider.getLeftSideLine().getColor(), lineWidthPx, startPaddingPx, endPaddingPx);
            }
            if (divider.getTopSideLine().isHave()) {
                int startPaddingPx = divider.getTopSideLine().getStartPadding();
                int endPaddingPx = divider.getTopSideLine().getEndPadding();

                int lineWidthPx = divider.getTopSideLine().getWidth();
                int leftWidthPx = divider.getLeftSideLine().getWidth();
                int rightWidthPx = divider.getRightSideLine().getWidth();
                drawChildTopHorizontal(child, c, lineWidthPx, leftWidthPx, rightWidthPx, divider.topSideLine.getColor(), startPaddingPx, endPaddingPx);
            }
            if (divider.getRightSideLine().isHave()) {
                int lineWidthPx = divider.getRightSideLine().getWidth();
                int startPaddingPx = divider.getRightSideLine().getStartPadding();
                int endPaddingPx = divider.getRightSideLine().getEndPadding();
                drawChildRightVertical(child, c, parent, divider.getRightSideLine().getColor(), lineWidthPx, startPaddingPx, endPaddingPx);
            }
            if (divider.getBottomSideLine().isHave()) {

                int startPaddingPx = divider.getBottomSideLine().getStartPadding();
                int endPaddingPx = divider.getBottomSideLine().getEndPadding();


                int lineWidthPx = divider.getBottomSideLine().getWidth();
                int leftWidthPx = divider.getLeftSideLine().getWidth();
                int rightWidthPx = divider.getRightSideLine().getWidth();
                drawChildBottomHorizontal(child, c, lineWidthPx, leftWidthPx, rightWidthPx, divider.getBottomSideLine().getColor(), startPaddingPx, endPaddingPx);
            }
        }
    }


    private void drawChildBottomHorizontal(View child, Canvas c, int lineWidthPx, int leftWidth, int rightWidth, @ColorInt int color, int startPaddingPx, int endPaddingPx) {

        int leftPadding = 0;
        int rightPadding = 0;

        if (startPaddingPx <= 0) {
            leftPadding = 0;
        } else {
            leftPadding = startPaddingPx;
        }

        if (endPaddingPx <= 0) {
            rightPadding = 0;
        } else {
            rightPadding = endPaddingPx;
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                .getLayoutParams();
        int left = child.getLeft() - params.leftMargin - leftWidth + leftPadding;
        int right = child.getRight() + params.rightMargin + rightWidth - rightPadding;
        int top = child.getBottom() + params.bottomMargin;
        int bottom = top + lineWidthPx;
        mPaint.setColor(color);

        c.drawRect(left, top, right, bottom, mPaint);

    }

    private void drawChildTopHorizontal(View child, Canvas c, int lineWidthPx, int leftWidth, int rightWidth, @ColorInt int color, int startPaddingPx, int endPaddingPx) {
        int leftPadding = 0;
        int rightPadding = 0;

        if (startPaddingPx <= 0) {
            leftPadding = 0;
        } else {
            leftPadding = startPaddingPx;
        }
        if (endPaddingPx <= 0) {
            rightPadding = 0;
        } else {
            rightPadding = endPaddingPx;
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                .getLayoutParams();
        int left = child.getLeft() - params.leftMargin - leftWidth + leftPadding;
        int right = child.getRight() + params.rightMargin + rightWidth - rightPadding;
        int bottom = child.getTop() - params.topMargin;
        int top = bottom - lineWidthPx;
        mPaint.setColor(color);

        c.drawRect(left, top, right, bottom, mPaint);

    }

    private void drawChildLeftVertical(View child, Canvas c, RecyclerView parent, @ColorInt int color, int lineWidthPx, int startPaddingPx, int endPaddingPx) {
        int topPadding = 0;
        int bottomPadding = 0;

        if (startPaddingPx <= 0) {
            topPadding = 0;
        } else {
            topPadding = startPaddingPx;
        }
        if (endPaddingPx <= 0) {
            bottomPadding = 0;
        } else {
            bottomPadding = -endPaddingPx;
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                .getLayoutParams();
        int top = child.getTop() - params.topMargin + topPadding;
        int bottom = child.getBottom() + params.bottomMargin + bottomPadding;
        int right = child.getLeft() - params.leftMargin;
        int left = right - lineWidthPx;
        mPaint.setColor(color);

        c.drawRect(left, top, right, bottom, mPaint);

    }

    private void drawChildRightVertical(View child, Canvas c, RecyclerView parent, @ColorInt int color, int lineWidthPx, int startPaddingPx, int endPaddingPx) {

        int topPadding = 0;
        int bottomPadding = 0;

        if (startPaddingPx <= 0) {
            topPadding = 0;
        } else {
            topPadding = startPaddingPx;
        }
        if (endPaddingPx <= 0) {
            bottomPadding = 0;
        } else {
            bottomPadding = -endPaddingPx;
        }

        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                .getLayoutParams();
        int top = child.getTop() - params.topMargin + topPadding;
        int bottom = child.getBottom() + params.bottomMargin + bottomPadding;
        int left = child.getRight() + params.rightMargin;
        int right = left + lineWidthPx;
        mPaint.setColor(color);

        c.drawRect(left, top, right, bottom, mPaint);

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        int itemPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewLayoutPosition();

        Divider divider = getDivider(itemPosition);

        if (divider == null) {
            divider = new DividerBuilder().create();
        }

        int left = divider.getLeftSideLine().isHave() ? divider.getLeftSideLine().getWidth() : 0;
        int top = divider.getTopSideLine().isHave() ? divider.getTopSideLine().getWidth() : 0;
        int right = divider.getRightSideLine().isHave() ? divider.getRightSideLine().getWidth() : 0;
        int bottom = divider.getBottomSideLine().isHave() ? divider.getBottomSideLine().getWidth() : 0;

        outRect.set(left, top, right, bottom);
    }


    public abstract @Nullable
    Divider getDivider(int itemPosition);


}
