package com.example.designpatternsapp.memorandummodel.note

import android.util.Log

class NoteCaretaker {
    companion object{
        const val MAX = 30
    }
    private val memotos:ArrayList<Memoto>
    private var mIndex:Int

    init {
        memotos = ArrayList<Memoto>(30)
        mIndex= 0
    }

    fun saveMetomo(memoto: Memoto){
        if(memotos.size > MAX){
            memotos.removeAt(0)
        }
        memotos.add(memoto)
        mIndex = memotos.lastIndex
        Log.e("NoteCaretaker" ,"memotos : ${memotos} , mIndex : ${mIndex}")
    }

    fun getPrevMemoto(): Memoto?{

        if(memotos.isNotEmpty()){
            mIndex = if(mIndex > 0) --mIndex else 0
            Log.e("NoteCaretaker" ,"memotos : ${memotos} , mIndex : ${mIndex}")
            return memotos[mIndex]
        }
        return null
    }

    fun getNextMemoto(): Memoto?{
        if(memotos.isNotEmpty()){
            mIndex = if(mIndex < memotos.lastIndex) ++mIndex else memotos.lastIndex
            Log.e("NoteCaretaker" ,"memotos : ${memotos} , mIndex : ${mIndex}")
            return memotos[mIndex]
        }
        return null
    }


}