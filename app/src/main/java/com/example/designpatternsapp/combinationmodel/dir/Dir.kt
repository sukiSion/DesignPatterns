package com.example.designpatternsapp.combinationmodel.dir

import android.util.Log
import java.lang.StringBuilder

abstract class Dir(
    private val name: String
) {
    protected val dirs : MutableList<Dir> = mutableListOf()

    abstract fun addDir(dir: Dir)
    abstract fun rmDir(dir: Dir)
    abstract fun clearFiles()
    fun getName() = name
    abstract fun getFiles(): List<Dir>
    abstract fun prinfFiles():String
}

class Folder(private val name: String): Dir(name){
    override fun addDir(dir: Dir) {
        dirs.add(dir)
    }

    override fun rmDir(dir: Dir) {
        dirs.remove(dir)
    }

    override fun clearFiles() {
        dirs.clear()
    }

    override fun getFiles() = dirs

    override fun prinfFiles(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("${getName()} ( ")
        dirs.forEachIndexed { index, dir ->
            stringBuilder.append(dir.prinfFiles())
            if(index != dirs.lastIndex){
                stringBuilder.append(" , ")
            }
        }
        stringBuilder.append(" ) ")
        return "${stringBuilder}"
    }
}

class File(private val name: String): Dir(name){
    override fun addDir(dir: Dir) {
        throw UnsupportedOperationException("文件对象不支持该操作")
    }

    override fun rmDir(dir: Dir) {
        throw UnsupportedOperationException("文件对象不支持该操作")
    }

    override fun clearFiles() {
        throw UnsupportedOperationException("文件对象不支持该操作")
    }

    override fun getFiles(): List<Dir> {
        throw UnsupportedOperationException("文件对象不支持该操作")
    }

    override fun prinfFiles():String = getName()
}