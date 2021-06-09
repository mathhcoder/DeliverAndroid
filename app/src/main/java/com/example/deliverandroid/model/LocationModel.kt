package com.example.deliverandroid.model

import com.example.deliverandroid.BaseModel


data class LocationModel(
    val lat : Double,
    val lng : Double,
    val alt : Double,
    val name : String,


) : BaseModel(){
    companion object {
        val TASHKENT = LocationModel(
            lat = 41.2995,
            lng = 69.2401,
            alt = 0.0,
            name = "Tashkent"
        )
    }
}