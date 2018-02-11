package com.xwc.itemdecoration;

import android.support.annotation.ColorInt;
/**
 * Created by xwc on 2018/2/7.
 */
public class SideLine {

    public boolean isHave = false;

    public int color;

    public int width;

    public int startPadding;
    public int endPadding;

    public SideLine(boolean isHave, @ColorInt int color, int width, int startPadding, int endPadding) {
        this.isHave = isHave;
        this.color = color;
        this.width = width;
        this.startPadding = startPadding;
        this.endPadding = endPadding;
    }

    public int getStartPadding() {
        return startPadding;
    }

    public void setStartPadding(int startPadding) {
        this.startPadding = startPadding;
    }

    public int getEndPadding() {
        return endPadding;
    }

    public void setEndPadding(int endPadding) {
        this.endPadding = endPadding;
    }

    public boolean isHave() {
        return isHave;
    }

    public void setHave(boolean have) {
        isHave = have;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
