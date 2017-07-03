package com.custom.viewlibrary.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by hitomi on 2016/10/17.
 */
public class BorderView extends View {


    private RectF mBorderRect;
    private float mBorderSize=5;//default=5;
    private float cornerSize=5;//default=5;
    private View contentView;
    Paint mBorderPaint;
    public BorderView(Context context,View contentView,float border,float corner) {
        super(context);
        this.contentView=contentView;
        this.mBorderSize=border;
        this.cornerSize=corner;
        mBorderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBorderPaint.setStrokeWidth(mBorderSize);
        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setColor(Color.WHITE);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(contentView.getWidth()+ 2*(int)mBorderSize,contentView.getHeight()+ 2*(int)mBorderSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mBorderRect=new RectF();
        mBorderRect.top = mBorderSize / 2;
        mBorderRect.left = mBorderSize / 2;
        mBorderRect.right = contentView.getWidth()+mBorderSize*3/2;
        mBorderRect.bottom = contentView.getHeight()+mBorderSize*3/2;
        canvas.drawRoundRect(mBorderRect, cornerSize,cornerSize, mBorderPaint);
    }


}
