package com.v.property;

import java.util.Observable;

/**
 * Created by Administrator on 2017/11/19.
 *
 * MyPerson是被观察者
 * setChanged();告知数据改变，通过notifyObservers();发送信号通知观察者。
 */

public class MyPerson extends Observable{
    private String name;
    private int age;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

        //该方法设置对象可以改变  改变了 方法返回true
        setChanged();
        //如果这个对象已经发生了变化,作为一个指示去通知所有的观察者,然后当这个对象不改变了调用clearChanged方法  最后就是让setChanged()这个方法返回false
        notifyObservers();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        setChanged();
        notifyObservers();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "MyPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
