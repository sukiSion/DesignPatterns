package com.example.designpatternsapp.memorandummodel.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityNoteBinding

class NoteActivity : AppCompatActivity() {
    private lateinit var activityNoteBinding: ActivityNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityNoteBinding =  ActivityNoteBinding.inflate(layoutInflater)
        setContentView(activityNoteBinding.root)

        val noteCaretaker = NoteCaretaker()

        activityNoteBinding.apply {
            saveButton.setOnClickListener {
                noteCaretaker.saveMetomo(
                    noteLayout.createMemoto()
                )
            }

            revokeButton.setOnClickListener {
                noteCaretaker.getPrevMemoto()?.let {
                    noteLayout.restore(
                        it
                    )
                }
            }

            redoButton.setOnClickListener {
                noteCaretaker.getNextMemoto()?.let {
                    noteLayout.restore(
                        it
                    )
                }
            }

        }
    }
}