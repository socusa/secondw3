package com.example.lynn.second;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

import static com.example.lynn.second.MainActivity.*;

public class MyListener implements View.OnClickListener {

    public ObjectAnimator animation(View view,
                                    String property,
                                    int... values) {
        ObjectAnimator animation = ObjectAnimator.ofInt(view,property,values);

        return(animation);
    }

    @Override
    public void onClick(View view) {

        ObjectAnimator animation1 = animation(button,"scaleX",1,2,1);

        AnimatorSet set = new AnimatorSet();

        set.play(animation1);

        set.setDuration(10000);

        set.start();


    }

}
