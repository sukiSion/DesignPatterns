package com.example.designpatternsapp.buildermodel.build

abstract class Computer () {
    var mBoard: String? = null
        set(value) {
            field = value
        }

    var mDisplay: String? = null
        set(value) {
            field = value
        }
    var mOS: String? = null
    abstract fun setOS()

    override fun toString(): String {
        return "Computer(mBoard=$mBoard, mDisplay=$mDisplay, mOS=$mOS)"
    }
}

class MacBook: Computer(){

    override fun setOS() {
        mOS = "Mac OS X 10.10"
    }
}

