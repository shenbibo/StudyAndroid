package com.study.sky.study.base.recycrleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * 实现{@link RecyclerView}的item被点击的回调接口
 * <strong>该类的一个实例只能被绑定到一个{@link RecyclerView}中</strong>
 * Created by sky on 2016/9/1.
 */
public class ItemClickListener implements RecyclerView.OnItemTouchListener {

    interface OnItemClickListener {
        /**
         * @param position 被点击view在{@link RecyclerViewAdapter}中的位置，
         *                 该值取自于{@link RecyclerView#getChildLayoutPosition(View)}的返回值。
         */
        boolean onClick(RecyclerView parent, View view, int position);

        void onLongClick(RecyclerView parent, View view, int position);
    }


    private GestureDetector gestureDetector;

    private ClickGestureDetector clickGestureDetector;

    public ItemClickListener(Context context, OnItemClickListener listener) {
        clickGestureDetector = new ClickGestureDetector(listener);
        gestureDetector = new GestureDetector(context, clickGestureDetector);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        if (clickGestureDetector.rv != rv) {
            clickGestureDetector.rv = rv;
        }
        return gestureDetector.onTouchEvent(e);
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    private static class ClickGestureDetector extends android.view.GestureDetector.SimpleOnGestureListener {
        public RecyclerView rv;

        private OnItemClickListener listener;

        public ClickGestureDetector(OnItemClickListener listener) {
            this.listener = listener;
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            if (listener != null) {
                //根据坐标获取被点击的View
                float posX = e.getX();
                float posY = e.getY();
                View view = rv.findChildViewUnder(posX, posY);
                int position = rv.getChildLayoutPosition(view);
                return listener.onClick(rv, view, position);
            }
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            if (listener != null) {
                //根据坐标获取被点击的View
                float posX = e.getX();
                float posY = e.getY();
                View view = rv.findChildViewUnder(posX, posY);
                int position = rv.getChildLayoutPosition(view);
                listener.onLongClick(rv, view, position);
            }
        }
    }

    public static class SimpleOnItemClickListener implements OnItemClickListener{

        @Override
        public boolean onClick(RecyclerView parent, View view, int position) {
            return false;
        }

        @Override
        public void onLongClick(RecyclerView parent, View view, int position) {

        }
    }
}
