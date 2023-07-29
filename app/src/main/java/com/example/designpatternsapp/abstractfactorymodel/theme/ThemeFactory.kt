package com.example.designpatternsapp.abstractfactorymodel.theme

import android.content.Context

interface ThemeFactory {
    fun createThemeButton(context: Context): ThemeButton
    fun createThemeToolBar(context: Context): ThemeToolBar
}

class LightThemeFactory:  ThemeFactory{
    override fun createThemeButton(context: Context): ThemeButton = LightButton(context)
    override fun createThemeToolBar(context: Context): ThemeToolBar = LightToolBar(context)
}

class DarkThemeFactory:  ThemeFactory{
    override fun createThemeButton(context: Context): ThemeButton = DarkButton(context)
    override fun createThemeToolBar(context: Context): ThemeToolBar = DarkToolBar(context)
}