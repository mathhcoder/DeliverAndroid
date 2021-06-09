package com.example.deliverandroid.view.clock

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color.parseColor
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class ClockBackground@JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : View(context, attributeSet, defStyleAttr, defStyleRes) {
    var radius = 24F
        set(value){
            field = value
            invalidate()
        }
    var strokeColor : String = "#99AAB5"
        set(value){
            field = value
            invalidate()
        }
    var centerColor : String = "#66757F"
        set(value){
            field = value
            invalidate()
        }
    var backColor : Int = parseColor("#E1E8ED")
        set(value){
            field = value
            invalidate()
        }
    private val paint  =  Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.style = Paint.Style.FILL
        paint.color = backColor
        canvas?.drawCircle(radius , radius , radius , paint)

        paint.color = parseColor(centerColor)
        canvas?.drawCircle(radius , radius , radius/24 , paint)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = radius/9

        paint.color = parseColor(strokeColor)
        canvas?.drawCircle(radius , radius ,radius - radius/18 , paint)

    }
}