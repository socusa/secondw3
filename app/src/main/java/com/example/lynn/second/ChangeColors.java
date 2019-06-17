package com.example.lynn.second;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

import static com.example.lynn.second.MainActivity.*;

public class ChangeColors implements Runnable {
    private Thread thread;
    private boolean keepGoing;

    public int color() {
        int red = (int)(256*Math.random());
        int green = (int)(256*Math.random());
        int blue = (int)(256*Math.random());

        return(Color.argb(255,red,green,blue));
    }

    public ChangeColors() {
        thread = new Thread(this);

        keepGoing = true;

        thread.start();
    }

    public void pause(double seconds) {
        try {
            Thread.sleep((int)(seconds*1000));
        } catch (Exception e) {

        }
    }

    public void stop() {
        keepGoing = true;
    }

    @Override
    public void run() {
        while (keepGoing) {
            final int[] colors = {color(),color()};

            final GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP,colors);

            if (myView != null)
                myView.post(new Runnable() {

                    @Override
                    public void run() {
                        myView.setBackground(drawable);
                    }
                });


            pause(10);
        }

    }

}

