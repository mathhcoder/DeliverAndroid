package com.example.deliverandroid.model

import com.example.deliverandroid.BaseModel

data class OrderModel(
    var id: Long? = 0,
    var number: Int? = 0,
    var paymentStatus : PaymentStatusModel,
    var time: Long? = 0,
    var prise: Long? = 0,
    var payment: PaymentModel? = null,
    var address: LocationModel? = null,
    var orderType: OrderType? = null,
    var commints: String? = "",
    var products: List<ProductModel>,
    var prepayment: Boolean? = false,
    var tel : String? = "+998 97 925 38 09",
) : BaseModel()