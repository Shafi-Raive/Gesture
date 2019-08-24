package com.example.shafi.gesture.gestureMethod;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MenuGestureHandler implements View.OnTouchListener {

    GestureDetector gestureDetector = new GestureDetector(new GestureListener());

    @Override
    public boolean onTouch(final View v, final MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onSingleTapConfirmed(final MotionEvent e) {
            onClick(); // my method
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onFling(final MotionEvent e1, final MotionEvent e2,
                               final float velocityX, final float velocityY) {
            boolean result = false;
            try {
                final float diffY = e2.getY() - e1.getY();
                final float diffX = e2.getX() - e1.getX();

                Log.d("tag", "MX :"+Math.abs(diffX));
                Log.d("tag", "X :"+diffX);
                Log.d("tag", "MY :"+Math.abs(diffY));
                Log.d("tag", "Y :"+diffY);
                Log.d("tag", "VX :"+Math.abs(velocityX));
                Log.d("tag", "VY :"+Math.abs(velocityY));

                if (Math.abs(diffX) > Math.abs(diffY)) {

                    if (Math.abs(diffX) > SWIPE_THRESHOLD
                            && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            result = onSwipeRight();
                        } else {
                            result = onSwipeLeft();
                        }
                    }
                } else {
                    if (Math.abs(diffY) < SWIPE_THRESHOLD
                            && Math.abs(velocityY) < SWIPE_VELOCITY_THRESHOLD) {

                        Log.d("tag", "diffY :"+diffY);
                        if (diffY > 0) {
                            result = onSwipeBottom();
                        } else {
                            result = onSwipeTop();
                        }
                    }
                }
            } catch (final Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    public boolean onSwipeRight() {
        return true;
    }


    public boolean onSwipeLeft() {
        Log.d("tag", "onSwipeLeft");
        return true;
    }

    public void onClick() {
    }

    public boolean onSwipeTop() {
        return true;
    }

    public boolean onSwipeBottom() {
        return true;
    }


}
