package com.example.shafi.gesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.shafi.gesture.adapter.custom;
import com.example.shafi.gesture.gestureMethod.MenuGestureHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private List<Model> mModelList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    TextView x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        x= findViewById(R.id.tvXValue);
        y= findViewById(R.id.tvYValue);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new custom(MainActivity.this, getListData());
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
        





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
}
