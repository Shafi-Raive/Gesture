package com.example.shafi.gesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.shafi.gesture.adapter.custom;

public class MainActivity extends AppCompatActivity  {

    String[] title, dsc;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        custom custom;
        recyclerView = findViewById(R.id.recyclerView);
        title = getResources().getStringArray(R.array.name);
        dsc = getResources().getStringArray(R.array.name1);

        custom = new custom(MainActivity.this, title, dsc);

        recyclerView.setAdapter(custom);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        final GestureDetector gestureDetector = new GestureDetector(
//                new GestureDetector.OnGestureListener() {
//                    @Override
//                    public boolean onDown(MotionEvent e) {
//                        Toast.makeText(getApplicationContext(), "onDown", Toast.LENGTH_SHORT).show();
//                        return true;
//                    }
//
//                    @Override
//                    public void onShowPress(MotionEvent e) {
//
//                    }
//
//                    @Override
//                    public boolean onSingleTapUp(MotionEvent e) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//                        return false;
//                    }
//
//                    @Override
//                    public void onLongPress(MotionEvent e) {
//
//                    }
//
//                    @Override
//                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//                        Toast.makeText(getApplicationContext(), "onFling", Toast.LENGTH_SHORT).show();
//                        return true;
//                    }
//                });
//
//        custom.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(final View view, final MotionEvent event) {
//                if (gestureDetector.onTouchEvent(event)) {
//                    return false;
//                }
//
//                return true;
//            }
//        });



        custom.setItemClickListener(new custom.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                //Toast.makeText(getApplicationContext(), "onItemClick :"+position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemLongClick(int position, View v) {

               // Toast.makeText(getApplicationContext(), "onItemLongClick :"+position, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
