package com.example.admin.multilayout.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.admin.multilayout.R;

/**
 * com.example.admin.multilayout.utils
 *
 * @author Swg
 * @date 2017/12/7 15:34
 */
public class MyDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;
    private Paint paint;
    private Context context;

    public MyDecoration(Context context) {
        super();
        this.context = context;
        paint = new Paint();
        paint.setColor(ContextCompat.getColor(context, R.color.colorPrimary));
        //抗锯齿
        paint.setAntiAlias(true);

    }

    /**
     * 用来指定RecyclerView的子识图的内外边距
     *
     * @param outRect 矩形
     * @param view    子视图
     * @param parent  父容器
     * @param state   标识
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(0, 0, 0, 10);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        Rect rect = new Rect();
        rect.left = parent.getPaddingLeft();
        rect.right = parent.getWidth() - parent.getPaddingBottom();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            rect.bottom = parent.getChildAt(i).getTop();
            rect.top = rect.bottom - 10;
            c.drawRect(rect, paint);
        }

    }
}
