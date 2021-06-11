package com.example.deliverandroid.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.deliverandroid.R
import com.example.deliverandroid.model.OrderModel
import com.example.deliverandroid.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_order_info.*
import kotlinx.android.synthetic.main.layout_header.*

class OrderInfoFragment : BaseFragment() {

    private val model by lazy {
        arguments?.getSerializable("model") as? OrderModel?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_order_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageViewHeaderBack.visibility = View.VISIBLE
        imageViewHeaderBack.setOnClickListener {
            findNavController().popBackStack()
        }

        Log.e("model_", model.toString())
        model?.let {
            textViewHeader.text = "Buyurtma #${it.number}"
            textViewPrice.text = "Umumiy narx : ${it.prise} so'm"
            textViewPaymentMethod.text = "To'lov usuli : ${it.payment?.name}"
            textViewPaymentStatus.text = "To'lov : ${it.paymentStatus.type}"
            textViewPrePayment.text =
                "Oldindan to'lov : ${if (it.prepayment == true) "True" else "False"}"

            textViewOrderType.text = "Buyurtma turi: ${it.orderType?.type}"
            textViewReceiverName.text = "Ismi: ${it.number}"
        }


    }
}
