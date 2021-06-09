package com.example.deliverandroid.view.clock

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.parseColor
import android.util.AttributeSet
import android.view.View

class ClockLine @JvmOverloads constructor(
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
    var ratio = 0.8F
        set(value) {
            field = value
            invalidate()
        }
    var lineColor = parseColor("#66757F")
        set(value) {
            field = value
            invalidate()
        }

    private var paint = android.graphics.Paint(android.graphics.Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas?) {
        val itemLength = ratio * radius
        val itemWidth = radius / 12
        val itemRadius = radius / 24
        super.onDraw(canvas)
        paint.style = android.graphics.Paint.Style.FILL
        paint.color = lineColor
        canvas?.drawRoundRect(0F, 0F, itemLength, itemWidth, itemRadius, itemRadius, paint)
    }

}