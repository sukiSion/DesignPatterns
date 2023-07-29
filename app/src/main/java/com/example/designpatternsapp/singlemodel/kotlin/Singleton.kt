package com.example.designpatternsapp.singlemodel.kotlin

// 饿汉式
object Singleton

// 懒汉式
class Singleton1 private constructor(){
    companion object{
        private var instance: Singleton1? = null
            get() {
                if(field == null){
                    field = Singleton1()
                }
                return field
            }
        fun get() = instance!!
    }
}

// 线程安全的懒汉式
class Singleton2 private constructor(){
    companion object {
        private var instance: Singleton2? = null
            get() {
                if(field == null){
                    field = Singleton2()
                }
                return field
            }
        @Synchronized
        fun get() = instance!!
    }
}

// 双重校验锁式（Double Check)
class Singleton3 private constructor(){
    companion object{
        val instance: Singleton3 by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            Singleton3()
        }
    }
}

// 静态内部类
class Singleton4 private constructor(){
    companion object{
        fun getInstance():Singleton4 = SingleHolder.instance
    }

    private object SingleHolder {
        val instance = Singleton4()
    }
}