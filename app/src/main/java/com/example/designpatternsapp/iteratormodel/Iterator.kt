package com.example.designpatternsapp.iteratormodel

import com.example.designpatternsapp.iteratormodel.Iterator

interface Iterator<T> {
    fun hasNext(): Boolean
    fun next(): T
}

fun Iterator<Employee>.check(check: (employee: Employee) -> Unit){
    while (hasNext()){
        check(next())
    }
}

