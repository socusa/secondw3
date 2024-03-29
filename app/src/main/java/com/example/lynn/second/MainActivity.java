package com.example.lynn.second;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static MyView myView;
    public static MyListener listener = new MyListener();
    public static MyDatabaseHelper helper;
    public static SQLiteDatabase database;
    public static int width;
    public static int height;
    public static ChangeColors changeColors;
    public static Button[] buttons;
    public static String word;
    public static Button first;

    public static String scramble(String input) {
        char[] characters = input.toCharArray();

        for(int counter=0;counter<100;counter++) {
            int position1 = (int)(characters.length*Math.random());

            int position2 = (int)(characters.length*Math.random());

            char temp = characters[position1];
            characters[position1] = characters[position2];
            characters[position2] = temp;
        }

        return(new String(characters));
    }

    public static String getWord() {
        java.util.List<String> words = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM words;",new String[]{});

        cursor.moveToFirst();

        do {
            int wordIndex = cursor.getColumnIndex("word");

            String word = cursor.getString(wordIndex);

            words.add(word);
        } while (cursor.moveToNext());

        return(words.get((int)(words.size()*Math.random())));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        helper = new MyDatabaseHelper(this);

        database = helper.getReadableDatabase();

        changeColors = new ChangeColors();

        word = getWord().toUpperCase();

        System.out.println("word is " + word);

        setContentView(myView = new MyView(this));
    }

    protected void onDestroy() {
        super.onDestroy();

        if (changeColors != null)
            changeColors.stop();
    }


}
