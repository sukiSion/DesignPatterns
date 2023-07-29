package com.example.designpatternsapp.buildermodel.build

abstract class Builder{
    abstract fun buildBoard(broad:String)
    abstract fun buildDisplay(display: String)
    abstract fun buildOS()
    abstract fun create(): Computer
}

class MacBookBuilder(private val macBook: MacBook): Builder(){

    override fun buildBoard(broad: String) {
        macBook.mBoard = broad
    }

    override fun buildDisplay(display: String) {
        macBook.mDisplay = display
    }

    override fun buildOS() {
        macBook.setOS()
    }

    override fun create(): Computer {
        return macBook
    }
}

