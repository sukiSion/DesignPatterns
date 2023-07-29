package com.example.designpatternsapp.decoratemodel.person

import android.util.Log

abstract class Person {
    abstract fun dressed()
}

class Boy : Person(){
    override fun dressed() {
        Log.e("boy" , "穿了内衣内裤")
    }
}

abstract class PersonCloth(
    protected val person: Person
) : Person(){
    override fun dressed() {
        person.dressed()
    }
}

class ExpensiveCloth(
    person: Person
) : PersonCloth(person){

    private fun dressShirt(){
        Log.e("boy" , "穿件短袖")
    }

    private fun dressLeather(){
        Log.e("boy" , "穿件皮衣")
    }

    private fun dressJean(){
        Log.e("boy" , "穿条牛仔裤")
    }

    override fun dressed() {
        super.dressed()
        dressShirt()
        dressLeather()
        dressJean()
    }
}

class CheapCloth(
    person: Person
): PersonCloth(person){

    private fun dressShorts(){
        Log.e("boy" , "穿条短裤")
    }

    override fun dressed() {
        super.dressed()
        dressShorts()
    }
}

