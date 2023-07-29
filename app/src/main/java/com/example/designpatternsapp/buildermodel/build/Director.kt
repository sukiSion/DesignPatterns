package com.example.designpatternsapp.buildermodel.build

class Director(
    private val builder: Builder
) {
    fun construct(board: String , display: String){
        builder.buildBoard(board)
        builder.buildDisplay(display)
        builder.buildOS()
    }


}