package com.example.designpatternsapp.prototypemodel.session

import android.util.Log

interface Login {
    fun login()
    fun update()
}

class LoginImpl : Login{
    override fun login() {
        val user = User(
            age = 22,
            name = "Mr.Simple",
            phoneNum = "123456789",
            adderss = Address(
                "北京市",
                "海淀区",
                "花园东路"
            )
        )
        LoginSession.instance.setLoginedUser(user)
        Log.e("session" , "$user")
    }

    override fun update() {
        val user = LoginSession.instance.getLoginedUser()
        user?.adderss = Address(
            "北京市",
            "朝阳区",
            "大望路"
        )
        Log.e("session" , "$user")
    }

}