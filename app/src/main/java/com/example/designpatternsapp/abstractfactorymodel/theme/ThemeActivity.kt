package com.example.designpatternsapp.abstractfactorymodel.theme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityThemeBinding

class ThemeActivity : AppCompatActivity() {
    private lateinit var activityThemeBinding: ActivityThemeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityThemeBinding = ActivityThemeBinding.inflate(layoutInflater)
        setContentView(activityThemeBinding.root)
        val lightThemeFactory = LightThemeFactory()
        val darkThemeFactory = DarkThemeFactory()

        activityThemeBinding.apply {
            darkThemeButton.setOnClickListener {
                contentLayout.removeAllViews()
                contentLayout.addView(darkThemeFactory.createThemeToolBar(this@ThemeActivity).apply {
                    title = "暗色主题的标题"
                })
                contentLayout.addView(darkThemeFactory.createThemeButton(this@ThemeActivity).apply {
                    text = "暗色主题"
                })
            }
            lightThemeButton.setOnClickListener {
                contentLayout.removeAllViews()
                contentLayout.addView(lightThemeFactory.createThemeToolBar(this@ThemeActivity).apply {
                    title = "亮色主题的标题"
                })
                contentLayout.addView(lightThemeFactory.createThemeButton(this@ThemeActivity).apply {
                    text = "亮色主题"
                })
            }
        }
    }
}