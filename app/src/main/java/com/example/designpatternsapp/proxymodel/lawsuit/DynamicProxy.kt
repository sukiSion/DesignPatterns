package com.example.designpatternsapp.proxymodel.lawsuit

import android.util.Log
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

class DynamicProxy(
    private val any: Any
): InvocationHandler {

    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        val result = method?.invoke(any)
        return result
    }
}