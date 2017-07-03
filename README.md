# androidRoundRectViewBorderShadow
`This is an Android custom view that implements rounded border and shadow effects`

How to use:

  Mainactiviy:
  floatView0 = findViewById(R.id.relay_float0);
  floatCrazyShadow0 = new CrazyShadow.Builder()
                .setContext(this)
                .setDirection(CrazyShadowDirection.ALL)
                .setShadowRadius(dip2Px(10))
                .setBaseShadowColor(getResources().getColor(R.color.bg_red))
                .setImpl(CrazyShadow.IMPL_FLOAT)
                .setBorder(dip2Px(2))
                .action(floatView0);
                
                
                
     xml:
      <RelativeLayout
        android:id="@+id/relay_float0"
        android:layout_width="300dp"
        android:layout_height="70dp"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="20dp"
        android:background="@color/bg_blue">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="浮动式阴影，不修改原 View ，在周围直接添加阴影。整体 View 看起来变大。但原 View 不能动"
            android:textSize="10sp" />

    </RelativeLayout>
    
    
    Thanks:
         CrazyShdow
                
                
                
                
                
