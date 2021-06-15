package com.example.deliverandroid.ui.home.model

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
interface OrderApi {

    @GET("question/categories")
    fun getAll(): Single<List<OrderEntity>>
}