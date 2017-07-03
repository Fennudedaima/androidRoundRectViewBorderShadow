package com.custom.viewlibrary;

import android.content.Context;
import android.view.View;

import com.custom.viewlibrary.base.CrazyShadowAttr;
import com.custom.viewlibrary.base.CrazyShadowDirection;
import com.custom.viewlibrary.base.ShadowHandler;
import com.custom.viewlibrary.floating.ShadowFloating;

/**
 * Created by hitomi on 2016/10/19.
 *
 * email : 196425254@qq.com
 *
 * https://github.com/Hitomis
 */
public class CrazyShadow {



    /**
     * 以浮动修饰的形式为你的 View 添加阴影 [{@link ShadowFloating}]
     */
    public static final String IMPL_FLOAT = "floating";

    private Context context;

    private ShadowHandler shadowHandler;

    private boolean makeShadow;

    private CrazyShadow(Context context) {
        this.context = context;
    }

    private void createShadowHandler(CrazyShadowAttr attr) {
            shadowHandler = new ShadowFloating(context, attr);
    }

    /**
     * 为 View 添加阴影效果
     * @param view
     */
    public void make(View view) {
        if (!makeShadow) {
            shadowHandler.makeShadow(view);
            makeShadow = true;
        }
    }

    /**
     * 将添加的阴影效果移除
     */
    public void remove() {
        if (makeShadow) {
            shadowHandler.removeShadow();
            makeShadow = false;
        }
    }

    /**
     * 显示阴影效果
     */
    public void show() {
        shadowHandler.showShadow();
    }

    /**
     * 隐藏阴影效果
     */
    public void hide() {
        shadowHandler.hideShadow();
    }

    public static class Builder {

        private Context context;

        /**
         * {@link #IMPL_FLOAT} <br/>
         */
        private String impl;

        /**
         * 阴影的基本色
         */
        private int baseShadowColor;

        /**
         * 背景色
         */
        private int background;

        /**
         * 表示阴影的一个颜色由深到浅且长度为3的数组
         */
        private int[] colors;

        /**
         * 表示为阴影顶点的内侧弧度。以适配被设置的 View 是圆角的情况
         */
        private float corner;

        /**
         * 阴影半径
         */
        private float shadowRadius;

        private float border;

        /**
         * 阴影设置在 View 的方向
         */
        @CrazyShadowDirection
        private int direction;

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        /**
         *  以何种方式添加阴影:<br/>
         * {@link #IMPL_FLOAT} <br/>
         * @param impl
         * @return Builder
         */
        public Builder setImpl(String impl) {
            this.impl = impl;
            return this;
        }

        /**
         * 阴影的基本颜色，即最深的颜色, {@link CrazyShadowAttr#setBaseShadowColor(int)}
         * 方法会自动计算出绘制阴影时需要的 {@link #colors}
         * @param baseColor
         * @return Builder
         */
        public Builder setBaseShadowColor(int baseColor) {
            this.baseShadowColor = baseColor;
            return this;
        }

        /**
         * 背景色
         * @param background
         * @return Builder
         */
        public Builder setBackground(int background) {
            this.background = background;
            return this;
        }

        /**
         * 绘制阴影时需要的一个颜色由深到浅且长度为3的数组
         * @param colors
         * @return Builder
         */
        public Builder setColors(int[] colors) {
            this.colors = colors;
            return this;
        }

        /**
         * 表示为阴影顶点的内侧弧度。以适配被设置的 View 是圆角的情况
         * @param corner [unit : pixels]
         * @return Builder
         */
        public Builder setCorner(float corner) {
            this.corner = corner;
            return this;
        }

        public Builder setBorder(float border) {
            this.border = border;
            return this;
        }

        /**
         * 设置阴影半径
         * @param shadowRadius [unit : pixels]
         * @return Builder
         */
        public Builder setShadowRadius(float shadowRadius) {
            this.shadowRadius = shadowRadius;
            return this;
        }

        /**
         * 设置阴影的方向，具体查看 {@link CrazyShadowAttr}
         * @param direction
         * @return Builder
         */
        public Builder setDirection(int direction) {
            this.direction = direction;
            return this;
        }

        private CrazyShadow create() {
            if (colors == null && baseShadowColor == 0)
                // 默认的颜色。由深到浅
                //分别为开始颜色，中间颜色，结束颜色
                colors = new int[]{0x63000000, 0x32000000, 0x00000000};
            CrazyShadowAttr attr = new CrazyShadowAttr();
            attr.setImpl(impl);
            attr.setBaseShadowColor(baseShadowColor);
            attr.setBackground(background);
            attr.setColors(colors);
            attr.setCorner(corner);
            attr.setShadowRadius(shadowRadius);
            attr.setDirection(direction);
            attr.setBorder(border);
            CrazyShadow crazyShadow = new CrazyShadow(context);
            crazyShadow.createShadowHandler(attr);
            return crazyShadow;
        }

        /**
         * 绘制阴影的启动方法，你需要保证参数已经正确设置完毕
         * @param view 被添加阴影的 View
         */
        public CrazyShadow action(View view) {
            CrazyShadow crazyShadow = create();
            crazyShadow.make(view);
            return crazyShadow;
        }
    }
}
