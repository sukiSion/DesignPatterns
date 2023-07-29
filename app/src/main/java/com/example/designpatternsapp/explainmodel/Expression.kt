package com.example.designpatternsapp.explainmodel

import android.content.Context
import java.util.Stack


interface Expression {
    fun interpreter(): Int
}

// 抽象非终结符表达式
// 通常由该子类定义运算
abstract class  NonTerminalExpression(val e1: Expression , val e2: Expression): Expression

// 减法表达式
class MinusOperation( e1: Expression ,  e2: Expression) : NonTerminalExpression(e1 , e2){

    override fun interpreter(): Int {
        return e1.interpreter() - e2.interpreter()
    }
}

// 加法表达式
class PlusOperation(e1: Expression , e2: Expression): NonTerminalExpression(e1 , e2){
    override fun interpreter(): Int {
        return e1.interpreter() + e2.interpreter()
    }
}

// 终结符表达式
class TerminalExpression(val variable: Int) :Expression{

    override fun interpreter(): Int {
        return variable
    }
}

// 新建计算类处理与解析相关的一些业务
class Calculator(expression: String){
    private val expStack: Stack<Expression>

    init {
        expStack = Stack()
        var index = 0
        while (index <= expression.length - 1) {
            val c = expression[index]
            if (c == '+') {
                val pop = expStack.pop()
                expStack.push(
                    PlusOperation(
                        pop,
                        TerminalExpression(
                            expression[++index].digitToInt()
                        )
                    )
                )
            } else if (c == '-') {
                val pop = expStack.pop()
                expStack.push(
                    MinusOperation(
                        pop,
                        TerminalExpression(
                            expression[++index].digitToInt()
                        )
                    )
                )
            } else {
                expStack.push(
                    TerminalExpression(
                        expression[index].digitToInt()
                    )
                )
            }
            index++
        }

    }

    fun calculate(): Int{
        return expStack.pop().interpreter()
    }
}



