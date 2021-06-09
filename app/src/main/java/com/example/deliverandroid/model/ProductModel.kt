package com.example.deliverandroid.model

import com.example.deliverandroid.BaseModel

class ProductModel(
    var id: Long? = 0,
    var name: String? = "",
    var size: String? = "",
    var image: String? = "",
) : BaseModel()