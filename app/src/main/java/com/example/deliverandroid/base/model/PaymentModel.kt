package com.example.deliverandroid.base.model


data class PaymentModel(
    val id : Int,
    val name : String
) {
    companion object{

        val cash = PaymentModel(0 ,"Cash")
        val click = PaymentModel(1 , "Click")
        val payme = PaymentModel(2 , "Payme")
    }
}