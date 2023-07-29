package com.example.designpatternsapp.facademodel.phone

class MobliePhone (){
    private val phone: Phone by lazy {
        PhoneImpl()
    }
    private val camera: Camera by lazy {
        CameraImpl()
    }

    fun dail(){
        phone.dail()
    }

    fun videoChat(){
        camera.open()
        phone.dail()
    }

    fun hangUp(){
        phone.hangUp()
    }

    fun takePicture(){
        camera.open()
        camera.takePicture()
    }

    fun closeCamera(){
        camera.close()
    }
}