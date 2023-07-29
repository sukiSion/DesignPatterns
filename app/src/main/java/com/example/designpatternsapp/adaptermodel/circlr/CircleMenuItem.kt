package com.example.designpatternsapp.adaptermodel.circlr

import androidx.annotation.DrawableRes

data class CircleMenuItem(
    @DrawableRes val imageId: Int,
    val title: String
)