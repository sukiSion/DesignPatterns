package com.example.designpatternsapp.prototypemodel.session

import java.lang.Exception

class User(
    private val age: Int,
    private val name: String,
    private val phoneNum: String,
    var adderss: Address
): Cloneable{

    public override fun clone(): User {
        try {
            val user = super.clone() as User
            return user
        }catch (e: Exception){

        }
        return this
    }

    override fun toString(): String {
        return "User(age=$age, name='$name', phoneNum='$phoneNum', adderss=$adderss)"
    }
}


class Address(
    private val city: String,
    private val district: String,
    private val street: String
){
    override fun toString(): String {
        return "Address(city='$city', district='$district', street='$street')"
    }
}