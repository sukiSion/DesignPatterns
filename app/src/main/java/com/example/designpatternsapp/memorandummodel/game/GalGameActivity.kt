package com.example.designpatternsapp.memorandummodel.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.databinding.ActivityGalGameBinding

class GalGameActivity : AppCompatActivity() {
    private lateinit var activityGalGameBinding: ActivityGalGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityGalGameBinding = ActivityGalGameBinding.inflate(layoutInflater)
        setContentView(activityGalGameBinding.root)
        val galGame = GalGame()
        val caretaker = Caretaker()
        activityGalGameBinding.apply {
            quitButton.setOnClickListener {
                galGame.quit()
            }
            roleButton.setOnClickListener {
                galGame.rnterHeroine1()
            }
            trueRoleButton.setOnClickListener {
                galGame.rnterTureHeroine()
            }
            saveButton.setOnClickListener {
                caretaker.archive(galGame.createArchive())
            }
            readButton.setOnClickListener {
                caretaker.getArchive()?.apply {
                    galGame.readArchive(this)
                }
            }
        }
    }
}