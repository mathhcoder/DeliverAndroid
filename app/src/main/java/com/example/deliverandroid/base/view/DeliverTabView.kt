package com.example.deliverandroid.base.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.example.deliverandroid.base.ext.getColorFromAttr
import com.example.deliverandroid.R

import kotlinx.android.synthetic.main.layout_select.view.*

class DeliverTabView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attributeSet, defStyleAttr), OnSelected {


    init {
        inflate(context, R.layout.layout_select, this)
        textViewFirst?.setOnClickListener {
            textViewFirst?.setTextColor(getColorFromAttr(R.attr.colorOnPrimary))
            textViewSecond?.setTextColor(getColorFromAttr(R.attr.colorOnBackground))
            layoutIndicator?.animate()?.translationX(0f)
                ?.withEndAction {
                    onFirst()
                }?.start()
        }

        textViewSecond?.setOnClickListener {
            textViewSecond?.setTextColor(getColorFromAttr(R.attr.colorOnPrimary))
            textViewFirst?.setTextColor(getColorFromAttr(R.attr.colorOnBackground))
            layoutIndicator?.animate()?.translationX(
                textViewFirst?.width?.toFloat()
                    ?: 0f - textViewFirst.resources.getDimension(R.dimen.margin_x)
            )?.withEndAction {
                onSecond()
            }?.start()
        }
    }

    fun selectTab(isFirst: Boolean) {
        textViewFirst?.post {
            if (isFirst) {
                textViewFirst?.setTextColor(getColorFromAttr(R.attr.colorOnPrimary))
                textViewSecond?.setTextColor(getColorFromAttr(R.attr.colorOnBackground))
                layoutIndicator.translationX = 0f

            } else {
                textViewSecond?.setTextColor(getColorFromAttr(R.attr.colorOnPrimary))
                textViewFirst?.setTextColor(getColorFromAttr(R.attr.colorOnBackground))
                layoutIndicator.translationX = textViewFirst?.width?.toFloat()
                    ?: 0f - textViewFirst.resources.getDimension(R.dimen.margin_x)
            }
        }
    }

    var firstText: String? = ""
        set(value) {
            textViewFirst?.text = value
            field = value
        }

    var secondText: String? = ""
        set(value) {
            textViewSecond?.text = value
            field = value
        }

    var onFirst: () -> Unit? = {}

    var onSecond: () -> Unit? = {}

    var bgColor: String? = ""
        set(value) {
            textViewSecond?.text = value
            field = value
        }

}