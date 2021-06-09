package com.example.deliverandroid.view.clock

import android.content.Context
import android.graphics.Color
import android.graphics.Color.parseColor
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.deliverandroid.R

class ClockView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    private val clockBackground = ClockBackground(context)
    private val hourLine = ClockLine(context)
    private val minuteLine = ClockLine(context)


    var time: Long = 1617433844217L
        set(value) {
            field = value % 86400 * 1000
            updateLines()
        }
    var clockRadius: Float = 24F
        set(value) {
            field = value
            clockBackground.radius = value
            hourLine.radius = value
            minuteLine.radius = value

            updateLines()
        }
    var colorStroke: String = "#99AAB5"
        set(value) {
            field = value
            clockBackground.strokeColor = value
        }
    var colorBg: Int = parseColor("#E1E8ED")
        set(value) {
            field = value
            clockBackground.backColor = value
        }
    var colorLine: Int = Color.parseColor("#66757F")
        set(value) {
            field = value
            hourLine.lineColor = value
        }

    init {
        setupAttrs(attrs)

        addView(
            clockBackground, LayoutParams(
                -1,
                -1
            )
        )

        hourLine.pivotY = clockRadius / 24
        hourLine.pivotX = clockRadius / 24
        hourLine.ratio = 0.6F

        minuteLine.pivotY = clockRadius / 24
        minuteLine.pivotX = clockRadius / 24

        addView(
            hourLine, LayoutParams(-1, -1)
        )

        addView(
            minuteLine, LayoutParams(-1, -1)
        )

        hourLine.layoutParams = (hourLine.layoutParams as LayoutParams).apply {
            setMargins((clockRadius * 23 / 24).toInt(), (clockRadius * 23 / 24).toInt(), 0, 0)
        }

        minuteLine.layoutParams = (minuteLine.layoutParams as LayoutParams).apply {
            setMargins((clockRadius * 23 / 24).toInt(), (clockRadius * 23 / 24).toInt(), 0, 0)
        }

        updateLines()

    }

    private fun updateLines() {
        val degMinutes = (time.toFloat() % (3600 * 1000)) / (3600 * 1000) * 360 - 90F
        val degHour = (time.toFloat() / (86400 * 1000) * 720) - 90F

        minuteLine.rotation = degMinutes
        hourLine.rotation = degHour
    }

    private fun setupAttrs(attrs: AttributeSet){
//
//        colorBg = attrs.getAttributeResourceValue(R.attr.clockBackgroundColor , R.color.white)
//        clockRadius = attrs.getAttributeFloatValue(R.attr.clockRadius , 24F)
//        colorBg = attrs.getAttributeIntValue(R.attr.clockBackgroundColor , parseColor("#E1E8ED"))
//        colorLine = attrs.getAttributeIntValue(R.attr.clockLineColor , parseColor("#66757F"))
    }
}