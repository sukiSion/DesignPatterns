package com.example.designpatternsapp.statemodel.loginsystem

import android.content.Context
import android.content.Intent
import android.util.Log

interface UserState {
    fun forward(context: Context)
    fun comment(context: Context)
}

class LoginedState: UserState{
    override fun forward(context: Context) {
        Log.e("login" , "转发")
    }

    override fun comment(context: Context) {
        Log.e("login" , "评论")
    }
}

class LogoutState: UserState{
    override fun forward(context: Context) {
        goToLogin(context)
    }

    override fun comment(context: Context) {
        goToLogin(context)
    }


    private fun goToLogin(context: Context){
        context.startActivity(Intent(
            context,
            LoginSystemActivity::class.java
        ))
    }
}