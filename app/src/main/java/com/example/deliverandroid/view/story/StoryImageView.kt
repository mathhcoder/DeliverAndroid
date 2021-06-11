package com.example.deliverandroid.view.story

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.deliverandroid.R
import com.google.android.material.card.MaterialCardView

@Suppress("DEPRECATION")
class StoryImageView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : FrameLayout(context, attributeSet) {

    var listUrlImages: List<String> = listOf(
        "https://sag.uz/image/collection_1552388131.jpg",
        "https://sag.uz/image/collection_1588574294.jpg"
    )
        set(value) {
            field = value
            invalidate()
        }

    var imagesCount = Math.min(listUrlImages.size, 3)
    var viewsList: ArrayList<MaterialCardView> = arrayListOf()
    var imagesList: ArrayList<AppCompatImageView> = arrayListOf()

    init {
        val x = resources.getDimension(R.dimen.margin_0_5x).toInt()
        repeat(imagesCount) { it ->
            val view = MaterialCardView(context, null, R.style.Widget_Deliver_Card_StoryItem)

            view.also {
                val color = Color.parseColor("#F0F0F0")
                it.setCardBackgroundColor(color)
                it.radius = resources.getDimension(R.dimen.margin_6x)
                it.cardElevation = 0F
            }

            val inview = MaterialCardView(context)

            inview.also { inv ->
                inv.radius = resources.getDimension(R.dimen.margin_5x)
                val color = resources.getColor(R.color.white)
                inv.setCardBackgroundColor(color)
                inv.cardElevation = 0F
            }
            val imageView = AppCompatImageView(context)

            imageView.layoutParams = LayoutParams(-1, -1)
            imageView.setBackgroundColor(Color.WHITE)

            inview.addView(imageView)

            val lpV = LayoutParams(x * 22, x * 22)
            lpV.setMargins(x, x, x, x)
            view.addView(inview, lpV)





            val lp = LayoutParams(x * 24, x * 24)
            val left: Int =
                if (it == 0) 0 else (it - 1) * resources.getDimension(R.dimen.margin_12x)
                    .toInt() + resources.getDimension(R.dimen.margin_9x).toInt()

            lp.setMargins(left, 0, 0, 0)
            view.layoutParams = lp
            viewsList.add(view)
            this.addView(view)
        }


    }

}
