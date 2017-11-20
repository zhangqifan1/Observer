package com.v.property;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private int i;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Adapter adapter = new Adapter(myObservers, MainActivity.this);
            lv.setAdapter(adapter);
        }
    };
    private List<MyObserver> myObservers;
    private MyPerson observable;
    private MyObserver myObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        myObservers = new ArrayList<>();
        observable = new MyPerson();
    }

    //添加观察者
    public void addObserver(View view) {
        myObserver = new MyObserver(i);
        i++;
        observable.addObserver(myObserver);
        myObservers.add(myObserver);
        handler.sendEmptyMessage(0);

    }


    //改变数据
    public void changeData(View view) {
        observable.setName("a" + i);
        observable.setAge(10 + i);
        observable.setSex("男" + i);
        handler.sendEmptyMessage(0);
    }

    private void initView() {
        lv = (ListView) findViewById(R.id.lv);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        observable.deleteObserver(myObserver);
    }
}
