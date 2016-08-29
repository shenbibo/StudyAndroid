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
//        int addedHeight = 0;
//        int drawWidth;
//        int childCount = parent.getChildCount();
//        int parentWidth = parent.getWidth();
//        int startWidthPos;
//        for (int i = 0; i < childCount; i++) {
//            View child = parent.getChildAt(i);
//            //使用该行注释掉的代码会导致分割线固定，不会动态变化，不会随着滑动而上下移动，导致此原因是因为这样会把分割线的坐标写死
//            //            addedHeight += child.getHeight();
//            addedHeight = child.getBottom();
//            drawWidth = width > 0 ? width : child.getWidth();
//            startWidthPos = (parentWidth - drawWidth) / 2;
//            c.drawRect(startWidthPos, addedHeight, startWidthPos + drawWidth, addedHeight + height, paint);
//            //            addedHeight += height;
//        }
        drawVertical(c, parent);
    }

    public void drawVertical(Canvas c, RecyclerView parent) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + height;
            c.drawRect(left, top, right, bottom, paint);
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
