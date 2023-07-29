package com.example.designpatternsapp.singlemodel.java;

// 静态内部类式
// 推荐使用
public class Singleton3 {
    private Singleton3(){}

    private static class SingleHolder{
        private static final Singleton3 intance = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return SingleHolder.intance;
    }
}
