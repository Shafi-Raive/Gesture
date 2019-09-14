package com.example.shafi.gesture.gestureMethod;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MenuGestureHandler implements View.OnTouchListener {

    GestureDetector gestureDetector = new GestureDetector(new GestureListener());

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        final int actionPeformed = event.getAction();


        float xAxis = 0f;
        float yAxis = 0f;

        float lastXAxis = 0f;
        float lastYAxis = 0f;

        switch(actionPeformed){
            case MotionEvent.ACTION_DOWN:{
                final float x = event.getX();
                final float y = event.getY();

                lastXAxis = x;
                lastYAxis = y;

                Log.d("tag", "X :"+Float.toString(lastXAxis));
                Log.d("tag", "Y :"+Float.toString(lastYAxis));

                break;
            }

            case MotionEvent.ACTION_MOVE:{
                final float x = event.getX();
                final float y = event.getY();

                final float dx = x - lastXAxis;
                final float dy = y - lastYAxis;

                xAxis += dx;
                yAxis += dy;

                Log.d("tag", "MOV X :"+Float.toString(xAxis));
                Log.d("tag", "MOV Y :"+Float.toString(yAxis));
                break;
            }
        }
        return true;
    }


}
