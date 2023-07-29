package com.example.designpatternsapp.ordermodel

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path


interface IBrush{

    /**
     * TODO
     *
     * @param path 路径对象
     * @param x    当前位置的x坐标
     * @param y    当前位置的y坐标
     */
    fun down(path: Path, x: Float, y: Float)

    /**
     * TODO
     *
     * @param path 路径对象
     * @param x    当前位置的x坐标
     * @param y    当前位置的y坐标
     */
    fun move(path: Path , x: Float , y: Float)

    /**
     * TODO
     *
     * @param path 路径对象
     * @param x    当前位置的x坐标
     * @param y    当前位置的y坐标
     */
    fun up(path: Path , x: Float , y: Float)
}

class NormalBrush : IBrush{

    override fun down(path: Path, x: Float, y: Float) {
        path.moveTo(x , y)
    }

    override fun move(path: Path, x: Float, y: Float) {
        path.lineTo(x , y)
    }

    override fun up(path: Path, x: Float, y: Float) {
    }
}

class CircleBrush : IBrush{

    override fun down(path: Path, x: Float, y: Float) {

    }

    override fun move(path: Path, x: Float, y: Float) {
        path.addCircle(x , y , 10f , Path.Direction.CW)
    }

    override fun up(path: Path, x: Float, y: Float) {
    }
}

interface IDraw{

    /**
     * TODO 绘制命令
     *
     * @param canvas 画布对象
     */
    fun draw(canvas: Canvas)

    /**
     * TODO 撤销命令
     *
     */
    fun undo()
}

// 具体绘制路径的命令
class DrawPath(
    val path: Path,
    private val paint: Paint
) : IDraw{

    override fun draw(canvas: Canvas) {
        canvas.drawPath(path, paint)
    }

    override fun undo() {
    }
}

// 命令请求者
class DrawInvoker{

    private val drawList = mutableListOf<DrawPath>()
    private val redoList = mutableListOf<DrawPath>()

    /**
     * TODO 增加一个命令
     *
     * @param drawPath
     */
    fun add(drawPath: DrawPath){
        redoList.clear()
        drawList.add(drawPath)
    }

    /**
     * TODO 撤销上一步的命令
     *
     */
    fun undo(){
        if(drawList.isNotEmpty()){
            val index = drawList.size - 1
            val undo = drawList[index]
            drawList.removeAt(index)
            undo.undo()
            redoList.add(undo)
        }
    }

    /**
     * TODO 重做上一步撤销的命令
     *
     */
    fun redo(){
        if(redoList.isNotEmpty()){
            val index = redoList.size - 1
            val redoCommand = redoList[index]
            redoList.removeAt(index)
            drawList.add(redoCommand)
        }
    }

    /**
     * TODO 执行命令
     *
     * @param canvas
     */
    fun excute(canvas: Canvas){
        if(drawList.isNotEmpty()){
            drawList.forEach {
                synchronized(this){
                    it.draw(canvas)
                }
            }
        }
    }

    /**
     * TODO 是否可以重做
     */
    fun canRedo() = redoList.isNotEmpty()

    /**
     * TODO 是否可以撤销
     *
     */
    fun canUndo() = drawList.isNotEmpty()
}