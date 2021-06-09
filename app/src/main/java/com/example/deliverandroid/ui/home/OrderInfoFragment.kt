package com.example.deliverandroid.ui.home

import android.os.Bundle
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


    val model = arguments?.getSerializable("model") as OrderModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_order_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewHeader.text = "Buyurtma #${model.number}"
        imageViewHeaderBack.visibility = View.VISIBLE
        imageViewHeaderBack.setOnClickListener {
            findNavController().popBackStack()
        }


        textViewPrice.text = "Umumiy narx : ${model.prise} so'm"
        textViewPaymentMethod.text = "To'lov usuli : ${model.payment?.name}"
        textViewPaymentStatus.text = "To'lov : ${model.paymentStatus.type}"
        textViewPrePayment.text = "Oldindan to'lov : ${if(model.prepayment == true) "True" else "False" }"

        textViewOrderType.text = "Buyurtma turi: ${model.orderType?.type}"
        textViewReceiverName.text = "Ismi: ${model.number}"

    }
}