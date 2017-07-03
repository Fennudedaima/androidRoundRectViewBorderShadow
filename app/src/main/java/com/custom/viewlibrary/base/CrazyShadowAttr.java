package com.custom.viewlibrary.base;

import android.support.v4.graphics.ColorUtils;

/**
 * Created by hitomi on 2016/10/19.
 */
public class CrazyShadowAttr {

    /**
     * 以何种方式添加阴影:<br/>
     * {@link com.custom.viewlibrary.CrazyShadow#IMPL_DRAW} <br/>
     * {@link com.custom.viewlibrary.CrazyShadow#IMPL_WRAP} <br/>
     * {@link com.custom.viewlibrary.CrazyShadow#IMPL_FLOAT} <br/>
     */
    private String impl;

    /**
     * 阴影的基本颜色，即最深的颜色, {@link #setBaseShadowColor(int)} 方法会自动计算出
     * 绘制阴影时需要的 {@link #colors}
     */
    private int baseShadowColor;

    /**
     * 仅仅对 {@link com.custom.viewlibrary.CrazyShadow#IMPL_DRAW} 形式的方设置阴影时需要的属性
     */
    private int background;

    /**
     * 绘制阴影时需要的一个颜色由深到浅且长度为3的数组
     */
    private int[] colors;

    /**
     * 对 {@link com.custom.viewlibrary.CrazyShadow#IMPL_DRAW} 形式表示为背景的圆角角度.<br/>
     * 对 {@link com.custom.viewlibrary.CrazyShadow#IMPL_WRAP} 与
     * {@link com.custom.viewlibrary.CrazyShadow#IMPL_FLOAT}
     * 表示为阴影顶点的内侧弧度。以适配被设置的 View 是圆角的情况
     */
    private float corner;

    /**
     * 阴影半径
     */
    private float shadowRadius;


    private float border;

    /**
     * 设置阴影的方向，具体查看 {@link CrazyShadowAttr}
     */
    @com.custom.viewlibrary.base.CrazyShadowDirection
    private int direction;

    public String getImpl() {
        return impl;
    }

    public void setImpl(String impl) {
        this.impl = impl;
    }

    public void setBaseShadowColor(int baseShadowColor) {
        this.baseShadowColor = baseShadowColor;
        if (colors == null) {
            colors = new int[3];
            colors[0] = ColorUtils.setAlphaComponent(baseShadowColor, 255);
            colors[1] = ColorUtils.setAlphaComponent(baseShadowColor, 128);
            colors[2] = ColorUtils.setAlphaComponent(baseShadowColor, 0);
        }
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public int[] getColors() {
        return colors;
    }

    public void setColors(int[] colors) {
        if (colors != null)
            this.colors = colors;
    }

    public float getCorner() {
        return corner;
    }

    public void setCorner(float corner) {
        this.corner = corner;
    }

    public float getBorder() {
        return border;
    }

    public void setBorder(float border) {
        this.border = border;
    }

    public float getShadowRadius() {
        return shadowRadius;
    }

    public void setShadowRadius(float shadowRadius) {
        this.shadowRadius = shadowRadius;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(@com.custom.viewlibrary.base.CrazyShadowDirection int direction) {
        this.direction = direction;
    }

    public boolean containLeft() {
        return direction == com.custom.viewlibrary.base.CrazyShadowDirection.ALL ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.LEFT ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.LEFT_TOP ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.BOTTOM_LEFT ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.BOTTOM_LEFT_TOP ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.RIGHT_BOTTOM_LEFT ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.LEFT_TOP_RIGHT;
    }

    public boolean containTop() {
        return direction == com.custom.viewlibrary.base.CrazyShadowDirection.ALL ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.TOP ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.LEFT_TOP ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.TOP_RIGHT ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.LEFT_TOP_RIGHT ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.BOTTOM_LEFT_TOP ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.TOP_RIGHT_BOTTOM;
    }

    public boolean containRight() {
        return direction == com.custom.viewlibrary.base.CrazyShadowDirection.ALL ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.RIGHT ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.TOP_RIGHT ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.RIGHT_BOTTOM ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.TOP_RIGHT_BOTTOM ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.LEFT_TOP_RIGHT ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.RIGHT_BOTTOM_LEFT;
    }

    public boolean containBottom() {
        return direction == com.custom.viewlibrary.base.CrazyShadowDirection.ALL ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.BOTTOM ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.BOTTOM_LEFT ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.RIGHT_BOTTOM ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.RIGHT_BOTTOM_LEFT ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.TOP_RIGHT_BOTTOM ||
                direction == com.custom.viewlibrary.base.CrazyShadowDirection.BOTTOM_LEFT_TOP;
    }
}
