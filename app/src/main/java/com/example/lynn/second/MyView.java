package com.example.lynn.second;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.widget.Button;
import android.widget.LinearLayout;

import static com.example.lynn.second.MainActivity.*;

public class MyView extends LinearLayout {

    public MyView(Context context) {
        super(context);

        Point sizeOfScreen = Util.sizeOfScreen(context);

        width = sizeOfScreen.x;
        height = sizeOfScreen.y;

        buttons = new Button[8];

        for (int counter=0;counter<buttons.length;counter++) {
            buttons[counter] = new Button(context);

            buttons[counter].setTextSize(20);

            buttons[counter].setOnClickListener(listener);

            addView(buttons[counter]);
        }

    }



}
