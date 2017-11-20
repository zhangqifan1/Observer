package com.v.property;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Administrator on 2017/11/19.
 * MyObserver是观察者
 * 观察者接受到通知后，调用update方法进行更新操作
 */

public class MyObserver implements Observer {
    private int id;
    private MyPerson myPerson;


    //构造方法  只有Id
    public MyObserver(int id) {
        System.out.println("我是观察者:"+id);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MyPerson getMyPerson() {
        return myPerson;
    }

    public void setMyPerson(MyPerson myPerson) {
        this.myPerson = myPerson;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察者--->"+id+"得到更新");
        this.myPerson= (MyPerson) o;

        System.out.println(((MyPerson)o).toString());
    }



}
