package com.example.deliverandroid.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliverandroid.R
import com.example.deliverandroid.model.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_header.*
import java.util.*

class HomeFragment : Fragment() {


    private lateinit var ordersAdapter: OrdersAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textViewHeader.text = getString(R.string.my_orders)
        imageViewHeaderBack.visibility = View.GONE

        ordersAdapter = OrdersAdapter {
            val bundle = Bundle()
            bundle.putSerializable("model", it)
            Log.e("model","PUT , $it")
            findNavController().navigate(R.id.action_navigation_home_to_fragment_order_info, bundle)
        }

        recyclerView.adapter = ordersAdapter
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        val productsList = listOf(
            ProductModel(
                id = 1,
                name = "Katta gilam",
                size = "400x600",
                image = "https://sag.uz/image/collection_1552388131.jpg"
            ),
            ProductModel(
                id = 1,
                name = "Katta gilam",
                size = "400x600",
                image = "https://sag.uz/image/collection_1552388131.jpg"
            ),
            ProductModel(
                id = 1,
                name = "Katta gilam",
                size = "400x600",
                image = "https://sag.uz/image/collection_1552388131.jpg"
            ),
            ProductModel(
                id = 1,
                name = "Katta gilam",
                size = "400x600",
                image = "https://sag.uz/image/collection_1552388131.jpg"
            )
        )
        ordersAdapter.data = listOf(
            OrderModel(
                id = 1,
                number = 1021,
                payment = PaymentModel(1, "Click"),
                time = Calendar.getInstance().timeInMillis + Calendar.getInstance().get(Calendar.ZONE_OFFSET),
                prise = 30000,
                paymentStatus = PaymentStatusModel(1, "not yet"),
                address = LocationModel.TASHKENT,
                commints = "some commit",
                products = productsList,
                prepayment = false,
                tel = "+998979253809",
            ),
            OrderModel(
                id = 1,
                number = 1021,
                payment = PaymentModel(1, "Click"),
                time = (Math.random() * 86400 * 1000 * 10000).toLong(),
                prise = 30000,
                paymentStatus = PaymentStatusModel(1, "not yet"),
                address = LocationModel.TASHKENT,
                commints = "some commit",
                products = productsList,
                prepayment = false,
                tel = "+998979253809",
            ),
            OrderModel(
                id = 1,
                number = 1021,
                payment = PaymentModel(1, "Click"),
                time = (Math.random() * 86400 * 1000 * 10000).toLong(),
                prise = 30000,
                paymentStatus = PaymentStatusModel(1, "not yet"),
                address = LocationModel.TASHKENT,
                commints = "some commit",
                products = productsList,
                prepayment = false,
                tel = "+998979253809",
            ),
            OrderModel(
                id = 1,
                number = 1021,
                payment = PaymentModel(1, "Click"),
                time = 1623087605023,
                prise = 30000,
                paymentStatus = PaymentStatusModel(1, "not yet"),
                address = LocationModel.TASHKENT,
                commints = "some commit",
                products = productsList,
                prepayment = false,
                tel = "+998979253809",
            ),
        )

    }


}