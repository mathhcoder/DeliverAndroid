package com.example.deliverandroid.model

import com.example.deliverandroid.BaseModel

data class PaymentStatusModel(
    var id : Int = 0,
    var type : String
) : BaseModel(){
    companion object{

    }
}