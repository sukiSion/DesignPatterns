package com.example.designpatternsapp.memorandummodel.game

class Caretaker(
    private var archive: Archive? = null
) {
    fun archive(archive: Archive){
        this.archive = archive
    }

    fun getArchive() = archive
}