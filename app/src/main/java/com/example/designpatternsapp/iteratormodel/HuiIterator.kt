package com.example.designpatternsapp.iteratormodel

class HuiIterator(
    private val array: Array<Employee>
) : Iterator<Employee> {

    private var position = 0

    override fun hasNext(): Boolean {
        if(array.size > 0 && position <= array.size - 1){
            return true
        }
        return false
    }

    override fun next(): Employee {
        val employee = array.get(position)
        position++
        return employee
    }
}