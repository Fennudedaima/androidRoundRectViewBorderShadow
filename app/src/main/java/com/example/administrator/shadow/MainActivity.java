package com.example.administrator.shadow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.custom.viewlibrary.CrazyShadow;
import com.custom.viewlibrary.base.CrazyShadowDirection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private View floatView0, floatView1;


    private CrazyShadow floatCrazyShadow0, floatCrazyShadow1;


    private boolean float0Flag = true, float1Flag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initShadow();
        initListener();
    }

    private void initListener() {


        floatView0.setOnClickListener(this);
        floatView1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.relay_float0:
                if (float0Flag) {
                    floatCrazyShadow0.hide();
                } else {
                    floatCrazyShadow0.show();
                }
                float0Flag = !float0Flag;
                break;
            case R.id.relay_float1:
                if (float1Flag) {
                    floatCrazyShadow1.hide();
                } else {
                    floatCrazyShadow1.show();
                }
                float1Flag = !float1Flag;
                break;

        }
    }

    private void initShadow() {




        floatCrazyShadow0 = new CrazyShadow.Builder()
                .setContext(this)
                .setDirection(CrazyShadowDirection.ALL)
                .setShadowRadius(dip2Px(10))
                .setBaseShadowColor(getResources().getColor(R.color.bg_red))
                .setImpl(CrazyShadow.IMPL_FLOAT)
                .setBorder(dip2Px(2))
                .action(floatView0);

        floatCrazyShadow1 = new CrazyShadow.Builder()
                .setContext(this)
                .setDirection(CrazyShadowDirection.ALL)
                .setShadowRadius(dip2Px(10))
                .setCorner(dip2Px(8))
                .setBorder(dip2Px(3))
                .setImpl(CrazyShadow.IMPL_FLOAT)
                .action(floatView1);


    }

    private void initView() {

        floatView0 = findViewById(R.id.relay_float0);
        floatView1 = findViewById(R.id.relay_float1);

    }


    public int dip2Px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
