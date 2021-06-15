package com.example.deliverandroid.ui.home.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.deliverandroid.base.model.LocationModel
import com.example.deliverandroid.base.model.PaymentModel
import com.example.deliverandroid.base.model.PaymentStatusModel
import com.example.deliverandroid.base.model.ProductModel
import uz.muslimaat.app.base.model.BaseModel

@Entity(tableName = "order")

data class OrderEntity(
    @PrimaryKey var id : Long? = 0,
    var number: Int? = 0,
    var paymentStatus: PaymentStatusModel,
    var time: Long? = 0,
    var prise: Long? = 0,
    var payment: PaymentModel? = null,
    var address: LocationModel? = null,
    var orderType: OrderType? = null,
    var commints: String? = "",
    var products: List<ProductModel>,
    var prepayment: Boolean? = false,
    var tel: String? = "+998 97 925 38 09",
) : BaseModel()