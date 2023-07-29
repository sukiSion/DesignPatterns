package com.example.designpatternsapp.singlemodel.java;

// 饿汉式
public class Singleton {
    private Singleton(){}
    private static final Singleton mSingleton = new Singleton();
}
