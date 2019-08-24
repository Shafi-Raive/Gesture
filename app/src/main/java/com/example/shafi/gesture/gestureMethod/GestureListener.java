package com.example.shafi.gesture.gestureMethod;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

class GestureListener extends GestureDetector.SimpleOnGestureListener {
    protected MotionEvent mLastOnDownEvent = null;

    @Override
    public boolean onDown(final MotionEvent e) {
        return true;
    }

    @Override
    public boolean onFling(final MotionEvent e1, final MotionEvent e2,
                           final float velocityX, final float velocityY) {
        Log.d("OnFling", "Called");
        final int SWIPE_MIN_DISTANCE = 20;
        final int SWIPE_MAX_OFF_PATH = 250;
        final int SWIPE_THRESHOLD_VELOCITY = 200;
        try {
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH) {
                return false;
            }
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                Log.i("A", "Right to Left");
            } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                Log.i("B", "Left to Right");
            }
        } catch (final Exception e) {
            // nothing
        }
        return super.onFling(e1, e2, velocityX, velocityY);
    }
}
