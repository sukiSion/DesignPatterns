package com.example.designpatternsapp.memorandummodel.note

data class Memoto(
    private val text: String,
    private val cursor: Int
) {

    fun getText() = text
    fun getCursor() = cursor

}