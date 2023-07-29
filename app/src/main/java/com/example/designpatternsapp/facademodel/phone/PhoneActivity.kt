package com.example.designpatternsapp.facademodel.phone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityPhoneBinding

class PhoneActivity : AppCompatActivity() {
    private lateinit var activityPhoneBinding: ActivityPhoneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPhoneBinding = ActivityPhoneBinding.inflate(layoutInflater)
        setContentView(activityPhoneBinding.root)
        val mobliePhone = MobliePhone()
        activityPhoneBinding.apply {
            takePictureButton.setOnClickListener {
                mobliePhone.takePicture()
            }
            callButton.setOnClickListener {
                mobliePhone.videoChat()
            }
        }
    }
}