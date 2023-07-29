package com.example.designpatternsapp.ordermodel

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.example.designpatternsapp.R
import com.example.designpatternsapp.databinding.ActivityBrushBinding

class BrushActivity : AppCompatActivity() {
    private lateinit var activityBrushBinding: ActivityBrushBinding
    private lateinit var mPath: DrawPath
    private lateinit var mPaint: Paint
    private lateinit var mBrush: IBrush

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBrushBinding = ActivityBrushBinding.inflate(layoutInflater)
        setContentView(activityBrushBinding.root)
        mPaint = Paint().apply {
            strokeWidth = 3f
            color = Color.WHITE
            style = Paint.Style.STROKE
        }
        mBrush = NormalBrush()
        activityBrushBinding.apply {
            revokeButton.isEnabled = false
            repaintButton.isEnabled = false
            redButton.setOnClickListener {
                mPaint = Paint().apply {
                    color = Color.RED
                    strokeWidth = 3f
                    style = Paint.Style.STROKE
                }
            }
            greenButton.setOnClickListener {
                mPaint = Paint().apply {
                    color = Color.GREEN
                    strokeWidth = 3f
                    style = Paint.Style.STROKE
                }
            }
            blueButton.setOnClickListener {
                mPaint = Paint().apply {
                    color = Color.BLUE
                    strokeWidth = 3f
                    style = Paint.Style.STROKE
                }
            }
            revokeButton.setOnClickListener {
                brushSurfaceView.undo()
                enableButton()
            }
            repaintButton.setOnClickListener {
                brushSurfaceView.redo()
                enableButton()
            }
            normalBrushButton.setOnClickListener {
                mBrush = NormalBrush()
            }
            circleBrushButton.setOnClickListener {
                mBrush = CircleBrush()
            }
            brushSurfaceView.setOnTouchListener(
                object : View.OnTouchListener{
                    @SuppressLint("ClickableViewAccessibility")
                    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                        event?.apply {
                            action.apply {
                                if(this == MotionEvent.ACTION_DOWN){
                                    mPath = DrawPath(
                                        path = Path(),
                                        paint = mPaint
                                    )
                                    mBrush.down(mPath.path , x , y)
                                }else if(this == MotionEvent.ACTION_MOVE){
                                    mBrush.move(mPath.path , x , y)
                                }else if(this == MotionEvent.ACTION_UP){
                                    mBrush.up(mPath.path , x , y)
                                    brushSurfaceView.add(mPath)
                                    brushSurfaceView.setDrawing(true)
                                    revokeButton.isEnabled = true
                                }
                            }
                        }
                        return true
                    }
                }
            )
        }

    }

    private fun enableButton(){
        activityBrushBinding.apply {
            if(!brushSurfaceView.canUndo()){
                revokeButton.isEnabled = false
            }else{
                revokeButton.isEnabled = true
            }
            if(!brushSurfaceView.canRedo()){
                repaintButton.isEnabled = false
            }else{
                repaintButton.isEnabled = true
            }
        }
    }
}