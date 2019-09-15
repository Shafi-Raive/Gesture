package com.example.shafi.gesture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.shafi.gesture.adapter.custom;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener  {

    private List<Model> mModelList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    MotionEvent event;

    TextView valuX,valueY,moveX,moveY;
    float xAxis = 0f;
    float yAxis = 0f;

    float lastXAxis = 0f;
    float lastYAxis = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valuX=findViewById(R.id.textX);
        valueY=findViewById(R.id.textY);
        moveX=findViewById(R.id.txtMoveX);
        moveY=findViewById(R.id.txtMovY);

        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new custom(MainActivity.this, getListData());
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setOnTouchListener(this);

       // GestureDetector gestureDetector = new GestureDetector(new GestureListener());

//        custom.OnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(final View view, final MotionEvent event) {
//                if (gestureDetector.onTouchEvent(event)) {
//                    return false;
//                }
//
//                return true;
//            }
//        });



//        custom.setItemClickListener(new custom.ClickListener() {
//            @Override
//            public void onItemClick(int position, View v) {
//
//                Toast.makeText(getApplicationContext(), "onItemClick :"+position, Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onItemLongClick(int position, View v) {
//
//               Toast.makeText(getApplicationContext(), "onItemLongClick :"+position, Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }

    private List<Model> getListData() {
        mModelList = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            mModelList.add(new Model("TextView " + i));
        }
        return mModelList;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final  int actionPeformed = event.getAction();
        switch(actionPeformed){
            case MotionEvent.ACTION_DOWN:{
                final float x = event.getX();
                final float y = event.getY();

                lastXAxis = x;
                lastYAxis = y;

                valuX.setText("X: "+Float.toString(lastXAxis));
                valueY.setText("Y: "+Float.toString(lastYAxis));

//                Log.d("tag", "X :"+Float.toString(lastXAxis));
//                Log.d("tag", "Y :"+Float.toString(lastYAxis));

                break;
            }

            case MotionEvent.ACTION_MOVE:{
                final float x = event.getX();
                final float y = event.getY();

                final float dx = x - lastXAxis;
                final float dy = y - lastYAxis;

                xAxis += dx;
                yAxis += dy;

                moveX.setText("Move_X: "+Float.toString(xAxis));
                moveY.setText("Move_Y: "+Float.toString(yAxis));

//                Log.d("tag", "MOV X :"+Float.toString(xAxis));
//                Log.d("tag", "MOV Y :"+Float.toString(yAxis));
                break;
            }
        }
        return true;
    }
}
