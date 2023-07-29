package com.example.designpatternsapp.statemodel.loginsystem

import android.content.Context

class LoginContext private constructor(){

    companion object{
        val instance by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            LoginContext()
        }
    }

    private var mUserState:UserState = LogoutState()

    fun login(){
        mUserState = LoginedState()
    }

    fun logout(){
        mUserState = LogoutState()
    }

    fun forward(context: Context){
        mUserState.forward(context)
    }

    fun comment(context: Context){
        mUserState.comment(context)
    }


}