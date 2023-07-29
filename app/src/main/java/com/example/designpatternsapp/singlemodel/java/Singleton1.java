package com.example.designpatternsapp.singlemodel.java;

import java.io.ObjectStreamException;
import java.io.Serializable;

// 懒汉式
public class Singleton1 implements Serializable {

    private Singleton1(){}
    private static Singleton1 instance = null;

    public static synchronized Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }
}
