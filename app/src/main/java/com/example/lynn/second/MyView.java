package com.example.lynn.second;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.widget.LinearLayout;

import static com.example.lynn.second.MainActivity.*;

public class MyView extends LinearLayout {

    public MyView(Context context) {
        super(context);

        Point sizeOfScreen = Util.sizeOfScreen(context);

        width = sizeOfScreen.x;
        height = sizeOfScreen.y;

        JuliaSetView juliaSetView = new JuliaSetView(context);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width,3*height/4);

        layoutParams.topMargin = height/4;

        juliaSetView.setLayoutParams(layoutParams);

        addView(juliaSetView);
    }



}
