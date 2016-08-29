package com.study.sky.study.common.itemdecoration;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * [一句话描述类的作用]
 * [详述类的功能。]
 * Created by sky on 2016/8/29.
 */
public class BaseItemDecoration extends RecyclerView.ItemDecoration {

    private int width;

    private int height;

    private int color;

    private Paint paint;

    private Drawable mDivider;

    /**
     * @param width 如果小于0，则取其子view的高度
     */
    public BaseItemDecoration(int width, int height, int color) {
        this.width = width;
        this.height = height;
        this.color = color;
        paint = new Paint();
        paint.setColor(color);

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int addedHeight = 0;
        int drawWidth;
        int childCount = parent.getChildCount();
        int parentWidth = parent.getWidth();
        int startWidthPos;
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            addedHeight += child.getHeight();
            drawWidth = width > 0 ? width : child.getWidth();
            startWidthPos = (parentWidth - drawWidth) / 2;
//            mDivider.setBounds(startWidthPos, addedHeight, startWidthPos + drawWidth, addedHeight + height);
            c.drawRect(startWidthPos, addedHeight, startWidthPos + drawWidth, addedHeight + height, paint);
//            mDivider.
            addedHeight += height;
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0, 0, 0, height);
    }
}
