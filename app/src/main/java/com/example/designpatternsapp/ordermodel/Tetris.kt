package com.example.designpatternsapp.ordermodel

import android.util.Log
import android.widget.Toast
import com.example.designpatternsapp.MyApplication

class TetrisMachine{
    fun toLeft(){
        Toast.makeText(
            MyApplication.appContext,
            "向左",
            Toast.LENGTH_SHORT
        ).show()
    }

    fun toRight(){
        Toast.makeText(
            MyApplication.appContext,
            "向右",
            Toast.LENGTH_SHORT
        ).show()
    }

    fun fastToBottom(){
        Toast.makeText(
            MyApplication.appContext,
            "快速落下",
            Toast.LENGTH_SHORT
        ).show()
    }

    fun transform(){
        Toast.makeText(
            MyApplication.appContext,
            "改变形状",
            Toast.LENGTH_SHORT
        ).show()
    }
}

interface Command{
    fun excute()
}

class LeftCommand(private val machine: TetrisMachine): Command{
    override fun excute() {
        machine.toLeft()
    }
}

class RightCommand(private val machine: TetrisMachine): Command{
    override fun excute() {
        machine.toRight()
    }
}

class FallCommand(private val machine: TetrisMachine): Command{
    override fun excute() {
        machine.fastToBottom()
    }
}

class TransformCommand(private val machine: TetrisMachine): Command{
    override fun excute() {
        machine.transform()
    }
}

class Invoke(
    private val leftCommand: LeftCommand,
    private val rightCommand: RightCommand,
    private val fallCommand: FallCommand,
    private val transformCommand: TransformCommand
){
    fun toLeft(){
        leftCommand.excute()
    }

    fun toRight(){
        rightCommand.excute()
    }

    fun fall(){
        fallCommand.excute()
    }

    fun transform(){
        transformCommand.excute()
    }
}



