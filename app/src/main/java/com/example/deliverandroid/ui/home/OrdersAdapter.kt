package com.example.deliverandroid.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.deliverandroid.R
import com.example.deliverandroid.base.model.CellType
import com.example.deliverandroid.ui.home.model.OrderModel
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.cell_order.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class OrdersAdapter(
    private val onItemClicked: (model: OrderModel) -> (Unit)
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: List<OrderModel> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()

            Log.e("AAAA" , data.toString())
        }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> if (data.size == 1) CellType.SINGLE.value else CellType.TOP.value
            data.lastIndex -> CellType.BOTTOM.value
            else -> CellType.MIDDLE.value
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val cellRes = when (viewType) {
            CellType.TOP.value -> R.layout.cell_vertical
            CellType.SINGLE.value -> R.layout.cell_vertical
            CellType.BOTTOM.value -> R.layout.cell_vertical
            else -> R.layout.cell_vertical
        }
        val cell = inflater.inflate(cellRes, parent, false) as ViewGroup
        val cardViewCell = cell.findViewById<MaterialCardView>(R.id.cardViewCell)

        val layout = inflater.inflate(R.layout.cell_order, cardViewCell, false)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val top = parent.context.resources.getDimension(R.dimen.margin_4x).toInt()

        if(viewType != CellType.BOTTOM.value)
            params.setMargins(0,top, 0 , 0 )
        else
            params.setMargins(0 , top , 0 , top)

        cell.layoutParams = params

        val holder = ItemHolder(cell)

        cardViewCell?.addView(layout)

        cardViewCell?.setOnClickListener {
            data.getOrNull(holder.adapterPosition)?.let{
                onItemClicked(it)
            }
        }

        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        data.getOrNull(position)?.let {
            when (holder) {
                is ItemHolder -> {
                    holder.bind(it)
                }
            }
        }
    }

    override fun getItemCount() = data.size

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textViewTime: TextView? = itemView.textViewTime
        private val textViewTitle: TextView? = itemView.textViewTitle
        private val textViewProducts: TextView? = itemView.textViewProducts
        private val textViewLocation: TextView? = itemView.textViewLocation
        private val textViewCommentary: TextView? = itemView.textViewCommentary
        private val textViewPaymentTitle: TextView? = itemView.textViewPaymentTitle
        private val textViewPaymentSubtitle: TextView? = itemView.textViewPaymentSubtitle
        private val imageView1 : ImageView? = itemView.findViewById(R.id.imageView_1)


        fun bind(model: OrderModel) {

            val pattern = "dd.MM.yyyy - kk:mm"
            val simpleDateFormat = SimpleDateFormat(pattern)
            val current = Date(model.time!! - Calendar.getInstance().get(Calendar.ZONE_OFFSET))
            val date = simpleDateFormat.format(current)


            itemView.textViewCommentary.text = model.commints
            itemView.textViewTime.text = date
            itemView.textViewTitle?.text = "Buyurtma #${model.number}"
            itemView.textViewProducts?.text = model.products.toString()
            itemView.textViewLocation?.text = model.address.toString()
            itemView.textViewCommentary?.text = model.commints
            itemView.textViewPaymentTitle?.text = model.payment?.name
            itemView.textViewPaymentSubtitle?.text = model.paymentStatus.type
            itemView.clockView.clockRadius = 16F


            itemView.clockView?.time = model.time!!

//            Glide.with(itemView.context)
//                .load(model.products[0].image)
//                .centerCrop()
//                .into(itemView.findViewById(R.id.imageView_1))
//
//            Glide.with(itemView.context)
//                .load(model.products[1].image)
//                .centerCrop()
//                .into(itemView.findViewById(R.id.imageView_2))


        }
    }
}