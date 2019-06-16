package com.example.lynn.second;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import static com.example.lynn.second.MainActivity.bitmap;

public class JuliaSetView extends View {

    public JuliaSetView(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas) {
        if (bitmap != null)
            canvas.drawBitmap(bitmap,0,0,null);
    }

}
