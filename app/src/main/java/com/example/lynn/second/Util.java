package com.example.lynn.second;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

public class Util {

    public static Point sizeOfScreen(Context context) {
        WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);

        Display display = windowManager.getDefaultDisplay();

        Point output = new Point();

        display.getSize(output);

        return(output);
    }

}
