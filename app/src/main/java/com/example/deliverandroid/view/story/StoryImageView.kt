@file:Suppress("DEPRECATION")

package com.example.deliverandroid.view.story

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.deliverandroid.R
import com.google.android.material.card.MaterialCardView

@Suppress("DEPRECATION")
class StoryImageView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
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

    init {
        repeat(imagesCount) {
            val view = MaterialCardView(context)
            view.also { v ->
                v.strokeWidth = resources.getDimension(R.dimen.margin_0_5x).toInt()
                v.strokeColor = resources.getColor(R.color.white_dark)
                v.radius = resources.getDimension(R.dimen.margin_6x)
                v.elevation = 0F
            }


            val imageView = ImageView(context)
            imageView.layoutParams = LayoutParams(-2, -2)
            imageView.setBackgroundColor(Color.WHITE)


            val size = resources.getDimension(R.dimen.margin_12x).toInt()
            val layoutParams = LayoutParams(size, size)



            imageView.layoutParams = layoutParams
            imageView.id = when (it) {
                0 -> R.id.imageView_1
                1 -> R.id.imageView_2
                else -> R.id.imageView_3
            }

            view.addView(imageView)
            Glide.with(context)
                .load(listUrlImages[it])
                .centerCrop()
                .placeholder(R.drawable.ic_balance)
                .into(imageView)
            imageView.setColorFilter(resources.getColor(R.color.white_dark))
            val lp = LayoutParams(-2, -2)
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
