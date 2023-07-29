package com.example.designpatternsapp.combinationmodel.dir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityDirBinding

class DirActivity : AppCompatActivity() {
    private lateinit var activityDirBinding: ActivityDirBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDirBinding = ActivityDirBinding.inflate(layoutInflater)
        setContentView(activityDirBinding.root)
        val dick = Folder("C").apply {
            addDir(Folder("Game").apply {
                addDir(File("Cross Channel"))
                addDir(File("summer pockets"))
                addDir(Folder("Minori").apply {
                    addDir(File("Eden*"))
                    addDir(File("ef"))
                })
            })
            addDir(File("Air"))
            addDir(File("Clannad"))

        }
        activityDirBinding.apply {
            checkFileBbutton.setOnClickListener {
                filesText.setText(
                    dick.prinfFiles()
                )
            }
        }
    }
}