package com.example.deliverandroid.view.clock

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.widget.FrameLayout
import com.google.android.material.card.MaterialCardView
import java.util.*
import kotlin.math.roundToInt

class SimpleClockView(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    private val hourLine = MaterialCardView(context)
    private val minuteLine = MaterialCardView(context)
    private val background = MaterialCardView(context)


    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    var time: Long = Calendar.getInstance().timeInMillis / 1000
        set(value) {
            field = (value % 86_400_000) / 1000
            update()
        }
    var clockRadius: Float = 16F
        set(value) {
            field = value
            invalidate()
        }
    var colorStroke: String = "#99AAB5"
        set(value) {
            field = value
            update()
        }
    var colorBg: String = "#E1E8ED"
        set(value) {
            field = value
            update()
        }
    var colorLine: String = "#66757F"
        set(value) {
            field = value
            update()
        }

    var colorCenter: String = colorLine
        set(value) {
            field = value
            update()
        }

    var radioLineMinute: Float = 0.8F
        set(value) {
            field = value
            update()
        }
    var ratioHourLine: Float = 0.6F
        set(value) {
            field = value
            update()
        }

    init {

        addBackground()
        addHourLine()
        addMinuteLine()

        updateLines()

    }

    fun update() {
        removeAllViews()

        Log.e("customViewUpdate", "$childCount")
        addBackground()
        addHourLine()
        addMinuteLine()

        updateLines()
    }

    private fun addBackground() {
        background.also {
            it.setCardBackgroundColor(Color.parseColor(colorBg))
            it.strokeColor = Color.parseColor(colorStroke)
            it.strokeWidth = (clockRadius / 18).roundToInt()
            it.cardElevation = 0F
            it.radius = clockRadius
        }

        addView(
            background, LayoutParams((clockRadius * 2).toInt(), (clockRadius * 2).toInt())
        )
    }

    private fun addMinuteLine() {
        minuteLine.also {
            it.setCardBackgroundColor(Color.parseColor(colorLine))
            it.radius = clockRadius / 24
            it.cardElevation = 0F
            it.pivotX = clockRadius / 24
            it.pivotY = clockRadius / 24
        }
        addView(
            minuteLine,
            LayoutParams(
                (clockRadius / 12).roundToInt(),
                (clockRadius * radioLineMinute).roundToInt()
            )
        )

        minuteLine.layoutParams = (minuteLine.layoutParams as LayoutParams).apply {
            setMargins((clockRadius * 23 / 24).toInt(), (clockRadius * 23 / 24).toInt(), 0, 0)
        }


    }

    private fun addHourLine() {
        hourLine.also {
            it.setCardBackgroundColor(Color.parseColor(colorLine))
            it.radius = clockRadius / 24
            it.cardElevation = 0F
            it.pivotX = clockRadius / 24
            it.pivotY = clockRadius / 24
        }
        addView(
            hourLine,
            LayoutParams(
                (clockRadius / 12).roundToInt(),
                (clockRadius * ratioHourLine).roundToInt()
            )
        )
        hourLine.layoutParams = (hourLine.layoutParams as LayoutParams).apply {
            setMargins((clockRadius * 23 / 24).toInt(), (clockRadius * 23 / 24).toInt(), 0, 0)
        }
        hourLine.rotation = 90F


    }


    private fun updateLines() {
        val degMinutes = time.toFloat() / 10 + 180
        val degHour = time.toFloat() / 120 + 180

        minuteLine.rotation = degMinutes
        hourLine.rotation = degHour
    }
}