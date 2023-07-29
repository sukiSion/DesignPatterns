package com.example.designpatternsapp.prototypemodel.session

class LoginSession private constructor(){

    companion object{
        val instance : LoginSession by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            LoginSession()
        }
    }

    private var loginUser: User? = null

    fun setLoginedUser(user: User){
        loginUser = user
    }

    fun getLoginedUser() = loginUser?.clone()

}