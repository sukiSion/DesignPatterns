package com.example.designpatternsapp.iteratormodel

class MinIterator(
    private val list: List<Employee>
): Iterator<Employee> {

    private var position = 0

    override fun hasNext(): Boolean {
        if(list.isNotEmpty()
            && position <= list.lastIndex){
            return true
        }
        return false
    }

    override fun next(): Employee {
        val employee = list[position]
        position++
        return employee
    }
}