package com.example.lynn.second;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.Button;

import static com.example.lynn.second.MainActivity.*;

public class MyListener implements View.OnClickListener {

    public ObjectAnimator animation(View view,
                                    String property,
                                    float... values) {
        ObjectAnimator animation = ObjectAnimator.ofFloat(view,property,values);

        return(animation);
    }

    @Override
    public void onClick(View view) {
        Button source = (Button)view;

        if (first == null)
            first = source;
        else {
            Button second = source;

            String temp = first.getText().toString();
            first.setText(second.getText());
            second.setText(temp);

            first = null;

            String candidate = "";

            for (Button button : buttons)
                candidate += button.getText().charAt(0);

            if()
        }

        int min = 50;

        int max = width/buttons.length;

        AnimatorSet set = new AnimatorSet();

        ObjectAnimator animation1 = animation(buttons[0],"rotation",min,max,min);

        set.play(animation1);

        for (int counter=1;counter<buttons.length;counter++) {
            ObjectAnimator animation = animation(buttons[counter],"rotation",min,max,min);

            set.play(animation).with(animation1);
        }

        set.setDuration(10000);

      //  set.start();



    }

}
