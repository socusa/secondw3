package com.example.lynn.second;

import android.graphics.Bitmap;
import android.graphics.Color;

import static com.example.lynn.second.MainActivity.*;

public class JuliaSet implements Runnable {
    private Thread thread;
    private boolean keepGoing;
    private double cReal;
    private double cImaginary;

    public JuliaSet() {
        cReal = 0;

        cImaginary = -0.5;

        thread = new Thread(this);

        keepGoing = true;

        thread.start();
    }

    private void pause(double seconds) {
        try {
            Thread.sleep((int)(seconds*1000));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void stop() {
        keepGoing = false;
    }

    public int color() {
        int red = (int)(256*Math.random());
        int green = (int)(256*Math.random());
        int blue = (int)(256*Math.random());

        return(Color.argb(255,red,green,blue));
    }

    public int[] colors() {
        int[] colors = new int[17];

        colors[0] = 0xFFFFFFFF;
        colors[1] = 0xFF6E00FF;
        colors[2] = 0xFF7800F0;
        colors[3] = 0xFF8200E6;
        colors[4] = 0xFF8C00D6;
        colors[5] = 0xFF9600D2;

        for (int counter=6;counter<colors.length;counter++)
            colors[counter] = color();

        return(colors);
    }

    public int[] getMap(double creal,
                        double cimaginary,
                        int width,
                        int[] colors) {
        int[] output = new int[width*width];

        for (int counter=0;counter<width;counter++) {
            for (int counter1=1;counter1<width;counter1++) {
                output[counter1*width + counter] = colors[0];
            }
        }

        int numberOfIterations = 20;

        double infinity = 4;

        for (int m=0;m<width;m++) {
            double x0 = -2 + (m*1.0)/(width/(4*1.0));

            for (int n=0;n<width;n++) {
                double y0 = 2 - (n*1.0)/(width/(4*1.0));

                double q = x0;
                double f = y0;
                int white = 0;

                for (int i=0;i<numberOfIterations;i++) {
                    double x1 = q*q - f*f + creal;
                    double y1 = 2*q*f + cimaginary;

                    q = x1;
                    f = y1;

                    double z = q*q + f*f;

                    if (z > infinity) {
                        if (i <= 15)
                            output[n*width + m] = colors[i];
                        else
                            output[n*width + m] = colors[16];

                        white = 1;

                        break;
                    }
                }
            }
        }

        /*

        for (int m=0;m<400;m++) {
            double x0 = -2 + (m * 1.0) / (400 / (4 * 1.0));

            for (int n = 0; n < 400; n++) {
                double y0 = 2 - (n * 1.0) / (400 / (4 * 1.0));

                double q = x0;
                double f = y0;
                int white = 0;

                for (int i = 0; i < numberOfIterations; i++) {
                    double x1 = q * q - f * f + creal;
                    double y1 = 2 * q * f + cimaginary;

                    q = x1;
                    f = y1;

                    double z = q * q + f * f;

                    if (z > infinity) {
                        if (i <= 15)
                            output[n * 400 + m] = colors[i];
                        else
                            output[n * 400 + m] = colors[16];

                        white = 1;

                        break;
                    }
                }
            }
        }

        */


            return (output);

    }

    @Override
    public void run() {
        int counter = 0;

        while (keepGoing) {
            pause(5);

            int width = Math.min(MainActivity.width,height);

            int[] pixels = getMap(cReal + counter*0.001,cImaginary - counter*0.001,width,colors());

            counter++;

 //           int[] pixels = getMap(0,-0.5,400,400,colors());

            bitmap = Bitmap.createBitmap(pixels,width,width,Bitmap.Config.RGB_565);

//            bitmap = Bitmap.createBitmap(pixels,400,400,Bitmap.Config.RGB_565);

            myView.post(new Runnable() {

                @Override
                public void run() {
                    myView.invalidate();
                }
            });


        }
    }

}
