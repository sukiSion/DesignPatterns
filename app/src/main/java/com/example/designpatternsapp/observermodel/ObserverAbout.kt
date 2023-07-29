package com.example.designpatternsapp.observermodel

import android.util.Log
import java.util.Observable
import java.util.Observer

class Coder(val name: String) : Observer {
    @Deprecated("Deprecated in Java")
    override fun update(o: Observable?, arg: Any?) {
        Log.e("Coder" , "Hi , $name DevTechFrontier更新啦 ， 内容 ： ${arg}")
    }
}

class DevTechFrontier : Observable(){

    fun postNewPublication(content: String){
        setChanged()
        notifyObservers(content)
    }
}


