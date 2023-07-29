package com.example.designpatternsapp.proxymodel.lawsuit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityLawsuitBinding
import java.lang.reflect.Proxy

class LawsuitActivity : AppCompatActivity() {
    private lateinit var activityLawsuitBinding: ActivityLawsuitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityLawsuitBinding = ActivityLawsuitBinding.inflate(layoutInflater)
        setContentView(activityLawsuitBinding.root)
//        val lawyer = Lawyer(XiaoMin())
        val xiaoMin = XiaoMin()
        val proxy = DynamicProxy(xiaoMin)
        val loader = xiaoMin.javaClass.classLoader
        val lawyer= Proxy.newProxyInstance(
            loader,
            arrayOf(ILawsuit::class.java),
            proxy
        ) as ILawsuit
        activityLawsuitBinding.lawsuitButton.setOnClickListener {
            lawyer.litigate()
        }
    }
}